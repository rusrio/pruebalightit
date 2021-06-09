package com.dawes.controller;
import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dawes.modelo.ProductoVO;
import com.dawes.modelo.UsuarioProductoVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioProducto;
import com.dawes.servicios.ServicioUsuario;
import com.dawes.servicios.ServicioUsuarioProducto;

@Controller
public class UsuarioProductoController {
	 @Autowired
	ServicioUsuarioProducto susuprod;
	 
	 @Autowired
	ServicioUsuario susu;
	 
	 @Autowired
	ServicioProducto sprod;
	
	
	@GetMapping("/usuarioProducto")
	public String tienda(Model modelo) {
		modelo.addAttribute("usuarioproductos", susuprod.findAll());
		return "usuarioProductos";
	}
	 //CRUD
	@GetMapping("/insertarUsuarioProducto")
	public String insertar(Model modelo) {
		modelo.addAttribute("usuarioproducto", new UsuarioProductoVO());
		modelo.addAttribute("usuario", new ProductoVO());
		modelo.addAttribute("producto", new ProductoVO());
		return "insertarUsuarioProducto";
	}
	
	@PostMapping("/submitUsuarioProducto")
	@ResponseBody
	public String submit(@ModelAttribute UsuarioProductoVO usuprod, Model modelo, int idusuarioproducto, int idusuario, ProductoVO producto, UsuarioVO usuario, Date fecha, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		String imgnombre = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		producto.setImagen(imgnombre);
		
		usuario = susu.findById(idusuario).get();
		susuprod.save(new UsuarioProductoVO(0, usuario, producto, fecha));
		
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
