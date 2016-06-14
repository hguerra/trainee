package br.com.orbetail.gettrainee.util;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.aluno.Idioma;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.repository.EnderecoRepository;
import br.com.orbetail.gettrainee.repository.IdiomaRepository;
import br.com.orbetail.gettrainee.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 13/06/16.
 */
@Component
public class DefaultCadastro {
    private final static Long ENDERECO_FATEC_ID = 2L;
    private final static String IMAGEM_USUARIO_PATH =
            "/home/heitor/Documentos/Desenvolvimento/Java/ideaProjects/gettrainee/src/main/webapp/resources/images" +
                    "/avatar.jpeg";
    private final static Long PERFIL_ALUNO_ID = 3L;
    private final static Long IDIOMA_ID = 2L;
    private Endereco enderecoFATEC;
    private byte[] image;
    private Set<Perfil> perfils;
    private Idioma idiomaPortugues;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Autowired
    private PerfilRepository perfilRepository;

    public void setPerfilRepository(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Autowired
    private IdiomaRepository idiomaRepository;

    public void setIdiomaRepository(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }

    public Endereco getEnderecoFATEC() {
        if (enderecoFATEC == null) {
            enderecoFATEC = enderecoRepository.findOne(ENDERECO_FATEC_ID);
        }
        return enderecoFATEC;
    }

    public byte[] getImage() {
        if (image == null) {
            image = getImagem(IMAGEM_USUARIO_PATH);
        }
        return image;
    }

    public Set<Perfil> getPerfils() {
        if (perfils == null) {
            Perfil perfil = perfilRepository.findOne(PERFIL_ALUNO_ID);
            perfils = new HashSet<>();
            perfils.add(perfil);
        }
        return perfils;
    }

    public Idioma getIdiomaPortugues() {
        if (idiomaPortugues == null) {
            idiomaPortugues = idiomaRepository.findOne(IDIOMA_ID);
        }
        return idiomaPortugues;
    }

    private byte[] getImagem(String filepath) {
        try {
            File file = new File(filepath);
            byte[] image = new byte[(int) file.length()];

            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(image);
            fileInputStream.close();

            return image;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
