package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.modelbuilder.EmpresaBuilder;
import jpqltest.mock.EmpresaMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author heitor
 * @since 05/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class EmpresaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private EmpresaRepository empresaRepository;

    /**
     * @param empresaRepository: EmpresaRepository
     */
    public void setEmpresaRepository(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Ignore
    @Test
    public void persistEmpresaTest() {
        EmpresaMock mock = new EmpresaMock();

        Perfil[] perfils = {mock.getPerfil()};
        String[] espcializacao = {"Ciencia"};

        Empresa empresa = new EmpresaBuilder()
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

        empresaRepository.save(empresa);

        assertTrue(empresa.getId() != null);
    }

    @Test
    public void findByCnpjTest() throws Exception {
        Empresa empresa = empresaRepository.findByCnpj("01.263.896/0005-98");
        assertThat(empresa.getNome(), is("INPE"));
    }

    @Test
    public void findByEspecializacaoTest() throws Exception {
        Set<String> especializacaoSet = new HashSet<>();
        especializacaoSet.add("Ciencia");

        Set<Empresa> empresas = empresaRepository.findByEspecializacaoIn(especializacaoSet);

        if (empresas == null)
            fail("Empty or null");

        assertTrue(!empresas.isEmpty());
    }
}
