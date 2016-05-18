package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.aluno.Competencia;
import br.com.orbetail.gettrainee.model.aluno.Curriculo;
import br.com.orbetail.gettrainee.model.aluno.Grupo;
import br.com.orbetail.gettrainee.model.aluno.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author heitor
 * @since 05/05/16.
 */
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

//    @Query("select aluno from Aluno as aluno where aluno.id = ?1")
//    Aluno findAluno(Long id);
//
//    @Query("select aluno from Aluno as aluno join fetch aluno.competencias where aluno.id = ?1")
//    Aluno findAlunoCompetenciasPropertiesAluno(Long id);
//
//    @Query("select aluno from Aluno as aluno join fetch all properties where aluno.id = ?1")
//    Aluno findAllPropertiesAluno(Long id);
//
//    Aluno findByCpf(String cpf);
//
//    Aluno findByCurriculo(Curriculo curriculo);
//
//    @Query("select aluno from Aluno aluno inner join aluno.portifolio portifolio where portifolio = ?1")
//    List<Aluno> findByProjeto(Projeto projeto);
//
//    List<Aluno> findByCompentecia(String palavraChave);
//
//    List<Aluno> findByGrupo(String grupo);
//
//    List<Aluno> findByRecomendacao(String recomendacao);
//
//    List<Aluno> findByRecomendacao(Integer nota);
}
