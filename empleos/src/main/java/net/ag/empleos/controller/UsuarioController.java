package net.ag.empleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.ag.empleos.model.Usuario;
import net.ag.empleos.services.IUsuarioService;
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService serviceUsuario;
	

	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
	public String listarusuarios(Model model) {
		List<Usuario> lista = serviceUsuario.buscarTUsuarios();
		model.addAttribute("usuarios", lista);
		return"/usuarios/listarUsuarios";
	}
	
	
	@GetMapping("/editar/{idusuario}")
	public String editarUsuario(@PathVariable("idusuario") int idUsuario, Model model) {
	Usuario usuario = serviceUsuario.buscarporID(idUsuario);
	model.addAttribute("usuario" , usuario );
	return "/usuarios/crearUsuario";	
	}
	
	@GetMapping("/eliminar/{idusuario}")
	public String eliminar(@PathVariable("idusuario") int idUsuario, RedirectAttributes attributes) {		    	
		// Eliminamos el usuario
    	serviceUsuario.eliminar(idUsuario);		
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!.");
		return "redirect:/usuarios/listarUsuarios";
	}
	
}
