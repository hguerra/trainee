package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.modelbuilder.UniversidadeBuilder;
import jpqltest.mock.UniversidadeMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author heitor
 * @since 05/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class UniversidadeRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private UniversidadeRepository universidadeRepository;

    /**
     * @param universidadeRepository: UniversidadeRepository
     */
    public void setUniversidadeRepository(UniversidadeRepository universidadeRepository) {
        this.universidadeRepository = universidadeRepository;
    }

    @Ignore
    @Test
    public void persistUniversidadeTest() throws Exception {
        UniversidadeMock mock = new UniversidadeMock();
        Perfil[] perfils = {mock.getPerfil()};
        Curso[] cursos = {};

        Universidade universidade = new UniversidadeBuilder()
                .nome("FATEC SJC")
                .login("fatec_sjc")
                .senha("11")
                .endereco(mock.getEndereco())
                .image(mock.getImagem())
                .comPerfils(perfils).universidade()
                .cnpj("05.978.735/0001-08")
                .cursos(cursos)
                .get();

        universidadeRepository.save(universidade);

        assertTrue(universidade.getId() != null);
    }

    @Test
    public void findByCnpjTest() throws Exception {
        Universidade universidade = universidadeRepository.findByCnpj("05.978.735/0001-08");
        assertThat(universidade.getNome(), is("FATEC SJC"));
    }

    @Test
    public void findAllCursosTest() throws Exception {
        List<Curso> cursos = universidadeRepository.findAllCursos(2L);
        if(cursos == null)
            fail("Empty or null");
        assertTrue(!cursos.isEmpty());
    }
}
