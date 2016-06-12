package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author heitor
 * @since 19/05/16.
 */
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * @param usuarioRepository:UsuarioRepository
     */
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario buscarUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    @Override
    public Usuario realizarLogin(String login, String senha) {
        return usuarioRepository.login(login, senha);
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> todos = new ArrayList<>();
        for (Usuario usuario : usuarioRepository.findAll())
            todos.add(usuario);
        return todos;
    }
    @Override
    public List<Usuario> buscarUsuariosPorEndereco(Endereco endereco) {
        return usuarioRepository.findByEndereco(endereco);
    }

    @Override
    public List<Usuario> buscarUsuariosPorRua(String rua) {
        return usuarioRepository.findByRua(rua.toUpperCase());
    }

    @Override
    public List<Usuario> buscarUsuariosPorBairro(String bairro) {
        return usuarioRepository.findByBairro(bairro.toUpperCase());
    }

    @Override
    public List<Usuario> buscarUsuariosPorCidade(String cidade) {
        return usuarioRepository.findByCidade(cidade.toUpperCase());
    }

    @Override
    public List<Usuario> buscarUsuariosPorEstado(String estado) {
        return usuarioRepository.findByEstado(estado.toUpperCase());
    }

    @Override
    public List<Usuario> buscarUsuariosPorPais(String pais) {
        return usuarioRepository.findByPais(pais.toUpperCase());
    }

    @Override
    public Set<Usuario> buscarUsuariosPorPerfils(Perfil... perfil) {
        Set<Perfil> perfils = new HashSet<>();
        Collections.addAll(perfils, perfil);
        return usuarioRepository.findByPerfilsIn(perfils);
    }
}
