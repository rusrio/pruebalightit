package com.dawes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RolVO;
import com.dawes.servicios.ServicioRol;

@Controller
public class RolController {

	@Autowired
	ServicioRol srol;
	
	@GetMapping("/roles")
	public String tienda(Model modelo) {
		modelo.addAttribute("roles", srol.findAll());
		return "adminhtml/roles";
	}
	 //CRUD
	@GetMapping("/insertarRol")
	public String insertar(Model modelo) {
		modelo.addAttribute("rol", new RolVO());
		return "adminhtml/insertarRol";
	}
	
	@PostMapping("/submitRol")
	public String submit(@ModelAttribute RolVO rol,Model modelo) {
		srol.save(rol);
		modelo.addAttribute("rol", srol.findAll());
		return "adminhtml/submitRol";
	}
	
	@GetMapping("/eliminarRol")
	public String eliminar(@RequestParam int idrol, Model modelo){
		srol.deleteById(idrol);
		modelo.addAttribute("lineas", srol.findAll());
		return "adminhtml/eliminarRol";
	}
	
	@GetMapping("/modificarRol")
	public String modificar(@RequestParam int idrol, Model modelo){
		RolVO r=srol.findById(idrol).get();
		modelo.addAttribute("rol", r);
		return "adminhtml/modificarRol";
	}
	
}
