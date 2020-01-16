package br.net.mirante.pde.repository.custom;

import br.net.mirante.pde.entity.Pessoa;

import java.util.List;

public interface PessoaRepositoryCustom {

    List<Pessoa> filtrar(String filtro);

}
