package io.github.jass2125.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.github.jass2125.domains.Categoria;
import io.github.jass2125.repositories.CategoriaRepository;
import io.github.jass2125.services.exceptions.ExclusaoDadosException;
import io.github.jass2125.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado!!"));
	}

	public Categoria save(Categoria categoria) {
		return repo.save(categoria);
	}

	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExclusaoDadosException(e, "Não é possível apagar objetos com dados associados!!");
		}
	}

	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return repo.save(categoria);
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Page<Categoria> searchPageable(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageable = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageable);
	}
}
