package com.dawes.controller;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.dawes.servicios.ServicioUsuarioRol;
import com.sun.xml.bind.v2.runtime.output.Encoded;

@Controller
public class UsuarioRolController {

	@Autowired
	ServicioRol sr;
	
	@Autowired
	ServicioUsuarioRol sur;
	
	@Autowired
	ServicioUsuario su;
	
	@Bean
	public BCryptPasswordEncoder BCryptPasswordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	public String encripta(String password) {
		return BCryptPasswordEncode().encode(password);
	}
	
	@GetMapping("/gestion_usuarios")
	public String gestion_usuarios(Model modelo) {
		modelo.addAttribute("usuarioroles", sur.findAll());
	return "adminhtml/gestion_usuarios";
	}
	
	@GetMapping("/insertarUsuario")
	public String insertarUsuario(Model modelo) {
		modelo.addAttribute("usuario", new UsuarioVO());
		modelo.addAttribute("roles",sr.findAll());
		return "adminhtml/insertarUsuario";
	}
	
	@PostMapping("/submitUsuario")
	public String submitUsuario(@ModelAttribute UsuarioVO usuario,HttpServletRequest request, Model modelo) {
		su.save(usuario);
		String selectedRol = request.getParameter("selectedRol");
		int selectedRolInt = Integer.parseInt(selectedRol);
		RolVO rolselected = sr.findById(selectedRolInt).get();
		UsuarioRolVO usuariorol = new UsuarioRolVO(0,usuario,rolselected);
		sur.save(usuariorol);
		modelo.addAttribute("usuarios", su.findAll()); 
		modelo.addAttribute("usuarioroles", sur.findAll());
		return "redirect:/gestion_usuarios";
	}
	
	@GetMapping("/insertarUsuariorol")
	public String insertarUsuariorol(Model modelo) {
		modelo.addAttribute("usuariorol", new UsuarioRolVO());
		return "adminhtml/";
	}
	
	@PostMapping("/submitUsuariorol")
	public String submit(@ModelAttribute UsuarioRolVO usuariorol,Model modelo) {
		sur.save(usuariorol);
		modelo.addAttribute("usuariorol", sur.findAll());
		return "redirect:/gestion_usuarios";
	}
	
	@GetMapping("/eliminarUsuario")
	public String eliminar(@RequestParam int idusuario, Model modelo){
		sur.deleteByUsuario(su.findById(idusuario).get());
		su.deleteById(idusuario);
		modelo.addAttribute("usuariorol", sur.findAll());
		return "redirect:/gestion_usuarios";
	}
	
	@GetMapping("/registro")
	public String registro(Model modelo, String username, String nombre, String password) {
		modelo.addAttribute("username",new UsuarioVO(0, username, nombre, password, LocalDate.now()));
		return "registro";
	}
	
	@PostMapping("/submitRegistro")
	public String submitRegistro(@ModelAttribute UsuarioVO usuini, Model modelo) {
		UsuarioVO usuario = usuini;
		usuario.setUsername(usuario.getNombre());
		usuario.setFechaRegistro(LocalDate.now());
		usuario.setPassword(encripta(usuario.getContrasena_registro()));
		RolVO rolselected = sr.findById(2).get();
		su.save(usuario);
		UsuarioRolVO usuariorol = new UsuarioRolVO(0,usuario,rolselected);
		sur.save(usuariorol);
		modelo.addAttribute("usuario", usuario); 
		modelo.addAttribute("usuarioroles", sur.findAll());
		return "redirect:/index";
	}
	
	
}
