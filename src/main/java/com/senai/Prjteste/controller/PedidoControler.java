package com.senai.Prjteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.Prjteste.entities.Pedido;
import com.senai.Prjteste.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoControler {
	private final PedidoService PedidoService;

	@Autowired
	public PedidoControler(PedidoService PedidoService) {
		this.PedidoService = PedidoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findPedidobyId(@PathVariable Long id) {
		Pedido Pedido = PedidoService.getPedidoById(id);
		if (Pedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Pedido>> findAllUsuarioscontrol() {
		List<Pedido> Pedido = PedidoService.getAllPedido();
		return ResponseEntity.ok(Pedido);
	}

	@PostMapping("/")
	public ResponseEntity<Pedido> insertUsuariosControl(@RequestBody Pedido Pedido) {
		Pedido novoPedido = PedidoService.savePedido(Pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long funcodigo, @RequestBody Pedido funcionario) {
		Pedido PedidoAtualizado = PedidoService.updatePedido(funcodigo, funcionario);
		if (PedidoAtualizado != null) {
			return ResponseEntity.ok(PedidoAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/id")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long funcodigo) {
		boolean remover = Pedido.deletePedido(funcodigo);
		if (remover) {
			return ResponseEntity.ok().body("usuario Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
