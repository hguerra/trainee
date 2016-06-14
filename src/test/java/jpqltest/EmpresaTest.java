package jpqltest;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.modelbuilder.EmpresaBuilder;
import jpqltest.mock.EmpresaMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
}
