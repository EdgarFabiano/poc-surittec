package br.net.mirante.pde.repository.custom;

import br.net.mirante.pde.entity.QUsuario;
import br.net.mirante.pde.pojo.Login;
import br.net.mirante.pde.security.PasswordHashing;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import br.net.mirante.pde.entity.Usuario;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.Objects;

@Named
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

    @Inject
    EntityManager em;

    private QUsuario usuario = QUsuario.usuario;

    private JPAQuery<Usuario> usuarioQuery() {
        return new JPAQueryFactory(em).select(usuario).from(usuario);
    }

    /**
     * Autentica o {{@link Login}} de um usuário com as suas credenciais.
     * Compara o login e a senha (com hash) passada com algum usuário do banco.
     *
     * @param loginSemHash Credenciais de login do usuário sem o hash aplicado.
     * @return Boolean para autenticação.
     */
    @Override
    public Boolean authenticateUser(Login loginSemHash) {
        String senhaComHash = PasswordHashing.generateHash(loginSemHash.getSenha());
        return Objects.nonNull(usuarioQuery()
                .where(usuario.login.eq(loginSemHash.getLogin())
                        .and(usuario.senha.eq(senhaComHash)))
                .fetchOne());

    }

}
