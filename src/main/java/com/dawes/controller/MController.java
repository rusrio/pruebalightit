package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dawes.servicios.ServicioPedido;
import com.dawes.servicios.ServicioPedidoProducto;
import com.dawes.servicios.ServicioProducto;
import com.dawes.servicios.ServicioRol;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.servicios.ServicioUsuarioPedido;
import com.dawes.servicios.ServicioUsuarioProducto;
import com.dawes.servicios.ServicioUsuarioRol;

@Controller
public class MController {

	@Autowired
	ServicioPedido spedido;
	
	@Autowired
	ServicioPedidoProducto spedidoproducto;
	
	@Autowired
	ServicioProducto sproducto;
	
	@Autowired
	ServicioRol srol;
	
	@Autowired
	ServicioUsuario susuario;
	
	@Autowired
	ServicioUsuarioPedido susuariopedido;
	
	@Autowired
	ServicioUsuarioProducto susuarioproducto;
	
	@Autowired
	ServicioUsuarioRol susuariorol;
	

	
	@GetMapping("/index")
	public String lineas(Model modelo) {
	modelo.addAttribute("pedidos", spedido.findAll());
	return "index";
	}
	
	@GetMapping("/registro")
	public String registro() {
	return "registro";
	}
	
	@GetMapping("/login")
	public String login() {
	return "login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "adminhtml/panel_admin";
	}
	
	@GetMapping("/error403")
	public String error403() {
	return "error403";
	}
	
}
