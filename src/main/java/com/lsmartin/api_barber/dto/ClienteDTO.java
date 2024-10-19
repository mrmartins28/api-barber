package com.lsmartin.api_barber.dto;

import java.util.List;

import com.lsmartin.api_barber.model.Cliente;
import com.lsmartin.api_barber.model.Telefone;

public class ClienteDTO {
	
	private String nome;
	
	private String email;
	
	private List<Telefone> telefones;
	
	private String tipo;
	
	public ClienteDTO() {
		
		
	}

	public ClienteDTO(String nome, String email, List<Telefone> telefones, String tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
		this.tipo = tipo;
	} 
	
	public Cliente transformarEntidade(ClienteDTO clienteDTO) {
		
		return new Cliente(null, nome, email, telefones, tipo);
		
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
