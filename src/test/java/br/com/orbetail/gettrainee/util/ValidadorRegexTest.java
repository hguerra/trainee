package br.com.orbetail.gettrainee.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author heitor
 * @since 18/05/16.
 */
public class ValidadorRegexTest {

    @Test
    public void validadorCpfCnpjTest() throws Exception {
        assertTrue(ValidadorRegex.cpfCnpj.validar("42198627817"));
        assertTrue(ValidadorRegex.cpfCnpj.validar("421.986.278-17"));
        assertTrue(!ValidadorRegex.cpfCnpj.validar("00000000000000000000000000000000"));
        assertTrue(!ValidadorRegex.cpfCnpj.validar("0000"));
        assertTrue(!ValidadorRegex.cpfCnpj.validar("000.000.000-000"));
    }

}