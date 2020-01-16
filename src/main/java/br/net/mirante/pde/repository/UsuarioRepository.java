package br.net.mirante.pde.repository;

import br.net.mirante.pde.entity.Usuario;
import br.net.mirante.pde.repository.custom.UsuarioRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository para {{@link Usuario}}.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom {

}
