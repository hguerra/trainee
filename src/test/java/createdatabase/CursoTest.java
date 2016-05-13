package createdatabase;

import br.com.orbetail.gettrainee.model.universidade.ClassificacaoDisciplina;
import br.com.orbetail.gettrainee.model.universidade.Curso;
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
 * @since 12/05/16.
 */
public class CursoTest {
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
    public void persistCursoADS() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Docente coordenador = null;

        Query q = entityManager.createQuery("select d from Docente d where d.nome = :nome", Docente.class);
        q.setParameter("nome", "Reinaldo Gen Ichiro Arakaki");
        try {
            coordenador = (Docente) q.getSingleResult();

            Set<ClassificacaoDisciplina> disciplinas = new HashSet<>();

            Query q2 = entityManager.createQuery("select d from ClassificacaoDisciplina d", ClassificacaoDisciplina
                    .class);

            q2.getResultList().forEach(obj -> {
                ClassificacaoDisciplina classificacaoDisciplina = (ClassificacaoDisciplina) obj;
                disciplinas.add(classificacaoDisciplina);
            });
            Curso curso = new Curso();
            curso.setDescricao("O Tecnólogo em Análise e Desenvolvimento de" +
                    " Sistemas analisa, projeta, documenta, especifica, testa, " +
                    "implanta e mantém sistemas computacionais de informação. ");
            curso.setCoordenador(coordenador);
            curso.setDisciplinas(disciplinas);

            entityManager.persist(curso);
        } catch (Exception e) {
            System.out.println("NAO FOI ENCONTRADO O DOCENTE");
        }

        transaction.commit();
    }
}
