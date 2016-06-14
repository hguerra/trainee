package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.security.Perfil;
import org.springframework.data.repository.CrudRepository;

/**
 * @author heitor
 * @since 13/06/16.
 */
public interface PerfilRepository extends CrudRepository<Perfil, Long> {
}
