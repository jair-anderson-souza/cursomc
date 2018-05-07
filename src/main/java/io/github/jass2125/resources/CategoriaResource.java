package io.github.jass2125.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.jass2125.domains.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria c1 = new Categoria(1L, "Informática");
		Categoria c2 = new Categoria(2L, "Escritório");
		List<Categoria> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		return lista;
	}
}
