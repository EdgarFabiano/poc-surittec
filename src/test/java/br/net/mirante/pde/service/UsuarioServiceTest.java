package br.net.mirante.pde.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

    @Inject
    UsuarioService usuarioService;

    @Test
    @Sql("classpath:db/test/usuario-test.sql")
    public void autenticarUsuario() {
        assertThat(Objects.nonNull(usuarioService.autenticar("edgar", "edgar123"))).isTrue();
        assertThat(Objects.nonNull(usuarioService.autenticar("marcos", "marcos123"))).isTrue();
        assertThat(Objects.nonNull(usuarioService.autenticar("william", "william123"))).isTrue();
    }

    @Test
    @Sql("classpath:db/test/usuario-test.sql")
    public void autenticarUsuarioFail() {
        assertThat(Objects.nonNull(usuarioService.autenticar("edgar", "Edgar123"))).isFalse();
        assertThat(Objects.nonNull(usuarioService.autenticar("marcos", "marcos1234"))).isFalse();
        assertThat(Objects.nonNull(usuarioService.autenticar("william", "will123"))).isFalse();
    }

}