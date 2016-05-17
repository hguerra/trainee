package jpqltest;

import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Rua;
import br.com.orbetail.gettrainee.model.security.Perfil;
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
import java.util.List;

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

    @Test
    public void findAllCursosTest() {
        Query q = entityManager.createQuery("select cursos from Universidade universidade inner join universidade.cursos cursos", Curso
                .class);

        List<Curso> cursos = q.getResultList();
        assertTrue(!cursos.isEmpty());
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
        endereco.setPais(empresa.getEndereco().getPais());
        endereco.setEstado(empresa.getEndereco().getEstado());
        endereco.setCidade(empresa.getEndereco().getCidade());

        Bairro bairro = new Bairro();
        bairro.setBairro("Eugênio de Melo");

        Rua rua = new Rua();
        rua.setRua("Av. Cesare Mansueto Giulio Lattes");

        endereco.setBairro(bairro);
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
}
