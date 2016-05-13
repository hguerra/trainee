package mock;

import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author heitor
 * @since 10/05/16.
 */
public abstract class UsuarioMock {
    public byte[] getImagem(String filepath) {
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

    public Perfil getPerfil(Role role) {
        HashSet<Role> roles = new HashSet<Role>() {
            {
                add(role);
            }
        };
        Perfil perfil = new Perfil();
        perfil.setNome(role.getAuthority());
        return perfil;
    }
}
