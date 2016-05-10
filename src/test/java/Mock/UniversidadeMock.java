package Mock;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;
import br.com.orbetail.gettrainee.modelbuilder.EnderecoBuilder;

/**
 * @author heitor
 * @since 10/05/16.
 */
public class UniversidadeMock extends UsuarioMock {
    public Perfil getPerfil() {
        return getPerfil(Role.ROLE_UNIVERSIDADE);
    }

    public Endereco getEndereco() {
        Endereco endereco = new EnderecoBuilder()
                .numero("1.350")
                .rua("Av. Cesare Mansueto Giulio Lattes")
                .bairro("Eugênio de Melo")
                .cidade("Sao Jose dos Campos")
                .estado("Sao Paulo")
                .pais("Brasil")
                .get();
        return endereco;
    }

    public byte[] getImagem() {
        return getImagem("/home/heitor/Documentos/Desenvolvimento/Java/ideaProjects/gettrainee/src/test" +
                "/resources/fatec_logo.png");

    }
}
