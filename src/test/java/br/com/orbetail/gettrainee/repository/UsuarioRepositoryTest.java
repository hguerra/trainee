package br.com.orbetail.gettrainee.repository;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.model.security.Perfil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author heitor
 * @since 17/05/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class UsuarioRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String EMPRESA_NOME  = "INPE";
    private static final String EMPRESA_USERNAME  = "inpe";
    private static final String EMPRESA_SENHA  = "11";
    private static final String EMPRESA_RUA  = "Av. dos Astronautas";

    @Autowired
    private UsuarioRepository usuarioRepository;
    /**
     * @param usuarioRepository:UsuarioRepository
     */
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * @param entityManagerFactory:EntityManagerFactory
     */
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Test
    public void findByNomeTest() throws Exception {
        Usuario empresa = usuarioRepository.findByNome(EMPRESA_NOME);
        assertThat(empresa.getUsername(), is(EMPRESA_USERNAME));
    }

    @Test
    public void loginTest() throws Exception {
        Usuario empresa = usuarioRepository.login(EMPRESA_USERNAME, EMPRESA_SENHA);
        assertThat(empresa.getNome(), is(EMPRESA_NOME));
    }

    @Test
    public void findByEnderecoTest() throws Exception {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();

        Endereco endereco = null;
        for(Usuario u: usuarios){
            if(u.getEndereco() != null){
                endereco = u.getEndereco();
                break;
            }
        }

        List<Usuario> usuariosByEndereco = usuarioRepository.findByEndereco(endereco);

        assertTrue(!usuariosByEndereco.isEmpty());

    }

    @Test
    public void findByRuaTest() throws Exception {
        List<Usuario> usuarios = usuarioRepository.findByRua(EMPRESA_RUA);

        if(usuarios.isEmpty())
            fail("isEmpty");

        assertTrue(!usuarios.isEmpty());
    }

    @Test
    public void findByPerfilsInTest() throws Exception {
        Set<Perfil> perils = new HashSet<>();

        EntityManager em = entityManagerFactory.createEntityManager();

        Query query = em.createQuery("select p from Perfil as p where p.nome = :nome", Perfil.class);
        query.setParameter("nome", "ROLE_EMPRESA");
        Perfil perfil = (Perfil) query.getSingleResult();

        perils.add(perfil);
        Set<Usuario> usuarios = usuarioRepository.findByPerfilsIn(perils);

        assertTrue(!usuarios.isEmpty());
    }

}