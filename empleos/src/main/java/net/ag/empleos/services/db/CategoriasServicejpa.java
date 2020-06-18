package net.ag.empleos.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ag.empleos.model.Categoria;
import net.ag.empleos.repository.CategoriaRepository;
import net.ag.empleos.services.ICategoriaService;
//@Primary para hacer bean como primario si existen dos en el projecto
@Service
@Primary
public class CategoriasServicejpa implements ICategoriaService {
	
	@Autowired
	private CategoriaRepository categoriasrepo;
	
	
	@Override
	public void salvar(Categoria categoria) {
		categoriasrepo.save(categoria);

	}

	@Override
	public List<Categoria> buscarTCategorias() {
		
		return categoriasrepo.findAll();
	}

	@Override
	public Categoria buscarporID(Integer idCategoria) {
		Optional<Categoria> optional =categoriasrepo.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		return null;
	}

	@Override
	public void eliminar(Integer idcategoria) {
		categoriasrepo.deleteById(idcategoria);
		
	}

	@Override
	public Page<Categoria> buscarTodas_page(Pageable page) {
		
		return categoriasrepo.findAll(page);
	}

}
