package br.com.surittec.controller;

import br.com.surittec.entity.Usuario;
import br.com.surittec.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/usuario/{login}")
    public Usuario findByLogin(@PathVariable String login) {
        return usuarioService.findByLogin(login);
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
