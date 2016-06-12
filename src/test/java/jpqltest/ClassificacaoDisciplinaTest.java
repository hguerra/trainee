package jpqltest;

import br.com.orbetail.gettrainee.model.universidade.ClassificacaoDisciplina;
import br.com.orbetail.gettrainee.model.universidade.Disciplina;
import br.com.orbetail.gettrainee.model.universidade.Docente;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 11/05/16.
 */
public class ClassificacaoDisciplinaTest {
    private static EntityManager entityManager;

    @BeforeClass
    public static void setUp() throws Exception {
        entityManager = SpringDataUtil.getEntityManager();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        entityManager.close();
    }

    private static void persistClassificacaoDisciplina(Integer peso, String nome,
                                                       Integer semestre, String docenteNome, String lattes) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Docente docente = null;

        Query q = entityManager.createQuery("select d from Docente d where d.nome = :nome", Docente.class);
        q.setParameter("nome", docenteNome);
        try {
            docente = (Docente) q.getSingleResult();
        } catch (Exception e) {
            docente = new Docente();
        }
        docente.setNome(docenteNome);
        docente.setLattes(lattes);

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        disciplina.setDescricao(nome);
        disciplina.setSemestre(semestre);

        disciplina.setDocente(docente);
        Set<Disciplina> disciplinasMinistradas = new HashSet<>();
        disciplinasMinistradas.add(disciplina);
        docente.setDisciplinasMinistradas(disciplinasMinistradas);

        ClassificacaoDisciplina classificacaoDisciplina = new ClassificacaoDisciplina();
        classificacaoDisciplina.setDisciplina(disciplina);
        classificacaoDisciplina.setPeso(peso);

        entityManager.persist(classificacaoDisciplina);
        transaction.commit();
    }

    @Ignore("semestre ja persistido")
    @Test
    public void primeiroSemestreTest() {
        persistClassificacaoDisciplina(2, "Programacao em Microinformatica", 1, "Lucas Gonçalves Nadalete",
                "http://lattes.cnpq.br/1268591658881312");
        persistClassificacaoDisciplina(5, "Algoritmos e Logica de Programacao", 1, "Fernando Masanori",
                "http://lattes.cnpq.br/3324339924853354");
        persistClassificacaoDisciplina(2, "Laboratorio de Hardware", 1, "Antônio Egydio São Tiago Graça",
                "http://lattes.cnpq.br/0858832006050432");
        persistClassificacaoDisciplina(2, "Arquitetura e Organizacao de Computadores", 1, "Antônio Egydio São Tiago " +
                "Graça", "http://lattes.cnpq.br/0858832006050432");
        persistClassificacaoDisciplina(1, "Administracao Geral", 1, "Geraldo José Lombardi de Souza",
                "http://lattes" +
                        ".cnpq.br/0760681088537371");
        persistClassificacaoDisciplina(4, "Matematica Discreta", 1, "Reinaldo Gen Ichiro Arakaki", "http://lattes" +
                ".cnpq.br/2075406788034578");
        persistClassificacaoDisciplina(1, "Ingles I", 1, "Carolina Tayar Farina de Rource", "http://lattes.cnpq" +
                ".br/8034408077183399");
    }

    @Ignore("semestre ja persistido")
    @Test
    public void segundoSemestreTest() {
        persistClassificacaoDisciplina(5, "Engenharia de Software I", 2, "Giuliano Araújo Bertoti", "http://lattes" +
                ".cnpq.br/4377240827813491");
        persistClassificacaoDisciplina(5, "Linguagem de Programação", 2, "Juliana Forin Pasquini Martinez",
                "http://lattes.cnpq.br/1506784529918492");
        persistClassificacaoDisciplina(2, "Sistemas de Informação", 2, "José Walmir Gonçalves Duque", "http://lattes" +
                ".cnpq.br/4678097512178887");
        persistClassificacaoDisciplina(2, "Contabilidade", 2, "Cícero Soares da Silva", "http://lattes.cnpq" +
                ".br/3341430928298725");
        persistClassificacaoDisciplina(2, "Cálculo", 2, "Nanci de Oliveira", "http://lattes.cnpq.br/9817633201761453");
        persistClassificacaoDisciplina(1, "Comunicação e Expressão", 2, "Ana Cecília Rodrigues Medeiros",
                "http://lattes.cnpq.br/1940086892227479");
        persistClassificacaoDisciplina(1, "Inglês II", 2, "Carolina Tayar Farina de Rource", "http://lattes.cnpq" +
                ".br/8034408077183399");
    }

    @Ignore("semestre ja persistido")
    @Test
    public void terceiroSemestreTest() {
        persistClassificacaoDisciplina(5, "Engenharia de Software II", 3, "José Walmir Gonçalves Duque",
                "http://lattes.cnpq.br/4678097512178887");
        persistClassificacaoDisciplina(4, "Interação Humano Computador", 3, "Giuliano Araújo Bertoti", "http://lattes" +
                ".cnpq.br/4377240827813491");
        persistClassificacaoDisciplina(5, "Estruturas de Dados", 3, "Fernando Masanori", "http://lattes.cnpq" +
                ".br/3324339924853354");
        persistClassificacaoDisciplina(3, "Sistemas Operacionais I", 3, "Diogo Branquinho Ramos", "http://lattes.cnpq" +
                ".br/2442951597646811");
        persistClassificacaoDisciplina(3, "Estatística Aplicada", 3, "Nanci de Oliveira", "http://lattes.cnpq" +
                ".br/9817633201761453");
        persistClassificacaoDisciplina(1, "Sociedade e Tecnologia", 3, "Tatiana Martins Alméri", "http://lattes.cnpq" +
                ".br/6619844601377499");
        persistClassificacaoDisciplina(1, "Inglês III", 3, "Carolina Tayar Farina de Rource", "http://lattes.cnpq" +
                ".br/8034408077183399");
    }

    @Ignore("semestre ja persistido")
    @Test
    public void quartoSemestreTest() {
        persistClassificacaoDisciplina(5, "Engenharia de Software III", 4, "Giuliano Araújo Bertoti", "http://lattes" +
                ".cnpq.br/4377240827813491");
        persistClassificacaoDisciplina(5, "Programação Orientada a Objetos", 4, "Gerson da Penha Neto",
                "http://lattes.cnpq.br/9441903297380731");
        persistClassificacaoDisciplina(5, "Banco de Dados", 4, "Juliana Forin Pasquini Martinez", "http://lattes.cnpq" +
                ".br/1506784529918492");
        persistClassificacaoDisciplina(3, "Sistemas Operacionais II", 4, "Fabiano Sabha Walczak", "http://lattes.cnpq" +
                ".br/4250738143383384");
        persistClassificacaoDisciplina(5, "Teste de Softwares", 4, "Gerson da Penha Neto", "http://lattes.cnpq" +
                ".br/9441903297380731");
        persistClassificacaoDisciplina(2, "Metodologia da Pesquisa Científico-Tecnológica", 4, "Joares Lidovino",
                "http://lattes.cnpq.br/7963698498836684");
        persistClassificacaoDisciplina(1, "Inglês IV", 4, "Carolina Tayar Farina de Rource", "http://lattes.cnpq" +
                ".br/8034408077183399");
    }

    @Ignore("semestre ja persistido")
    @Test
    public void quintoSemestreTest() {
        persistClassificacaoDisciplina(5, "Laboratório de Engenharia de Software", 5, "Gerson da Penha Neto",
                "http://lattes.cnpq.br/9441903297380731");
        persistClassificacaoDisciplina(2, "Segurança da Informação", 5, "Rogério Oliveira de Paula", "http://lattes" +
                ".cnpq.br/3333632657202399");
        persistClassificacaoDisciplina(5, "Redes de Computadores", 5, "Rogério Oliveira de Paula", "http://lattes" +
                ".cnpq.br/3333632657202399");
        persistClassificacaoDisciplina(5, "Laboratório de Banco de Dados ", 5, "Fernando Masanori", "http://lattes" +
                ".cnpq.br/3324339924853354");
        persistClassificacaoDisciplina(4, "Programação Linear e Aplicações", 5, "Reinaldo Gen Ichiro Arakaki",
                "http://lattes.cnpq.br/2075406788034578");
        persistClassificacaoDisciplina(5, "Programacao de Scripts", 5, "Renzo dos Santos Nuccitelli", "http://lattes" +
                ".cnpq.br/5167692201218224");
        persistClassificacaoDisciplina(1, "Inglês V", 5, "Carolina Tayar Farina de Rource", "http://lattes.cnpq" +
                ".br/8034408077183399");
    }

    @Ignore("semestre ja persistido")
    @Test
    public void sextoSemestreTest() {
        persistClassificacaoDisciplina(2, "Gestão de Projetos", 6, "Cláudio Etelvino de Lima", "http://lattes.cnpq" +
                ".br/9330552327454666");
        persistClassificacaoDisciplina(1, "Gestão e Governança de Tecnologia da Informação", 6, "Fabiano Sabha " +
                "Walczak", "http://lattes.cnpq.br/4250738143383384");
        persistClassificacaoDisciplina(5, "Tópicos Especiais em Informática", 6, "Emanuel Mineda Carneiro",
                "http://lattes.cnpq.br/3395132054636969");
        persistClassificacaoDisciplina(5, "Inteligência Artificial", 6, "Fernando Masanori", "http://lattes.cnpq" +
                ".br/3324339924853354");
        persistClassificacaoDisciplina(1, "Gestão de Equipes", 6, "Tatiana Martins Alméri", "http://lattes.cnpq" +
                ".br/6619844601377499");
        persistClassificacaoDisciplina(3, "Empreendedorismo", 6, "Valter João de Souza", "http://lattes.cnpq" +
                ".br/4037684544757358");
        persistClassificacaoDisciplina(1, "Ética e Responsabilidade Profissional", 6, "Ana Cecília Rodrigues " +
                "Medeiros", "http://lattes.cnpq.br/1940086892227479");
        persistClassificacaoDisciplina(1, "Inglês VI", 6, "Carolina Tayar Farina de Rource", "http://lattes.cnpq" +
                ".br/8034408077183399");
    }


}
