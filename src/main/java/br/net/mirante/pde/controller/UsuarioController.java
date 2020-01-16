package br.net.mirante.pde.controller;

import br.net.mirante.pde.entity.Usuario;
import br.net.mirante.pde.service.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping("/usuarios")
    public void save(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
    }

    @GetMapping("/autenticar")
    public boolean autenticar(@RequestParam String usuario, @RequestParam String senha) {
        return usuarioService.autenticar(usuario, senha);
    }
}
