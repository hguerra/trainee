package jpqltest;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.model.aluno.*;
import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Rua;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.model.universidade.Disciplina;
import br.com.orbetail.gettrainee.modelbuilder.AlunoBuilder;
import jpqltest.mock.AlunoMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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

            Bairro bairro = new Bairro();
            bairro.setBairro("Bosque dos Eucaliptos");
            bairro.setCidade(empresa.getEndereco().getRua().getBairro().getCidade());

            Rua rua = new Rua();
            rua.setRua("Rua Cruzeiro");
            rua.setBairro(bairro);

            endereco.setRua(rua);
            endereco.setNumero("224");

            entityManager.persist(endereco);


            AlunoMock mock = new AlunoMock();
            String cpf = "42198627817";
            String nome = "Heitor Guerra Carneiro";
            String login = "heitor";
            String senha = "11";
            Perfil[] perfils = {mock.getPerfil()};

            InputStream stream = new ByteArrayInputStream(mock.getImagem());
            BufferedImage imBuff = ImageIO.read(stream);
            BufferedImage resizedImg = resize(imBuff, 275, 75);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(resizedImg, "jpg", os);

            Aluno aluno = new AlunoBuilder()
                    .nome(nome)
                    .login(login)
                    .senha(senha)
                    .endereco(endereco)
                    .image(os.toByteArray())
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

            Set<Projeto> projetos = new HashSet<>();
            projetos.add(projeto);

            aluno.setProjetos(projetos);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }

    @Ignore
    @Test
    public void editarProjeto() {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery<Projeto> queryProjeto = entityManager.createQuery("select p from Projeto p", Projeto.class);
            List<Projeto> projetos = queryProjeto.getResultList();

            for (Projeto p : projetos) {
                p.setDataTermino(null);
                entityManager.merge(p);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }

    @Ignore
    @Test
    public void editarAlunoEmail() {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery queryAluno = entityManager.createQuery("select a from Aluno a where a.cpf = :cpf", Aluno.class);
            queryAluno.setParameter("cpf", "42198627817");

            Aluno aluno = (Aluno) queryAluno.getSingleResult();
            aluno.setEmail("heitorguerrac@gmail.com");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }


    @Ignore
    @Test
    public void editarRole() {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery queryAluno = entityManager.createQuery("select e from Aluno e where e.login = :login",
                    Aluno.class);
            queryAluno.setParameter("login", "heitor");

            Aluno aluno = (Aluno) queryAluno.getSingleResult();

            TypedQuery queryPublico = entityManager.createQuery("select e from Perfil e where e.nome = :nome",
                    Perfil.class);
            queryPublico.setParameter("nome", "ROLE_PUBLIC");

            Perfil perfilPublico = (Perfil) queryPublico.getSingleResult();
            aluno.getPerfils().add(perfilPublico);

            TypedQuery queryPerfilAluno = entityManager.createQuery("select e from Perfil e where e.nome = :nome",
                    Perfil.class);
            queryPerfilAluno.setParameter("nome", "ROLE_ALUNO");
            Perfil perfilAluno = (Perfil) queryPerfilAluno.getSingleResult();
            aluno.getPerfils().add(perfilAluno);

            for (Perfil p : aluno.getPerfils()) {
                if (p.getRoles().isEmpty()) {
                    Set<Role> roles = new HashSet<>();
                    roles.add(Role.ROLE_ALUNO);
                    p.setRoles(roles);
                }
            }

            aluno.getPerfils().add(perfilAluno);
            entityManager.merge(aluno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
    }

    private BufferedImage resize(BufferedImage image, int newWidth, int newHeight) {
        int currentWidth = image.getWidth();
        int currentHeight = image.getHeight();
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D graphics2d = newImage.createGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.drawImage(image, 0, 0, newWidth, newHeight, 0, 0,
                currentWidth, currentHeight, null);
        graphics2d.dispose();
        return newImage;
    }
}
