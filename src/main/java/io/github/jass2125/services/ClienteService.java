package io.github.jass2125.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jass2125.domains.Cliente;
import io.github.jass2125.repositories.ClienteRepository;
import io.github.jass2125.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Long id) {
		return clienteRepository
				.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}
	
}
