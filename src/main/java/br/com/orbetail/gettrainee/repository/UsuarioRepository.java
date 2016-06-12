package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.model.security.Perfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

/**
 * @author heitor
 * @since 17/05/16.
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByNome(String nome);

    @Query("select usuario from Usuario as usuario where usuario.login = ?1 and usuario.senha = ?2")
    Usuario login(String login, String senha);

    List<Usuario> findByEndereco(Endereco endereco);

    @Query("select usuarios " +
            "from Usuario as usuarios where upper(usuarios.endereco.rua.rua) = ?1")
    List<Usuario> findByRua(String rua);

    @Query("select usuarios " +
            "from Usuario as usuarios where upper(usuarios.endereco.rua.bairro.bairro) = ?1")
    List<Usuario> findByBairro(String bairro);

    @Query("select usuarios " +
            "from Usuario as usuarios where upper(usuarios.endereco.rua.bairro.cidade.cidade) = ?1")
    List<Usuario> findByCidade(String cidade);

    @Query("select usuarios " +
            "from Usuario as usuarios where upper(usuarios.endereco.rua.bairro.cidade.estado.estado) = ?1")
    List<Usuario> findByEstado(String estado);

    @Query("select usuarios " +
            "from Usuario as usuarios where upper(usuarios.endereco.rua.bairro.cidade.estado.pais.pais) = ?1")
    List<Usuario> findByPais(String pais);

    Set<Usuario> findByPerfilsIn(Set<Perfil> perfils);
}
