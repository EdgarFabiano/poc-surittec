package br.com.surittec.repository.custom;

import br.com.surittec.entity.Cliente;

import java.util.List;

public interface ClienteRepositoryCustom {

    List<Cliente> filtrar(String filtro);

}
