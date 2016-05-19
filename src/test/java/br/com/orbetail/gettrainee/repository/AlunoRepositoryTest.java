package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.model.aluno.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

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
public class AlunoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String ALUNO_NOME = "Heitor Guerra Carneiro";
    private static final String ALUNO_USERNAME = "heitor";
    private static final String ALUNO_SENHA = "11";
    private static final String ALUNO_CPF = "42198627817";
    private static final Long ALUNO_ID = 3L;

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * @param alunoRepository: AlunoRepository
     */
    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * @param entityManagerFactory:EntityManagerFactory
     */
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Test
    public void findAlunoTest() throws Exception {
        Aluno aluno = alunoRepository.findById(ALUNO_ID);
        assertThat(aluno.getNome(), is(ALUNO_NOME));
    }

    @Test
    public void findAlunoFetchCompetenciasTest() throws Exception {
        Aluno aluno = alunoRepository.findAlunoFetchCompetencias(ALUNO_ID);

        try {
            Optional<Competencia> optionalCompetencia = aluno.getCompetencias().stream().map(comp -> comp).findAny();

            if (!optionalCompetencia.isPresent())
                fail("Competencia is Null");

            Competencia competencia = optionalCompetencia.get();

            assertTrue(!competencia.getPalavraChave().isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void findByCpfTest() throws Exception {
        Aluno aluno = alunoRepository.findByCpf(ALUNO_CPF);

        assertThat(aluno.getNome(), is(ALUNO_NOME));
    }

    @Test
    public void findByCurriculoTest() throws Exception {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Curriculo curriculo = null;
        try {
            transaction.begin();
            Query queryCurriculo = em.createQuery("select curriculo from Curriculo curriculo", Curriculo.class);
            curriculo = (Curriculo) queryCurriculo.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            fail(e.getMessage());
            if(transaction != null && transaction.isActive())
                transaction.rollback();
        } finally {
            em.close();
        }

        if(curriculo == null)
            fail("Curriculo is null");

        Aluno aluno = alunoRepository.findByCurriculo(curriculo);

        assertThat(aluno.getNome(), is(ALUNO_NOME));
    }

    @Test
    public void findByProjetoTest() throws Exception {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Projeto projeto = null;
        try {
            transaction.begin();
            Query queryProjeto = em.createQuery("select projeto from Projeto projeto", Projeto.class);
            projeto = (Projeto) queryProjeto.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            fail(e.getMessage());
            if(transaction != null && transaction.isActive())
                transaction.rollback();
        } finally {
            em.close();
        }

        if(projeto == null)
            fail("projeto is null");

        List<Aluno> alunos = alunoRepository.findByProjeto(projeto);

        assertTrue(!alunos.isEmpty());
    }

    @Test
    public void findByCompenteciaTest() throws Exception {
        List<Aluno> alunos = alunoRepository.findByCompentecia("Java".toUpperCase());

        assertTrue(!alunos.isEmpty());
    }

    @Test
    public void findByRecomendacaoTest() throws Exception {
        fail("Not implemented yet");
    }

}
