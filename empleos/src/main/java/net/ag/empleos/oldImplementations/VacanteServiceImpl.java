package net.ag.empleos.oldImplementations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import net.ag.empleos.model.Vacante;
import net.ag.empleos.services.IVacanteService;

@Service
//@Primary
public class VacanteServiceImpl implements IVacanteService{
	private List<Vacante> lista = null;
	
	public VacanteServiceImpl() {
		SimpleDateFormat sdf_fp = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
//			Oferta Trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
			vacante1.setFecha(sdf_fp.parse("04-09-2019"));
			vacante1.setSalario(15000.0);
			vacante1.setDestacado(0);
			vacante1.setEstatus("Activo");
			vacante1.setImagen("empresa1.jpg");
			
//			Oferta de trabajo 2
			
		
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero en Sistemas");
			vacante2.setDescripcion("Solicitamos Ing. en Sistemas para diseñar Software de Ventas");
			vacante2.setFecha(sdf_fp.parse("30-04-2020"));
			vacante2.setSalario(80000.0);
			vacante2.setEstatus("Activo");
			vacante2.setDestacado(1);
			vacante2.setImagen("ing-sistemas.jpg");
			
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Lic. Psicologia");
			vacante3.setDescripcion("Solicitamos Lic. Psicologia para puesto de Asistente de RRHH");
			vacante3.setFecha(sdf_fp.parse("30-02-2020"));
			vacante3.setSalario(20000.0);
			vacante3.setDestacado(1);
			
			
			/*Agregar los objetos a una lista*/
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			
			
		}	catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	
	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}


	@Override
	public Vacante buscarPorID(Integer idvacante) {
		for (Vacante objvacante: lista) {
			if (objvacante.getId()==idvacante) {
				return objvacante;	
			}
		}
		return null;
	}


	
	public void salvar(Vacante vacante) {
		lista.add(vacante);
	}


	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

}
