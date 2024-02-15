package com.senai.Prjteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.Prjteste.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
