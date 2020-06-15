package net.ag.empleos.services;

import java.util.List;

import org.springframework.data.domain.Example;

import net.ag.empleos.model.Vacante;

public interface IVacanteService {
List<Vacante>buscarTodas();
Vacante buscarPorID(Integer idvacante);
void salvar(Vacante vacante);
List<Vacante>buscarDestacadas();
List<Vacante>buscarByExample(Example<Vacante> example);
void eliminar (Integer idvacante);


}


