package com.lsmartin.api_barber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsmartin.api_barber.model.Usuario;
import com.lsmartin.api_barber.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		
		this.usuarioRepository = usuarioRepository;
	}
	public UsuarioService() {
		this.usuarioRepository = null;
		
	}
	
	public Usuario salvar(Usuario usuario){
		
		return usuarioRepository.save(usuario);
		
	}
	

}
