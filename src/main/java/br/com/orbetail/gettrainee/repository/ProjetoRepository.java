package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Projeto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {

    Projeto findById(Long id);

    @Query("select projetos from Projeto as projetos where projetos.dataTermino is null order by projetos.dataInicio " +
            "desc")
    List<Projeto> findProjetosRecentesAbertos();


    @Query("select projetos from Projeto as projetos where projetos.dataTermino is null order by projetos.dataInicio " +
            "desc")
    List<Projeto> findProjetosRecentesAbertos(Pageable pageable);

}
