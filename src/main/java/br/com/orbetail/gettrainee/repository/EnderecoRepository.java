package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.endereco.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author heitor
 * @since 12/06/16.
 */
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    @Query("select p from Pais as p where p.pais = ?1")
    Pais findPaisByNome(String pais);

    @Query("select e from Estado as e where e.pais.id = ?1")
    List<Estado> findByPais(Long paisId);

    @Query("select c from Cidade as c where c.estado.id = ?1")
    List<Cidade> findByEstado(Long estadoId);

    @Query("select b from Bairro as b where b.cidade.id = ?1")
    List<Bairro> findByCidade(Long cidadeId);

    @Query("select r from Rua as r where r.bairro.id = ?1")
    List<Rua> findByRua(Long bairroId);

    @Query("select e from Endereco as e where upper(e.rua.rua) = ?1 and e.numero = ?2")
    List<Endereco> findByRuaNumero(String rua, String numero);


    @Query("select c from Cidade as c")
    List<Cidade> findAllCidades();

    @Query("select b from Bairro as b where b.cidade.id = ?1 and upper(b.bairro) = ?2")
    Bairro findByBairro(Long cidadeId, String bairro);

    @Query("select r from Rua as r where r.bairro.id = ?1 and upper(r.rua) = ?2")
    Rua findByRua(Long BairroId, String rua);
}
