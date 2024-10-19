package com.lsmartin.api_barber.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Usuario> buscarTodos(){
		
		return usuarioRepository.findAll();
	}
	
	public Usuario buscaPorId(Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		Usuario user = usuario.get();
		return user;
	}
	
	public Usuario atualizarUser(Usuario usuario) {
		
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	

}
