package net.ag.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "categorias")
public class CategoriasController {
//	@GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {	
		return "categorias/listarCategorias";
	}
	
//	@GetMapping("/create")
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String crear(Model model) {	
		return "categorias/createCategoria";
	}
	
//	@GetMapping("/salvar")
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("categoria") String categoria, @RequestParam("descripcion") String descripcion, Model model) {	
		System.out.println("Categoria: " + categoria);
		System.out.println("Descripcion: " + descripcion);
		
		return "categorias/listarCategorias";
	}
	
	
	

}
