package io.github.jass2125.domains;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import io.github.jass2125.domains.enums.EstadoPagamento;

@Entity
@DiscriminatorValue("PAGAMENTO_COM_BOLETO")
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date dataPagamento;

	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
