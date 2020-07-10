package net.ag.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ag.empleos.model.Solicitud;


public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
