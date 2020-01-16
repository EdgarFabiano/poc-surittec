package br.net.mirante.pde.service;

import br.net.mirante.pde.entity.Usuario;
import br.net.mirante.pde.pojo.Login;
import br.net.mirante.pde.repository.UsuarioRepository;
import br.net.mirante.pde.security.PasswordHashing;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Boolean autenticar(Login login) {
        return usuarioRepository.authenticateUser(login);
    }

    public Boolean autenticar(String login, String senha) {
        return autenticar(new Login(login, senha));
    }

    public Usuario salvar(Usuario usuario) {
        String senha = usuario.getSenha();
        usuario.setSenha(PasswordHashing.generateHash(senha));
        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void excluir(Long id) {
        usuarioRepository.delete(buscar(id));
    }

}
