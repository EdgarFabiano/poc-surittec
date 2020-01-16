package br.net.mirante.pde.repository.custom;

import br.net.mirante.pde.pojo.Login;

public interface UsuarioRepositoryCustom {

    Boolean authenticateUser(Login loginSemHash);

}
