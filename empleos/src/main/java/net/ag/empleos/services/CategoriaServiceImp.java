package net.ag.empleos.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.ag.empleos.model.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriaService{
private List<Categoria> lista =null;


public CategoriaServiceImp() {
	lista=new LinkedList<Categoria>();
	
	Categoria categoria1= new Categoria();
	categoria1.setId(1);
	categoria1.setNombre("Medico GEN01");
	categoria1.setDescripcion("Medico internista");
	
	Categoria categoria2= new Categoria();
	categoria2.setId(2);
	categoria2.setNombre("Contabilidad ASI01 ");
	categoria2.setDescripcion("Asisetnte Contabilidad");
	
	Categoria categoria3= new Categoria();
	categoria3.setId(3);
	categoria3.setNombre("Leyes IMP01");
	categoria3.setDescripcion("Abogado Impositivo");
	

	Categoria categoria4= new Categoria();
	categoria4.setId(4);
	categoria4.setNombre("Psicologia GEN01");
	categoria4.setDescripcion("Psicologia General");
	

	Categoria categoria5= new Categoria();
	categoria5.setId(5);
	categoria5.setNombre("Ingenieria en Sistemas SOF02");
	categoria5.setDescripcion("Ingeniero de Software");
	
	lista.add(categoria1);
	lista.add(categoria2);
	lista.add(categoria3);
	lista.add(categoria4);
	lista.add(categoria5);
}



	
	public void salvar(Categoria categoria) {
	lista.add(categoria);	
		
	}


	public List<Categoria> buscarTCategorias() {		
		return lista;
	}


	public Categoria buscarporID(Integer idCategoria) {
		for (Categoria objcategoria: lista) {
			if (objcategoria.getId()==idCategoria) {
				return objcategoria;
			}		
		}
				
		return null;
	}

}
