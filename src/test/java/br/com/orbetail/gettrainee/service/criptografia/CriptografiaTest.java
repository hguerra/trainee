package br.com.orbetail.gettrainee.service.criptografia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author heitor
 * @since 17/05/16.
 */
public class CriptografiaTest {
    private static final String DEFAULT_SENHA = "senha".trim();
    private static final String MD5_SENHA = "e8d95a51f3af4a3b134bf6bb680a213a";
    private Criptografia criptografia;

    @Before
    public void setUp() throws Exception {
        this.criptografia = new Criptografia(CriptografiaTipo.MD5, DEFAULT_SENHA);
    }

    @After
    public void tearDown() throws Exception {
        this.criptografia = null;
    }

    @Test
    public void getEncryptedText() throws Exception {
        assertThat(criptografia.getEncryptedText(), is(MD5_SENHA));
    }

}