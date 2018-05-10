package io.github.jass2125.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jass2125.domains.Categoria;
import io.github.jass2125.repositories.CategoriaRepository;
import io.github.jass2125.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado!!"));
	}

}
