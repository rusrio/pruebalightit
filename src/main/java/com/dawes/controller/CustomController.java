package com.dawes.controller;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.CustomVO;
import com.dawes.modelo.UsuarioCustomVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioCustom;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.servicios.ServicioUsuarioCustom;

@Controller
public class CustomController {
	 
	 @Autowired
	 ServicioUsuario susu;
	 
	 @Autowired
	 ServicioCustom sc;
	 
	 @Autowired
	 ServicioUsuarioCustom suc;
	
	
	@GetMapping("/custom")
	public String tienda(Model modelo) {
		modelo.addAttribute("customs", suc.findAll());
		return "custom";
	}
	 //CRUD
	@GetMapping("/insertarCustom")
	public String insertarCustom(Model modelo) {
		modelo.addAttribute("custom", new CustomVO());
		return "insertarCustom";
	}
	
	@PostMapping("/submitCustom")
	public String submitCustom(Model modelo, @ModelAttribute CustomVO custom, Authentication auth, Principal principal) {
		sc.save(custom);
		String usernamelogeado = auth.getUsername();
		UserDetails usuariologeado = susu.findByUsername(usernamelogeado);
		String usuariosesion = usuariologeado.getUsername();
		UsuarioVO usuario = susu.findByNombre(usuariosesion);
		UsuarioCustomVO usuariocustom = new UsuarioCustomVO(0,usuario,custom,LocalDate.now());
		suc.save(usuariocustom);
		return "redirect:/insertarCustom";
	}
	
	@GetMapping("/eliminarCustom")
	public String eliminar(@RequestParam int idusuarioproducto, Model modelo){
		suc.deleteById(idusuarioproducto);
		modelo.addAttribute("usuarioproducto", suc.findAll());
		return "redirect:/custom";
	}
	
	@GetMapping("/modificarCustom")
	public String modificar(@RequestParam int idusuarioproducto, Model modelo){
		UsuarioCustomVO usuprod=suc.findById(idusuarioproducto).get();
		modelo.addAttribute("usuarioproducto", usuprod);
		return "adminhtml/modificarUsuarioProducto";
	}
	
	@GetMapping("/usuario")
	public String panel_usuario(Model modelo, Authentication auth){
		
		
		return "registrado/usuario";
	}
	
}
