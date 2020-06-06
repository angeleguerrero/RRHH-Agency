package net.ag.empleos.controller;



import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.ag.empleos.model.Vacante;
import net.ag.empleos.services.IVacanteService;


@Controller
public class HomeController {

@Autowired	
private  IVacanteService serviceVacantes;


//HOME OLD
	@GetMapping({"inicio","/"})
	public String mostratHome (Model model) {
				return "home";
	}
	
	
	//Modelo Atributo general
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
		
	}
	
	
	@GetMapping("/listado")
	public String mostratListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero en Sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);

		return "listado" ;
		
	}
	
	@GetMapping("/detallevacante")
	public String mostrarDetalleVacante(Model model) {
		Vacante vacante = new Vacante();
		
		vacante.setNombre("Ingeniero Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		
		model.addAttribute("vacante", vacante);
		
		return"vacantes/detallevacante";
		
	}
	
	@GetMapping("/listarvacantes")
	public String mostrarTabla (Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "listar";
		
	}
}


