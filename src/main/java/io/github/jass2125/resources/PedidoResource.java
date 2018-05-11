package io.github.jass2125.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.jass2125.domains.Pedido;
import io.github.jass2125.services.PedidoService;


@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
		Pedido pedido = this.pedidoService.buscaPorId(id);
		return ResponseEntity.ok().body(pedido);
	}

}
