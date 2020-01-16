package br.com.surittec.repository;

import br.com.surittec.repository.custom.UsuarioRepositoryCustom;
import br.com.surittec.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository para {{@link Usuario}}.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom {

    Usuario findByLogin(String login);
}
