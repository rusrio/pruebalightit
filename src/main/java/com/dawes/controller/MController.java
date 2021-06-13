package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dawes.servicios.ServicioProducto;
import com.dawes.servicios.ServicioRol;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.servicios.ServicioUsuarioProducto;
import com.dawes.servicios.ServicioUsuarioRol;

@Controller
public class MController {

	
	@Autowired
	ServicioProducto sproducto;
	
	@Autowired
	ServicioRol srol;

	
	@Autowired
	ServicioUsuarioProducto susuarioproducto;
	
	@Autowired
	ServicioUsuarioRol susuariorol;
	

	
	@GetMapping("/index")
	public String lineas(Model modelo) {

	return "index";
	}
	
	
	@GetMapping("/login")
	public String login() {
	return "login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "adminhtml/panel_admin";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/error403")
	public String error403() {
	return "error403";
	}
	
}
