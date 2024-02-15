package com.senai.Prjteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.Prjteste.entities.Cliente;
import com.senai.Prjteste.repositories.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente SaveCliente(Cliente Cliente) {
		return clienteRepository.save(Cliente);
	}

	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteByid(Long depcodigo) {
		return clienteRepository.findById(depcodigo).orElse(null);
	}

	public void deleteCliente(Long depcodigo) {
		clienteRepository.deleteById(depcodigo);
	}

	// fazendo o update do nome do funcionario com o optional
	public Cliente updateDepartamento(Long depcodigo, Cliente novoCliente) {
		Optional<Cliente> ClienteOptional = clienteRepository.findById(depcodigo);
		if (ClienteOptional.isPresent()) {
			Cliente ClienteExistente = ClienteOptional.get();
			ClienteExistente.setDepnome(novoCliente.getDepnome());
			return clienteRepository.save(ClienteExistente);
		} else {
			return null;
		}

	}

}
