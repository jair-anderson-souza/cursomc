package io.github.jass2125.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.github.jass2125.domains.enums.TipoCliente;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipoCliente;
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "telefone")
	private Set<String> telefones = new HashSet<>();
	
	public Cliente() {
	}

	public Cliente(Long id, String nome, String email, String cpfOuCnpj, TipoCliente tipoCliente) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoCliente = tipoCliente.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getTipoCliente() {
		return TipoCliente.toEnum(this.tipoCliente).getDescricao();
	}

	public void setTipoCliente(Integer cod) {
		this.tipoCliente = cod;
	}

	public boolean removeEndereco(Endereco end) {
		return enderecos.remove(end);
	}

	public boolean addEndereco(Endereco endereco) {
		return this.enderecos.add(endereco);
	}

	public boolean removeTelefone(String telefone) {
		return telefones.remove(telefone);
	}

	public boolean addTelefone(String telefone) {
		return this.telefones.add(telefone);
	}


	
	
}
