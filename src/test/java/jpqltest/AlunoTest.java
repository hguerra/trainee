package jpqltest;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.model.aluno.*;
import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Rua;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.model.universidade.Disciplina;
import br.com.orbetail.gettrainee.modelbuilder.AlunoBuilder;
import jpqltest.mock.AlunoMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * @author heitor
 * @since 18/05/16.
 */
public class AlunoTest {
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
    public void persistHeitor() throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            /**
             * Consultas
             */

            //Endereco, Endereco da empresa com aluno ta invertido!
            Query queryEndereco = entityManager.createQuery("select empresa from Empresa as empresa where empresa" +
                    ".nome = " +
                    ":nome", Empresa.class);
            queryEndereco.setParameter("nome", "INPE");
            Empresa empresa = (Empresa) queryEndereco.getSingleResult();

            //Cursos
            Query queryCurso = entityManager.createQuery("select cursos from Curso as cursos", Curso.class);
            List<Curso> cursosList = queryCurso.getResultList();

            //Disciplinas
            Query queryDisciplina = entityManager.createQuery("select disciplinas from Disciplina as disciplinas",
                    Disciplina.class);
            List<Disciplina> disciplinaList = queryCurso.getResultList();

            /**
             * Criar experiencia
             */

            Experiencia experiencia = new Experiencia();
            experiencia.setArea("Desenvolvimento");
            experiencia.setDescricao("Desenvolvimento de aplicacoes interativas utilizando Java e Microsoft Kinect");
            LocalDate dataInicio = LocalDate.of(2014, Month.AUGUST, 1);
            experiencia.setDataInicio(dataInicio);
            LocalDate dataTermino = LocalDate.of(2016, Month.JULY, 30);
            experiencia.setDataTermino(dataTermino);

            /**
             * Criar e persistir curriculo
             */
            //objetivo
            String objetivo = "Analise e desenvolvimento de sistemas";
            //cursos
            Set<Curso> cursos = new HashSet<>();
            cursos.addAll(cursosList);
            //disciplinas cursadas
            Set<Disciplina> disciplinas = new HashSet<>();
            disciplinas.addAll(disciplinaList);
            //experiencias
            Set<Experiencia> experiencias = new HashSet<>();
            experiencias.add(experiencia);

            Curriculo curriculo = new Curriculo();
            curriculo.setObjetivo(objetivo);
            curriculo.setCursos(cursos);
            curriculo.setDisciplinasCursadas(disciplinas);
            curriculo.setExperiencias(experiencias);

            entityManager.persist(curriculo);

            /**
             * Criar projetos
             */
            Projeto projeto = new Projeto();
            projeto.setNome("GetTrainee");
            projeto.setDescricao("Projeto Interdisciplinar FATEC");
            projeto.setDataInicio(LocalDate.of(2016, Month.FEBRUARY, 17));
            projeto.setDatatermino(LocalDate.of(2016, Month.JUNE, 14));

            Projeto[] portifolio = {projeto};
            /**
             * Criar competencias
             */
            Competencia competencia1 = new Competencia();
            competencia1.setPalavraChave("Java");
            competencia1.setDescricao("Desenvolvimento em Java SE, Java EE");

            Competencia competencia2 = new Competencia();
            competencia2.setPalavraChave("Web");
            competencia2.setDescricao("Desenvolvimento Web com Html 5, JS e CSS");

            Competencia competencia3 = new Competencia();
            competencia3.setPalavraChave("Kinect");
            competencia3.setDescricao("Dsenvolvimento de aplicacoes interaticas com Microsoft Kinect");

            Competencia competencia4 = new Competencia();
            competencia4.setPalavraChave("R");
            competencia4.setDescricao("Analise de dados geograficos em R");

            Competencia[] competencias = {competencia1, competencia2, competencia3, competencia4};
            /**
             * Criar publicacoes
             */
            Publicacao publicacao = new Publicacao();
            publicacao.setAutores(Arrays.asList("CARNEIRO, Heitor Guerra", "BERTOTI, Giuliano Araujo", "ANDRADE, " +
                    "Pedro Ribeiro"));
            publicacao.setTitulo("VISUALIZAÇÃO INTERATIVA DE DADOS GEOGRÁFICOS UTILIZANDO O KINECT");
            publicacao.setLivro("Boletim Técnico da Faculdade de Tecnologia de São Paulo v. 40");
            publicacao.setAno(LocalDate.of(2015, Month.OCTOBER, 7));
            publicacao.setPaginas("p.127");
            Publicacao[] publicacoes = {publicacao};
            /**
             * Criar idiomas
             */
            Idioma idioma1 = new Idioma();
            idioma1.setIdioma("Portugues");

            Idioma idioma2 = new Idioma();
            idioma2.setIdioma("Ingles");

            Idioma[] idiomas = {idioma1, idioma2};
            /**
             * Criar grupos
             */
            Grupo[] grupos = {};
            /**
             * Criar recomendacoes
             */
            Recomendacao[] recomendacoes = {};

            /**
             *
             *
             * Criar e persistir Aluno
             *
             *
             *
             */
            Endereco endereco = new Endereco();
            endereco.setPais(empresa.getEndereco().getPais());
            endereco.setEstado(empresa.getEndereco().getEstado());
            endereco.setCidade(empresa.getEndereco().getCidade());

            Bairro bairro = new Bairro();
            bairro.setBairro("Bosque dos Eucaliptos");

            Rua rua = new Rua();
            rua.setRua("Rua Cruzeiro");

            endereco.setBairro(bairro);
            endereco.setRua(rua);
            endereco.setNumero("224");

            entityManager.persist(endereco);


            AlunoMock mock = new AlunoMock();
            String cpf = "42198627817";
            String nome = "Heitor Guerra Carneiro";
            String login = "heitor";
            String senha = "11";
            Perfil[] perfils = {mock.getPerfil()};

            Aluno aluno = new AlunoBuilder()
                    .nome(nome)
                    .login(login)
                    .senha(senha)
                    .endereco(endereco)
                    .image(mock.getImagem())
                    .comPerfils(perfils)
                    .projetos(portifolio).aluno()
                    .cpf(cpf)
                    .curriculo(curriculo)
                    .competencias(competencias)
                    .publicacoes(publicacoes)
                    .idiomas(idiomas)
                    .grupos(grupos)
                    .recomendacoes(recomendacoes)
                    .get();

            entityManager.persist(aluno);
            transaction.commit();
            assertTrue(aluno.getId() != null);
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }

    @Ignore
    @Test
    public void addNovoProjetoAluno() {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery queryAluno = entityManager.createQuery("select a from Aluno a where a.cpf = :cpf", Aluno.class);
            queryAluno.setParameter("cpf", "42198627817");

            Aluno aluno = (Aluno) queryAluno.getSingleResult();

            /**
             * Criar projetos
             */
            Projeto projeto = new Projeto();
            projeto.setNome("GetTrainee");
            projeto.setDescricao("Projeto Interdisciplinar FATEC");
            projeto.setDataInicio(LocalDate.of(2016, Month.FEBRUARY, 17));
            projeto.setDatatermino(LocalDate.of(2016, Month.JUNE, 14));

            Set<Projeto> projetos = new HashSet<>();
            projetos.add(projeto);

            aluno.setProjetos(projetos);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }
}
