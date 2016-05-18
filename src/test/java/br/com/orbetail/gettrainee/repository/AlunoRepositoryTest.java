package br.com.orbetail.gettrainee.repository;

import jpqltest.mock.AlunoMock;
import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.aluno.*;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.modelbuilder.AlunoBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

/**
 * @author heitor
 * @since 05/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class AlunoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * @param alunoRepository: AlunoRepository
     */
    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    @Test
    public void findAlunoTest() throws Exception {

    }

    @Test
    public void findAlunoCompetenciasPropertiesAlunoTest() throws Exception {

    }

    @Test
    public void findAllPropertiesAlunoTest() throws Exception {

    }

    @Test
    public void findByCpfTest() throws Exception {

    }

    @Test
    public void findByCurriculoTest() throws Exception {

    }

    @Test
    public void findByProjetoTest() throws Exception {

    }

    @Test
    public void findByCompenteciaTest() throws Exception {

    }

    @Test
    public void findByGrupoTest() throws Exception {

    }

    @Test
    public void findByRecomendacaoTest() throws Exception {

    }

    @Test
    public void findByRecomendacao1Test() throws Exception {

    }


}
