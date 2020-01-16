package br.com.surittec.repository;

import br.com.surittec.entity.Cliente;
import br.com.surittec.repository.custom.ClienteRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom {
}
