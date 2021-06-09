package com.dawes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioRol;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.servicios.ServicioUsuarioCustom;
import com.dawes.servicios.ServicioUsuarioRol;

@Controller
public class UsuarioController {

	@Autowired
	ServicioUsuario susuario;
	
	@Autowired
	ServicioUsuarioRol susuariorol;

	@Autowired
	ServicioRol sr;
	
	@Autowired
	ServicioUsuarioCustom susucustom;
	
	
	@GetMapping("/usuarios")
	public String usuarios(Model modelo) {
		modelo.addAttribute("usuarios", susuario.findAll());
		return "adminhtml/usuarios";
	}
	 //CRUD
/*	@GetMapping("/insertarUsuario")
	public String insertar(Model modelo) {
		modelo.addAttribute("usuarios", new UsuarioVO());
		modelo.addAttribute("usuarioroles", new UsuarioRolVO());
		modelo.addAttribute("roles", sr.findAll());
		return "admin/insertarUsuario";
	}
	
	@PostMapping("/submitUsuario")
	public String submitUsuario(@ModelAttribute UsuarioVO usuario,RolVO rol,Model modelo) {
		susuario.save(usuario);
		UsuarioRolVO newusuariorol = new UsuarioRolVO(0, usuario, rol);
		susuariorol.save(newusuariorol);
		modelo.addAttribute("usuarioroles", susuariorol.findAll());
		return "admin/";
	}
	
	@GetMapping("/eliminarUsuario")
	public String eliminarUsuario(@RequestParam int idusuariorol, Model modelo){
		susuariorol.deleteById(idusuariorol);
		modelo.addAttribute("usuariorol", susuariorol.findAll());
		return "admin/eliminarUsuario";
	}
	
	@GetMapping("/modificarUsuario")
	public String modificarUsuario(@RequestParam int idusuario, Model modelo){
		UsuarioVO usu=susuario.findById(idusuario).get();
		modelo.addAttribute("usuario", usu);
		return "admin/modificarUsuario";
	}
*/	
	@GetMapping("/usuario")
	public String panel_usuario(@RequestParam int idusuario, Model modelo){
		UsuarioVO usuario = susuario.findById(idusuario).get();
		modelo.addAttribute("customusuario", susucustom.findByUsuario(usuario));
		modelo.addAttribute("usuario", usuario);
		return "registrado/usuario";
	}
	
}
