package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public interface UniversidadeRepository extends CrudRepository<Universidade, Long> {

    Universidade findById(Long id);

    Universidade findByCnpj(String cnpj);

    @Query("select cursos from Universidade universidade inner join universidade.cursos cursos where universidade.id " +
            "= ?1")
    List<Curso> findAllCursos(Long id);

    List<Universidade> findByCursosIn(Set<Curso> cursos);

    @Query("select cursos from Curso as cursos where upper(cursos.descricao) like %?1%")
    Set<Curso> findCursosByDescricao(String descricao);
}
