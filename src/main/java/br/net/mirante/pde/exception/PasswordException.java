package br.net.mirante.pde.exception;

/**
 * Exception para ser lançada nos casos de senha fora do padrão esperado:
 * - No mínimo 6 caracteres;
 * - Pelo menos 1 caracter alfabético (minúsculo ou maiúsculo);
 * - Pelo menos 1 caracter numérico;
 * - Pode ter espaços.
 */
public class PasswordException extends RuntimeException {

    public PasswordException() {
        super();
    }

    public PasswordException(String s) {
        super(s);
    }

    public PasswordException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
