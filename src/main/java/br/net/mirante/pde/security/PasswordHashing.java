package br.net.mirante.pde.security;

import br.net.mirante.pde.exception.PasswordException;
import org.apache.logging.log4j.util.Strings;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Classe utilitaria para cuidar da geracao de hash para as senhas dos pessoas.
 */
public class PasswordHashing {

    private static final String SALT = "ciw566164123213@!#@!@(@!()!@#SADasddsa,@!*U@#*@!##@!::::::DSDSAKDSAcnxzcmxz";

    /**
     * Utiliza a função de dispersão criptográfica "SHA-1" com uma chave para gerar o hash.
     *
     * @param input A senha do usuário, com os critérios:
     *              - No mínimo 6 caracteres;
     *              - Pelo menos 1 caracter alfabético (minúsculo ou maiúsculo);
     *              - Pelo menos 1 caracter numérico;
     *              - Pode ter espaços.
     * @return O hash gerado a partir da senha do usuário.
     */
    public static String generateHash(@NotNull @NotEmpty @Size(min = 6) @Pattern(regexp = "^.*(?=..*[0-9])(?=.*[a-z]).*$") String input) {
        if (Strings.isEmpty(input))
            throw new PasswordException("Input must not be null/empty.");

        StringBuilder hash = new StringBuilder();
        input = SALT + input;

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (byte b : hashedBytes) {
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            getLogger().error(e);
        }

        return hash.toString();
    }

}