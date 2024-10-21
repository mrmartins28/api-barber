package com.lsmartin.api_barber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lsmartin.api_barber.dto.UsuarioDTO;
import com.lsmartin.api_barber.model.Usuario;
import com.lsmartin.api_barber.service.UsuarioService;


@RestController
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		
		this.usuarioService = usuarioService;
	}
	@PostMapping("/usuarios/salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		
		Usuario usuario2 = usuarioService.salvar(usuario);
		return new ResponseEntity<Usuario>(usuario2, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/usuarios/buscartodos")
	public ResponseEntity<List<Usuario>> buscarTodos(){
		
		List<Usuario> usuarios = usuarioService.buscarTodos();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usuarios/buscarporid")
	public ResponseEntity<Usuario> buscarPorId(@RequestParam Long id){
		
		Usuario usuario = usuarioService.buscaPorId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "atualizar")
	public <T> ResponseEntity<?> atualizarUser(@RequestBody Usuario usuario){
		
		
		if(usuario.getId()== null ) {
			return new ResponseEntity<String>("Id não pode ser nulo.", HttpStatus.OK);
			
		} 
		Usuario user = usuarioService.atualizarUser(usuario);
			
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);	
		
		
	}
	
	@DeleteMapping("/usuarios/deletarUser")
	public ResponseEntity<String> deletarUser(Long id){
		
	String msg =	usuarioService.deletarUsuarioId(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}


}
