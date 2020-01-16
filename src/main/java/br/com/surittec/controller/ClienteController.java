package br.com.surittec.controller;

import br.com.surittec.entity.Cliente;
import br.com.surittec.service.ClienteService;
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
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente find(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    public void save(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.excluir(id);
    }

}
