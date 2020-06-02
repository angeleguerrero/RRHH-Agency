package net.ag.empleos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ag.empleos.model.Vacante;



public interface VacanteRepository extends JpaRepository<Vacante, Integer> {
	
	//Metodo Implementado con palabra reservada
	List<Vacante>findByEstatus(String estatus);
	List<Vacante>findByDestacadoAndEstatusOrderByIdAsc(int destacado, String estatus);
	List<Vacante>findBySalarioBetween(double sinicial, double sfinal);	
	List<Vacante>findByEstatusIn(String[]estatus);
	
	
	
}
