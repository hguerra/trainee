package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.aluno.Curriculo;
import br.com.orbetail.gettrainee.model.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author heitor
 * @since 05/05/16.
 */
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    Aluno findById(Long id);

    @Query("select aluno from Aluno as aluno join fetch aluno.competencias where aluno.id = ?1")
    Aluno findAlunoFetchCompetencias(Long id);

    Aluno findByCpf(String cpf);

    Aluno findByCurriculo(Curriculo curriculo);

    @Query("select aluno from Aluno aluno inner join aluno.projetos portifolio where portifolio = ?1")
    List<Aluno> findByProjeto(Projeto projeto);

    @Query("select alunos " +
            "from Aluno as alunos inner join alunos.competencias competencias " +
            "where upper(competencias.palavraChave) like %?1%")
    List<Aluno> findByCompentecia(String palavraChave);

    @Query("select alunos " +
            "from Aluno as alunos inner join alunos.recomendacaoes recomendacoes " +
            "where recomendacoes.nota >= ?1")
    List<Aluno> findByRecomendacao(Integer nota);
}
