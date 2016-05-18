package br.com.orbetail.gettrainee.util;

/**
 * @author heitor
 * @since 18/05/16.
 */
@FunctionalInterface
public interface Validador<T> {
    boolean validar(T t);
}
