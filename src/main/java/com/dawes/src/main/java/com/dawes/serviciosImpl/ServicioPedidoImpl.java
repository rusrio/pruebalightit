package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.PedidoVO;
import com.dawes.repositorio.PedidoRepository;
import com.dawes.servicios.ServicioPedido;

@Service
public class ServicioPedidoImpl implements ServicioPedido{
	@Autowired
	PedidoRepository per;

	@Override
	public <S extends PedidoVO> S save(S entity) {
		return per.save(entity);
	}

	@Override
	public <S extends PedidoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return per.saveAll(entities);
	}

	@Override
	public Optional<PedidoVO> findById(Integer id) {
		return per.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return per.existsById(id);
	}

	@Override
	public Iterable<PedidoVO> findAll() {
		return per.findAll();
	}

	@Override
	public Iterable<PedidoVO> findAllById(Iterable<Integer> ids) {
		return per.findAllById(ids);
	}

	@Override
	public long count() {
		return per.count();
	}

	@Override
	public void deleteById(Integer id) {
		per.deleteById(id);
	}

	@Override
	public void delete(PedidoVO entity) {
		per.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends PedidoVO> entities) {
		per.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		per.deleteAll();
	}
	
	
}
