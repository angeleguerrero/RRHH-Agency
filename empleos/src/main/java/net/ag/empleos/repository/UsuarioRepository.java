package net.ag.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ag.empleos.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	
}
