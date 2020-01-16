package br.net.mirante.pde.security;

import br.net.mirante.pde.exception.PasswordException;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordHashingTest {

    @Test
    public void generateHash() {
        assertThat(PasswordHashing.generateHash("edgar123")).isEqualTo("21d1337a6d812a7511b98dff4accb13998f99e32");
        assertThat(PasswordHashing.generateHash("marcos123")).isEqualTo("7f725e2218660b003e64881d9e33b8474de77d74");
        assertThat(PasswordHashing.generateHash("william123")).isEqualTo("fc61e55229c1c3143b57172b661c2545b0f7cd61");

        assertThat(PasswordHashing.generateHash("Edgar123")).isEqualTo("f6dc879cf9074bcd74bf2966e9a8ebb884834ff3");
        assertThat(PasswordHashing.generateHash("MARCOS123")).isEqualTo("9d0619a213cb0871b19f73a9571a93ef82d9dc7b");
        assertThat(PasswordHashing.generateHash("Will I am 123")).isEqualTo("f8669edcbef814ea74f23dd2da588e278c10b7e8");
    }

    @Test(expected = PasswordException.class)
    public void generateHashNull() {
        PasswordHashing.generateHash(null);
    }

    @Test(expected = PasswordException.class)
    public void generateHashEmpty() {
        PasswordHashing.generateHash(Strings.EMPTY);
    }

}