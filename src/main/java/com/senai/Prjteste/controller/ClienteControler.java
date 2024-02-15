package com.senai.Prjteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.Prjteste.entities.Cliente;
import com.senai.Prjteste.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {
	private final ClienteService ClienteService;

	@Autowired
	public ClienteControler(ClienteService ClienteService) {
		this.ClienteService = ClienteService;
	}

	@PostMapping
	public Cliente createProduct(@RequestBody Cliente Cliente) {
		return ClienteService.SaveCliente(Cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Long depcodigo) {
		Cliente Cliente = ClienteService.getClienteByid(depcodigo);
		if (Cliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long depcodigo) {
		ClienteService.deleteCliente(depcodigo);
	}

	@GetMapping("/")
	public ResponseEntity<List<Cliente>> getAllCliente() {
		List<Cliente> novoCliente = ClienteService.getAllCliente();
		return ResponseEntity.ok(novoCliente);
	}

	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable Long depcodigo, @RequestBody Cliente Cliente) {
		return ClienteService.getClienteByid(depcodigo);
	}
}
