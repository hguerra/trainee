package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.endereco.Cidade;
import br.com.orbetail.gettrainee.model.endereco.Estado;
import br.com.orbetail.gettrainee.model.endereco.Pais;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author heitor
 * @since 12/06/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class EnderecoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final String PAIS = "Brasil";
    private static final String EMPRESA_RUA  = "Av. dos Astronautas".toUpperCase();
    private static final String EMPRESA_NUMERO  = "1.758";

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    private void assertList(List list) {
        if (list == null || list.isEmpty())
            fail("LIST IS NULL OR EMPTY");
    }


    @Test
    public void findPaisByNomeTest() throws Exception {
        Pais pais = enderecoRepository.findPaisByNome(PAIS);
        assertTrue(pais != null);
    }


    @Test
    public void findByPaisTest() throws Exception {
        Pais pais = enderecoRepository.findPaisByNome(PAIS);
        List<Estado> estados = enderecoRepository.findByPais(pais.getId());

        assertTrue(!estados.isEmpty());
    }

    @Test
    public void findByEstadoTest() throws Exception {
        Pais pais = enderecoRepository.findPaisByNome(PAIS);
        List<Estado> estados = enderecoRepository.findByPais(pais.getId());
        assertList(estados);

        Estado estado = estados.stream().findFirst().get();

        List<Cidade> cidades = enderecoRepository.findByEstado(estado.getId());
        assertTrue(!cidades.isEmpty());

    }

    @Test
    public void findByRuaNumeroTest() throws Exception {
        List<Endereco> enderecos = enderecoRepository.findByRuaNumero(EMPRESA_RUA,
                EMPRESA_NUMERO);

        assertTrue(!enderecos.isEmpty());
    }

}