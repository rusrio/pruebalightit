package com.dawes.controller;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.CustomVO;
import com.dawes.modelo.ProductoVO;
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
		return "registrado/insertarCustom";
	}
	
	@PostMapping("/submitCustom")
	public String submitCustom(Model modelo, @ModelAttribute CustomVO custom) {
		sc.save(custom);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		UsuarioVO usuariologeado = susu.findByNombre(username);
		UsuarioCustomVO usuariocustom = new UsuarioCustomVO(0,usuariologeado,custom,LocalDate.now());
		suc.save(usuariocustom);
		return "redirect:/usuario";
	}
	
	@GetMapping("/eliminarCustom")
	public String eliminar(@RequestParam int idusuariocustom, Model modelo){
		suc.deleteById(idusuariocustom);
		modelo.addAttribute("usuarioproducto", suc.findAll());
		return "redirect:/gestion_custom";
	}
	
	
	@GetMapping("/usuario")
	public String panel_usuario(Model modelo, Authentication auth){
		
		String nombreusulogeado = auth.getName();
		UsuarioVO usuariologeado = susu.findByNombre(nombreusulogeado);
		List<UsuarioCustomVO> usuariocustom = suc.findByUsuario(usuariologeado);
		modelo.addAttribute("usuariocustom",usuariocustom);
		modelo.addAttribute("usuario",usuariologeado);
		
		return "registrado/usuario";
	}
	
	@GetMapping("/gestion_custom")
	public String gestion_custom(Model modelo) {
	modelo.addAttribute("usuariocustom", suc.findAll());
	return "adminhtml/gestion_custom";
	}
	
	
	@GetMapping("/ver_custom")
	public String ver_producto(@RequestParam int idcustom, Model modelo, HttpServletRequest request) {
		CustomVO cust = sc.findById(idcustom).get();
		modelo.addAttribute("custom", cust);
		
		return "registrado/ver_custom";
	}
}
