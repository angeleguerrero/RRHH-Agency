package net.ag.empleos.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.ag.empleos.model.Perfil;
import net.ag.empleos.model.Usuario;
import net.ag.empleos.model.Vacante;
import net.ag.empleos.services.ICategoriaService;
import net.ag.empleos.services.IUsuarioService;
import net.ag.empleos.services.IVacanteService;


@Controller
public class HomeController {

@Autowired	
private  IVacanteService serviceVacantes;

@Autowired
private IUsuarioService serviceUsuario;

@Autowired
private ICategoriaService serviceCategoria;

@Autowired
private PasswordEncoder passwordEncoder;

//HOME OLD
	@GetMapping({"/"})
	public String mostratHome (Model model) {
				return "home";
	}
	
	@GetMapping({"/inicio"})
	public String mostraIndex(Authentication auth, HttpSession session) {
		String username = auth.getName();
		System.out.println("Usuario en sesion: " + username);
		
		//Verificar rol del usuario 
		for(GrantedAuthority roles: auth.getAuthorities()) {
			System.out.println("Grupo de usuarios: " + roles.getAuthority());
			
		}
		
		//para presentar usuario en html
		if (session.getAttribute("usuario")==null) {
		Usuario usuario = serviceUsuario.buscarPoUsername(username);
		usuario.setPassword(null);
		System.out.println("Usuario: " + usuario);
		session.setAttribute("usuario", usuario);
		}
		return "redirect:/";
		
	}
	
	
//	CREAR USUARIO
	@GetMapping("/singup")
	public String registrarse(Usuario usuario) {
		return "usuarios/crearUsuario";
		
	}
	
	
//	GUARDAR USUARIO
	@PostMapping("/registrarse")
	public String guardarRegistro(Usuario usuario,BindingResult result, RedirectAttributes attributes) {
//		Para encriptar password
		String pswPlano = usuario.getPassword();
		String pwEncriptado = passwordEncoder.encode(pswPlano);
		usuario.setPassword(pwEncriptado);
		usuario.setEstatus(1); //activar usuario por defecto
		usuario.setFecharegistro(new Date()); // fecha de registro que es la fecha actual del servidor
		//Agregar objeto a perfil y crear un perfil por defecto al usuario
		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregarPerfilUser(perfil);
		
		if (result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.err.println("Ocurrio un erro tratando de convertir un valor" + error.getDefaultMessage());
			}
			return "usuarios/crearUsuario";	
		}
		
		serviceUsuario.salvar(usuario); 
		attributes.addFlashAttribute("msj", "Registro Salvado");
		System.out.println("usuario " + usuario);
		return"redirect:/inicio";
		
	}
	

	
//	Para convertir fecha desde Spring
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));	
	}
	
	
	//Modelo Atributo general
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
		model.addAttribute("categorias" , serviceCategoria.buscarTCategorias());
		Vacante vacanteBuscar = new Vacante();
		model.addAttribute("buscarvacante", vacanteBuscar );
		vacanteBuscar.resetimagen();
//		model.addAttribute("tusuario", serviceUsuario.buscarTUsuarios());
		
	}
	
	
	@GetMapping("/buscarvacante")	
	public String buscarVacante(@ModelAttribute("buscarvacante") Vacante vacante, Model model) {
		
//		PARA USAR LIKE EN VEZ DE = IGUAL PARA BUSQUEDA LIKE =%?%
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<Vacante> example = Example.of(vacante, matcher);
		List<Vacante>lista = serviceVacantes.buscarByExample(example);
		model.addAttribute("vacantes", lista);
		System.out.println("Buscando por:"+ vacante);
		return "home";
	}
	
//	Metodo para cuando un valor sea detactado vacio lo cambie a null
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		
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


