package br.com.orbetail.gettrainee.service.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heitor
 * @since 17/05/16.
 */
public class Criptografia {
    protected CriptografiaTipo type;

    protected String plainText;

    protected BigInteger cipher;

    protected int baseHash = 16;

    private MessageDigest messageDigest;

    private BigInteger encryptedText;

    Map<CriptografiaTipo, String> types = new HashMap<CriptografiaTipo, String>();

    public Criptografia(CriptografiaTipo type, String plainText) throws NoSuchAlgorithmException {
        this.type = type;
        this.plainText = plainText.trim();

        types.put(CriptografiaTipo.MD5, "MD5");
        types.put(CriptografiaTipo.SHA1, "SHA-1");
        types.put(CriptografiaTipo.SHA256, "SHA-256");

        process();
    }

    public Criptografia(CriptografiaTipo type, String plainText, int baseHash) throws NoSuchAlgorithmException {
        this.type = type;
        this.plainText = plainText.trim();

        this.baseHash = baseHash;

        types.put(CriptografiaTipo.MD5, "MD5");
        types.put(CriptografiaTipo.SHA1, "SHA-1");
        types.put(CriptografiaTipo.SHA256, "SHA-256");

        process();
    }

    private void process() throws NoSuchAlgorithmException {

        messageDigest = MessageDigest.getInstance(types.get(type));

        messageDigest.update(plainText.getBytes(), 0, plainText.length());

        encryptedText = new BigInteger(1, this.messageDigest.digest());
    }

    public String getEncryptedText() {
        return encryptedText.toString(baseHash);
    }
}
