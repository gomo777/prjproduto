package com.senai.Prjteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.Prjteste.entities.Pedido;
import com.senai.Prjteste.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> getAllPedido() {
		return pedidoRepository.findAll();
	}

	public Pedido getPedidoById(long funcodigo) {
		return pedidoRepository.findById(funcodigo).orElse(null);
	}

	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public boolean deletePedido(Long id) {
		Optional<Pedido> PedidoExistente = pedidoRepository.findById(id);
		if (PedidoExistente.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Pedido updatePedido(Long funcodigo, Pedido novoPedido) {
		Optional<Pedido> PedidoOptional = pedidoRepository.findById(funcodigo);
		if (PedidoOptional.isPresent()) {
			Pedido PedidoExistente = PedidoOptional.get();
			PedidoExistente.setfunnome(novoPedido.getfunnome());
			PedidoExistente.setfunnascimento(novoPedido.getfunnascimento());
			PedidoExistente.setfunsalario(novoPedido.getfunsalario());

			// Atualize o departamento
			if (novoPedido.getCliente() != null) {
				PedidoExistente.setCliente(novoPedido.getCliente());
			}
			return pedidoRepository.save(PedidoExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}

}
