package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioPedidoVO;
import com.dawes.repositorio.UsuarioPedidoRepository;
import com.dawes.servicios.ServicioUsuarioPedido;
@Service
public class ServicioUsuarioPedidoImpl implements ServicioUsuarioPedido {

	UsuarioPedidoRepository upedr;

	@Override
	public <S extends UsuarioPedidoVO> S save(S entity) {
		return upedr.save(entity);
	}

	@Override
	public <S extends UsuarioPedidoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return upedr.saveAll(entities);
	}

	@Override
	public Optional<UsuarioPedidoVO> findById(Integer id) {
		return upedr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return upedr.existsById(id);
	}

	@Override
	public Iterable<UsuarioPedidoVO> findAll() {
		return upedr.findAll();
	}

	@Override
	public Iterable<UsuarioPedidoVO> findAllById(Iterable<Integer> ids) {
		return upedr.findAllById(ids);
	}

	@Override
	public long count() {
		return upedr.count();
	}

	@Override
	public void deleteById(Integer id) {
		upedr.deleteById(id);
	}

	@Override
	public void delete(UsuarioPedidoVO entity) {
		upedr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends UsuarioPedidoVO> entities) {
		upedr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		upedr.deleteAll();
	}
	
	
}
