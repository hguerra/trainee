package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.model.security.Perfil;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * @author heitor
 * @since 18/05/16.
 */
public interface UsuarioService {

    Usuario buscarUsuarioPorId(Long id);

    Usuario buscarUsuarioPorNome(String nome);

    Usuario realizarLogin(String login, String senha);

    List<Usuario> listarTodos();

    List<Usuario> buscarUsuariosPorEndereco(Endereco endereco);

    List<Usuario> buscarUsuariosPorRua(String rua);

    List<Usuario> buscarUsuariosPorBairro(String bairro);

    List<Usuario> buscarUsuariosPorCidade(String cidade);

    List<Usuario> buscarUsuariosPorEstado(String estado);

    List<Usuario> buscarUsuariosPorPais(String pais);

    Set<Usuario> buscarUsuariosPorPerfils(Perfil... perfil);
}
