package br.net.mirante.pde.service;

import br.net.mirante.pde.entity.Pessoa;
import br.net.mirante.pde.repository.EnderecoRepository;
import br.net.mirante.pde.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PessoaService {

    @Inject
    private PessoaRepository pessoaRepository;

    @Inject
    private EnderecoRepository enderecoRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public List<Pessoa> filtrar(String filtro) {
        return pessoaRepository.filtrar(filtro);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscar(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public void excluir(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    public void excluir(Long id) {
        pessoaRepository.deleteById(id);
    }

}
