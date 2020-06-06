package net.ag.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.ag.empleos.model.Vacante;
import net.ag.empleos.services.ICategoriaService;
import net.ag.empleos.services.IVacanteService;
import net.ag.empleos.util.Utileria;

@Controller
@RequestMapping(value = "vacantes")
public class VacantesController {
	//nombre propiedad para ruta imagenes
	@Value("${empleos.ruta.imagenes}")
	private String ruta;

	@Autowired
	private IVacanteService serviceVacantes;
	@Autowired
	//@Qualifier("categoriasServicejpa")
	private ICategoriaService serviceCategoria;

	@GetMapping("/viewe/{idvacante}")
	public String verDetalles(@PathVariable("idvacante") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorID(idVacante);
		System.out.println("Vancante: " + vacante);
		model.addAttribute("vacante", vacante);
//		Buscar detalle vacante en BBDD
		return "vacantes/detalleVacante";
	}
	
	

	@PostMapping("/salvar")
	public String salvar( Vacante vacante, BindingResult result, RedirectAttributes atributes, @RequestParam("archivoImagen")//archivoImagen mismo nombre de campo en form
	MultipartFile multipart){ 
		// Verificar Errores
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.err.println("Ocurrio un error Trarando de convertir un valor: " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";	
		}
		
		//If Subir Imagen
		if (!multipart.isEmpty()) {
			//String ruta = "/empleos/omg-vacantes/"; //Ruta para Linux y MAC IOS
			// OLD CODE String ruta = "c:/Users/HELLAS/Spring workspace/empleos/img-vacantes/";
			
			String nombreImagen = Utileria.guardarArchivo(multipart, ruta);
			if (nombreImagen !=null) {//Verificar si la imagen cargo a la direccion
				//Se procesa la variable nombreImagen
			
				vacante.setImagen(nombreImagen);	
			}
		}
		
		
		serviceVacantes.salvar(vacante);
		atributes.addFlashAttribute("msj", "Registro Salvado con Exito!");
		
	System.out.println("Vacante: " + vacante);
	return "redirect:/vacantes/listar";
	
}
	

	@GetMapping("/eliminar")
	public String eliminarVacante(@RequestParam("idvacante") int idVacante, Model model) {
		System.out.println("Borrando parametros con id" + idVacante);
		model.addAttribute("idvacante", idVacante);

		return "deleteVacante";

	}

	@GetMapping("/crear")
	public String crearVancante(Vacante vacante, Model model) {
		model.addAttribute("categorias", serviceCategoria.buscarTCategorias());
		return "vacantes/formVacante";
	}
	
//	Para convertir fecha desde Spring
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));	
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return"vacantes/listVacantes";
		
	}
	
	
	
}

/*
 * @PostMapping("/salvar") 
 * public String salvar(@RequestParam ("nombre") String
 * nombre, @RequestParam ("descripcion") String descripcion,
 * @RequestParam("estatus") String estatus, @RequestParam ("fecha") String
 * fecha, @RequestParam ("destacado") int destacado,
 * @RequestParam ("salario") double salario, @RequestParam ("detalles") String
 * detalle) { 
 * 
 * System.out.println("Nombre: " + nombre);
 * System.out.println("Descripcion: " + descripcion);
 * System.out.println("Estatus: " + estatus); 
 * System.out.println("Fecha: "+fecha); 
 * System.out.println(" Destacado: " + destacado);
 * System.out.println(" Salario: " + salario); 
 * System.out.println("Detalle: " +
 * detalle); 
 * 
 * return "vacantes/listVacantes";
 * 
 * }
 */
