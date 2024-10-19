package com.lsmartin.api_barber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO usuarioDTO){
		
		Usuario usuario = usuarioService.salvar(usuarioDTO.transformaEntidade(usuarioDTO));
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
		
	}

}
