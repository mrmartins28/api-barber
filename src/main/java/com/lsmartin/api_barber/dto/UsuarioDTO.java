package com.lsmartin.api_barber.dto;

import com.lsmartin.api_barber.model.Usuario;

import lombok.Getter;
import lombok.Setter;


public class UsuarioDTO {
	
	private String nome;
	
	private String login;
	
	private String senha;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(String nome, String login, String senha) {
		
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario transformaEntidade(UsuarioDTO usuarioDTO) {
		
		return new Usuario(nome, login, senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
