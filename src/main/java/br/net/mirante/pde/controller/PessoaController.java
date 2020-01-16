package br.net.mirante.pde.controller;

import br.net.mirante.pde.entity.Pessoa;
import br.net.mirante.pde.service.PessoaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PessoaController {

    @Inject
    private PessoaService pessoaService;

    @GetMapping("/pessoas")
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @PostMapping("/pessoas")
    public void save(@RequestBody Pessoa pessoa) {
        pessoaService.salvar(pessoa);
    }

    @DeleteMapping("/pessoas/{id}")
    public void delete(@PathVariable Long id) {
        pessoaService.excluir(id);
    }

}
