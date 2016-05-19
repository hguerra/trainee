package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Projeto;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author heitor
 * @since 19/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class ProjetoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final Pageable PROJETO_MAX = new PageRequest(0, 5);
    private static final Long PROJETO_ID = 1L;


    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     * @param projetoRepository:ProjetoRepository
     */
    public void setProjetoRepository(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Test
    public void findByIdTest() throws Exception {
        Projeto projeto = projetoRepository.findById(PROJETO_ID);
        assertTrue(projeto != null);
    }

    @Test
    public void findProjetosRecentesAbertos1Test() throws Exception {
        List<Projeto> projetos = projetoRepository.findProjetosRecentesAbertos();
        assertTrue(!projetos.isEmpty());
    }

    @Test
    public void findProjetosRecentesAbertosTest() throws Exception {
        List<Projeto> projetos = projetoRepository.findProjetosRecentesAbertos(PROJETO_MAX);
        System.out.println(projetos.size());
        assertTrue(!projetos.isEmpty());
    }

}