package br.com.orbetail.gettrainee.util;

/**
 * @author heitor
 * @since 18/05/16.
 */
public class ValidadorRegex {
    /**
     * Verifica se a String e composta por numeros
     */
    public static final Validador<String> isNumeric = numeric -> numeric
            .matches("[+-]?\\d*(\\.\\d+)?");
    /**
     * Verifica se a String e composta por letras somente
     */
    public static final Validador<String> isAlpha = alpha -> alpha
            .matches("[a-zA-Z]+");
    /**
     * Verifica se a String e composta por numeros e letras
     */
    public static final Validador<String> isAlphaNumeric = alphaNumeric -> alphaNumeric
            .matches("^[a-zA-Z0-9]*$");
    /**
     * Verifca telefone
     *
     * (XX) XXXXX-XXXX e (XX) XXXX-XXXX
     */
    public static final Validador<String> telefone = numeroTelefone -> numeroTelefone
            .matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
            || numeroTelefone
            .matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
    public static final Validador<String> email = email -> email
            .matches("[a-zA-Z0-9]+[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}");

    /**
     * Verifica CPF e CNPJ
     *
     */
    public static final Validador<String> cpfCnpj = numero -> numero.matches("([0-9]{2}[\\.]?[0-9]{3}[\\" +
            ".]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");

}
