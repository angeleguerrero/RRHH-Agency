package net.ag.empleos.services;


import java.util.List;

import net.ag.empleos.model.Categoria;

public interface ICategoriaService {
	void salvar (Categoria categoria);
	List<Categoria> buscarTCategorias();
	Categoria buscarporID(Integer idCategoria);

}
