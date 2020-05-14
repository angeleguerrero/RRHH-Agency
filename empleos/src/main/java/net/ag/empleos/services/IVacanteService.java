package net.ag.empleos.services;

import java.util.List;

import net.ag.empleos.model.Vacante;

public interface IVacanteService {
List<Vacante>buscarTodas();
Vacante buscarPorID(Integer idvacante);
void salvar(Vacante vacante);

}


