package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Endereco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author heitor
 * @since 18/05/16.
 */
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    /**
     * Realizar buscas utilizando like
     */
}
