package br.com.orbetail.gettrainee.repository;

import jpqltest.mock.EmpresaMock;
import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.aluno.*;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.modelbuilder.AlunoBuilder;
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
    public void persistAlunoTest() throws Exception {
        EmpresaMock mock = new EmpresaMock();
        Perfil[] perfils = {mock.getPerfil()};
        Curso[] cursos = {};
        Curriculo curriculo = null;
        Projeto[] portifolio = {};
        Competencia[] competencias = {};
        Publicacao[] publicacoes = {};
        Idioma[] idiomas = {};
        Grupo[] grupos = {};
        Recomendacao[] recomendacoes = {};

        Aluno aluno = new AlunoBuilder()
                .nome("FATEC SJC")
                .login("fatec_sjc")
                .senha("11")
                .endereco(mock.getEndereco())
                .image(mock.getImagem())
                .comPerfils(perfils).aluno()
                .cpf("")
                .curriculo(curriculo)
                .portifolio(portifolio)
                .competencias(competencias)
                .publicacoes(publicacoes)
                .idiomas(idiomas)
                .grupos(grupos)
                .recomendacoes(recomendacoes)
                .get();

        alunoRepository.save(aluno);

        assertTrue(aluno.getId() != null);

    }
}
