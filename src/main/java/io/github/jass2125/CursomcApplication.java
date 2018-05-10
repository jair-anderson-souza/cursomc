package io.github.jass2125;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.jass2125.domains.Categoria;
import io.github.jass2125.domains.Cidade;
import io.github.jass2125.domains.Cliente;
import io.github.jass2125.domains.Endereco;
import io.github.jass2125.domains.Estado;
import io.github.jass2125.domains.Pagamento;
import io.github.jass2125.domains.PagamentoComBoleto;
import io.github.jass2125.domains.PagamentoComCartao;
import io.github.jass2125.domains.Pedido;
import io.github.jass2125.domains.Produto;
import io.github.jass2125.domains.enums.EstadoPagamento;
import io.github.jass2125.domains.enums.TipoCliente;
import io.github.jass2125.repositories.CategoriaRepository;
import io.github.jass2125.repositories.CidadeRepository;
import io.github.jass2125.repositories.ClienteRepository;
import io.github.jass2125.repositories.EnderecoRepository;
import io.github.jass2125.repositories.EstadoRepository;
import io.github.jass2125.repositories.PagamentoRepository;
import io.github.jass2125.repositories.PedidoRepository;
import io.github.jass2125.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.addProduto(p1);
		cat1.addProduto(p2);
		cat2.addProduto(p3);

		p1.addCategoria(cat1);
		p2.addCategoria(cat2);

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.addCidade(cid1);
		est2.addCidade(cid2);
		est2.addCidade(cid3);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);

		cli1.addTelefone("27363323");
		cli1.addTelefone("93838393");

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2);

		cli1.addEndereco(e1);
		cli1.addEndereco(e2);

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);

		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pag2);

		cli1.addPedido(ped1);
		cli1.addPedido(ped2);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		
	}
}
