package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.PedidoProductoVO;
import com.dawes.repositorio.PedidoProductoRepository;
import com.dawes.servicios.ServicioPedidoProducto;

@Service
public class ServicioPedidoProductoImpl implements ServicioPedidoProducto {

	@Autowired
	PedidoProductoRepository ppr;

	@Override
	public <S extends PedidoProductoVO> S save(S entity) {
		return ppr.save(entity);
	}

	@Override
	public <S extends PedidoProductoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return ppr.saveAll(entities);
	}

	@Override
	public Optional<PedidoProductoVO> findById(Integer id) {
		return ppr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ppr.existsById(id);
	}

	@Override
	public Iterable<PedidoProductoVO> findAll() {
		return ppr.findAll();
	}

	@Override
	public Iterable<PedidoProductoVO> findAllById(Iterable<Integer> ids) {
		return ppr.findAllById(ids);
	}

	@Override
	public long count() {
		return ppr.count();
	}

	@Override
	public void deleteById(Integer id) {
		ppr.deleteById(id);
	}

	@Override
	public void delete(PedidoProductoVO entity) {
		ppr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PedidoProductoVO> entities) {
		ppr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ppr.deleteAll();
	}
	
}
