package com.lsmartin.api_barber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lsmartin.api_barber.dto.ClienteDTO;
import com.lsmartin.api_barber.model.Cliente;
import com.lsmartin.api_barber.service.ClienteService;

@RestController
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping("/clientes/salvar")
	public ResponseEntity<Cliente> salvarCliente(@RequestBody ClienteDTO clienteDTO){
		
		Cliente cliente2 = clienteService.salvarCliente(clienteDTO.transformarEntidade(clienteDTO));
		return new ResponseEntity<Cliente>(cliente2, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/clientes/buscarclientes")
	public ResponseEntity<List<Cliente>> buscarTodos(){
		
		List<Cliente> clientes = clienteService.buscarTodos();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/clientes/buscarporid")
	public ResponseEntity<Cliente> buscarPorId(@RequestParam	Long id){
		
		Cliente cliente = clienteService.buscarPorid(id);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/clientes/deletarporid")
	public ResponseEntity<String> deletarPorId(@RequestParam Long id){
		
		String msg = clienteService.deletarPorId(id);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	

}
