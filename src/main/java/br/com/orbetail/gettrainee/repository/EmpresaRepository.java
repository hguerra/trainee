package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    Empresa findByCnpj(String cnpj);

    Set<Empresa> findByEspecializacaoIn(Set<String> especializacao);
}
