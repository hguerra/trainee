package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Aluno;
import org.springframework.data.repository.CrudRepository;

/**
 * @author heitor
 * @since 05/05/16.
 */
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}
