package jpqltest;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Rua;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.modelbuilder.UniversidadeBuilder;
import jpqltest.mock.UniversidadeMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * @author heitor
 * @since 17/05/16.
 */
public class UniversidadeTest {
    private static EntityManager entityManager;

    @BeforeClass
    public static void setUp() throws Exception {
        entityManager = SpringDataUtil.getEntityManager();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        entityManager.close();
    }

    @Ignore
    @Test
    public void persistFatecTest() throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query q = entityManager.createQuery("select cursos from Curso as cursos", Curso.class);
        List<Curso> cursosList = q.getResultList();

        Query queryEndereco = entityManager.createQuery("select empresa from Empresa as empresa where empresa.nome = " +
                ":nome", Empresa.class);
        queryEndereco.setParameter("nome", "INPE");

        Empresa empresa = (Empresa) queryEndereco.getSingleResult();

        UniversidadeMock mock = new UniversidadeMock();
        Perfil[] perfils = {mock.getPerfil()};
        Curso[] cursos = new Curso[cursosList.size()];


        UniversidadeBuilder universidadeBuilder = new UniversidadeBuilder();

        for (int i = 0; i < cursos.length; i++) {
            cursos[i] = cursosList.get(i);
        }

        Endereco endereco = new Endereco();

        Bairro bairro = new Bairro();
        bairro.setBairro("Eugênio de Melo");
        bairro.setCidade(empresa.getEndereco().getRua().getBairro().getCidade());

        Rua rua = new Rua();
        rua.setRua("Av. Cesare Mansueto Giulio Lattes");
        rua.setBairro(bairro);

        endereco.setRua(rua);
        endereco.setNumero("1.350");

        entityManager.persist(endereco);

        Universidade universidade = universidadeBuilder
                .nome("FATEC SJC")
                .login("fatec_sjc")
                .senha("11")
                .endereco(endereco)
                .image(mock.getImagem())
                .comPerfils(perfils).universidade()
                .cursos(cursos)
                .cnpj("05.978.735/0001-08")
                .get();

        entityManager.persist(universidade);

        transaction.commit();
    }

    @Ignore
    @Test
    public void findAllCursosTest() {
        Query q = entityManager.createQuery("select cursos from Universidade universidade inner join universidade" +
                ".cursos cursos", Curso
                .class);

        List<Curso> cursos = q.getResultList();
        assertTrue(!cursos.isEmpty());
    }

    @Ignore
    @Test
    public void editarRole() {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery queryUniversidade = entityManager.createQuery("select e from Universidade e where e.login = " +
                    ":login",
                    Universidade.class);
            queryUniversidade.setParameter("login", "fatec_sjc");

            Universidade universidade = (Universidade) queryUniversidade.getSingleResult();

            TypedQuery queryPublico = entityManager.createQuery("select e from Perfil e where e.nome = :nome",
                    Perfil.class);
            queryPublico.setParameter("nome", "ROLE_PUBLIC");

            Perfil perfilPublico = (Perfil) queryPublico.getSingleResult();
            universidade.getPerfils().add(perfilPublico);


            entityManager.merge(universidade);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }
}
