package io.github.jass2125.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.jass2125.domains.Categoria;
import io.github.jass2125.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService catService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Categoria cat = catService.buscar(id);
		return ResponseEntity.ok().body(cat);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria categoria) {
		Categoria cat = catService.salvar(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
//		catService.delete(id);
//		return ResponseEntity.noContent().build();
//	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deletar(@PathVariable Long id) {
		catService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
