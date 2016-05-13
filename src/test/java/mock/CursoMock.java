package mock;

import br.com.orbetail.gettrainee.model.universidade.ClassificacaoDisciplina;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.model.universidade.Docente;

import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 11/05/16.
 */
public class CursoMock {
    //ads
    public static Curso getADS() {
        Docente coordenador = new Docente();




        Set<ClassificacaoDisciplina> disciplinas = new HashSet<>();
        Curso curso = new Curso();
        curso.setDescricao("O Tecnólogo em Análise e Desenvolvimento de" +
                " Sistemas analisa, projeta, documenta, especifica, testa, " +
                "implanta e mantém sistemas computacionais de informação. ");
        curso.setCoordenador(coordenador);
        curso.setDisciplinas(disciplinas);
        return curso;
    }
}
