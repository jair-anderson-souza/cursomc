package io.github.jass2125.domains;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import io.github.jass2125.domains.enums.EstadoPagamento;

@Entity
@DiscriminatorValue("PAGAMENTO_COM_CARTAO")
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
