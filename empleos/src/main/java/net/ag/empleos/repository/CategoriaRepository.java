package net.ag.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import net.ag.empleos.model.Categoria;



//REPOSITORIO DE SPRING DATA JPA
//public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	

}
