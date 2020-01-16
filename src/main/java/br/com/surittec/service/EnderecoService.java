package br.com.surittec.service;

import br.com.surittec.entity.Endereco;
import br.com.surittec.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EnderecoService {

    @Inject
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscar(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }
    
    public void excluir(Endereco endereco) {
        enderecoRepository.delete(endereco);
    }  
    
    public void excluir(Long id) {
        enderecoRepository.delete(buscar(id));
    }

}
