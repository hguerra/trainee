package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.modelbuilder.EmpresaBuilder;
import mock.EmpresaMock;
import org.junit.*;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author heitor
 * @since 17/05/16.
 */
public class EmpresaServiceTest {
    private static EmpresaService empresaService;
    private Empresa empresa;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        empresaService = new DefaultEmpresaService();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        empresaService = null;
    }

    @Before
    public void setUp() throws Exception {
        EmpresaMock mock = new EmpresaMock();

        Perfil[] perfils = {mock.getPerfil()};
        String[] espcializacao = {"Ciencia"};

        this.empresa = new EmpresaBuilder()
                .nome("INPE")
                .login("inpe")
                .senha("11")
                .endereco(mock.getEndereco())
                .image(mock.getImagem())
                .comPerfils(perfils).empresa()
                .cnpj("01.263.896/0005-98")
                .descricao("Produzir ciência e tecnologia nas áreas espacial e do " +
                        "ambiente terrestre e oferecer produtos e serviços singulares em benefício do Brasil..")
                .especializacao(espcializacao).get();
    }

    @After
    public void tearDown() throws Exception {
        this.empresa = null;
    }
    @Test
    public void salvar() throws Exception {
        Empresa refEmpresa = empresaService.salvar(empresa);
        assertTrue(refEmpresa.getId()!=null);
    }

    @Test(expected = Exception.class)
    public void excluir() throws Exception {
        empresaService.excluir(empresa.getId());
        empresaService.findByCnpj(empresa.getCnpj());
    }

    @Test
    public void findByCnpj() throws Exception {
        Empresa byCnpj = empresaService.findByCnpj("");
        assertThat(byCnpj.getNome(), is(empresa.getNome()));
    }

    @Test
    public void findByEspecializacao() throws Exception {
        String[] especializacao = {};
        fail();
    }

}