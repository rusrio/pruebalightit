package com.dawes.controller;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dawes.modelo.CustomVO;
import com.dawes.modelo.UsuarioCustomVO;
import com.dawes.modelo.UsuarioProductoVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioCustom;
import com.dawes.servicios.ServicioProducto;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.servicios.ServicioUsuarioCustom;
import com.dawes.servicios.ServicioUsuarioProducto;

@Controller
public class UsuarioProductoController {
	 @Autowired
	ServicioUsuarioProducto susuprod;
	 
	 @Autowired
	ServicioUsuario susu;
	 
	 @Autowired
	ServicioProducto sprod;
	 
	 @Autowired
	 ServicioCustom sc;
	 
	 @Autowired
	 ServicioUsuarioCustom suc;
	
	
	@GetMapping("/usuarioProducto")
	public String tienda(Model modelo) {
		modelo.addAttribute("usuarioproductos", susuprod.findAll());
		return "usuarioProductos";
	}
	 //CRUD
	@GetMapping("/insertarCustom")
	public String insertarCustom(Model modelo) {
		modelo.addAttribute("custom", new CustomVO());
		return "insertarUsuarioProducto";
	}
	
	@PostMapping("/submitCustom")
	public String submitCustom(Model modelo, @ModelAttribute CustomVO custom, Authentication auth, String username) {
		sc.save(custom);
		username = auth.getUsername();
		UsuarioVO usuariologeado = susu.findByNombre(username);
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UsuarioCustomVO usuariocustom = new UsuarioCustomVO(0,usuariologeado,custom,LocalDate.now());
		suc.save(usuariocustom);
		return "adminhtml/submitUsuarioProducto";
	}
	
	@GetMapping("/eliminarUsuarioProducto")
	public String eliminar(@RequestParam int idusuarioproducto, Model modelo){
		susuprod.deleteById(idusuarioproducto);
		modelo.addAttribute("usuarioproducto", susuprod.findAll());
		return "adminhtml/eliminarUsuarioProducto";
	}
	
	@GetMapping("/modificarUsuarioProducto")
	public String modificar(@RequestParam int idusuarioproducto, Model modelo){
		UsuarioProductoVO usuprod=susuprod.findById(idusuarioproducto).get();
		modelo.addAttribute("usuarioproducto", usuprod);
		return "adminhtml/modificarUsuarioProducto";
	}
	
}
