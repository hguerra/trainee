package jpqltest;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;
import br.com.orbetail.gettrainee.modelbuilder.EmpresaBuilder;
import jpqltest.mock.EmpresaMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 12/05/16.
 */
public class EmpresaTest {
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
    public void persistEmpresa() {
        EmpresaMock mock = new EmpresaMock();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Endereco endereco = mock.getEndereco();
        entityManager.persist(endereco);

        Perfil[] perfils = {mock.getPerfil()};
        String[] especializacao = {"Ciencia"};
        byte[] image = mock.getImagem();

        Empresa empresa = new EmpresaBuilder()
                .nome("INPE")
                .login("inpe")
                .senha("11")
                .endereco(endereco)
                .image(image)
                .comPerfils(perfils).empresa()
                .cnpj("01.263.896/0005-98")
                .descricao("Produzir ciência e tecnologia nas áreas espacial e do " +
                        "ambiente terrestre e oferecer produtos e serviços singulares em benefício do Brasil..")
                .especializacao(especializacao).get();

        entityManager.persist(empresa);
        transaction.commit();
    }

    @Ignore
    @Test
    public void editarEmpresa() {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery queryEmpresa = entityManager.createQuery("select e from Empresa e where e.login = :login",
                    Empresa.class);
            queryEmpresa.setParameter("login", "inpe");

            Empresa empresa = (Empresa) queryEmpresa.getSingleResult();

            System.out.println(empresa.getNome());
//
//            Set<Role> roles = new HashSet<>();
//            roles.add(Role.ROLE_PUBLIC);
//
//            Perfil perfil = new Perfil();
//            perfil.setNome("ROLE_PUBLIC");
//            perfil.setRoles(roles);
//
//            empresa.getPerfils().add(perfil);
//            entityManager.merge(empresa);

            Set<Role> roles = new HashSet<>();
            roles.add(Role.ROLE_EMPRESA);

            for (Perfil perfil : empresa.getPerfils()) {
                if (perfil.getRoles().isEmpty()) {
                    perfil.setRoles(roles);
                }
            }

            entityManager.merge(empresa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }
}
