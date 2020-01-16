package br.com.surittec.repository.custom;

import br.com.surittec.pojo.Login;

public interface UsuarioRepositoryCustom {

    Boolean authenticateUser(Login loginSemHash);

}
