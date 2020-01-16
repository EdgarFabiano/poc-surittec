package br.net.mirante.pde.repository;

import br.net.mirante.pde.entity.Pessoa;
import br.net.mirante.pde.repository.custom.PessoaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryCustom {
}
