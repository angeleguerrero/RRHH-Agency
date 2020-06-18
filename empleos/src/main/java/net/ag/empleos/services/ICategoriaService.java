package net.ag.empleos.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ag.empleos.model.Categoria;


public interface ICategoriaService {
	void salvar (Categoria categoria);
	List<Categoria> buscarTCategorias();
	Categoria buscarporID(Integer idCategoria);
	void eliminar (Integer idvacante);
	Page<Categoria>buscarTodas_page(Pageable page );
}
