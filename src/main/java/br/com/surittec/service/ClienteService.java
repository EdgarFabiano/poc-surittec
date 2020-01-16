package br.com.surittec.service;

import br.com.surittec.entity.Cliente;
import br.com.surittec.repository.EnderecoRepository;
import br.com.surittec.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private EnderecoRepository enderecoRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public List<Cliente> filtrar(String filtro) {
        return clienteRepository.filtrar(filtro);
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscar(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void excluir(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(new Cliente());
    }
}
