package com.lsmartin.api_barber.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsmartin.api_barber.model.Cliente;
import com.lsmartin.api_barber.repository.ClienteRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorid(Long id) {
		return clienteRepository.findById(id).get();
	}
	
	public String deletarPorId(Long id) {
		clienteRepository.deleteById(id);
		return "Deletado com sucesso!";
	}

}
