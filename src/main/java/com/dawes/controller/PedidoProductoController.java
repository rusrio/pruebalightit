package com.dawes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dawes.repositorio.PedidoProductoRepository;
import com.dawes.repositorio.UsuarioPedidoRepository;

@Controller
public class PedidoProductoController {
	
	@Autowired
	PedidoProductoRepository pp;
	
	@Autowired
	UsuarioPedidoRepository up;
	
	@GetMapping("/gestion_pedidos")
	public String gestion_pedidos(Model modelo) {
	modelo.addAttribute("pedidoproducto", pp.findAll());
	modelo.addAttribute("usuariopedido", up.findAll());
	return "adminhtml/gestion_pedidos";
	}
	
}
