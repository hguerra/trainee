package mock;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;
import br.com.orbetail.gettrainee.modelbuilder.EnderecoBuilder;

/**
 * @author heitor
 * @since 10/05/16.
 */
public class AlunoMock extends UsuarioMock {
    public Perfil getPerfil() {
        return getPerfil(Role.ROLE_ALUNO);
    }

    public Endereco getEndereco() {
        Endereco endereco = new EnderecoBuilder()
                .numero("1.758")
                .rua("Av. dos Astronautas")
                .bairro("Jardim da Granja")
                .cidade("Sao Jose dos Campos")
                .estado("Sao Paulo")
                .pais("Brasil")
                .get();
        return endereco;
    }
    public byte[] getImagem() {
        return getImagem("/home/heitor/Documentos/Desenvolvimento/Java/ideaProjects/gettrainee/src/test/resources/aluno_logo.png");

    }




}
