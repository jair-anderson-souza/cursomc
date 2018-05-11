package io.github.jass2125.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jass2125.domains.Pedido;
import io.github.jass2125.repositories.PedidoRepository;
import io.github.jass2125.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscaPorId(Long id) {
		return this.pedidoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Não foi possível buscar o dado!!"));
	}
}
