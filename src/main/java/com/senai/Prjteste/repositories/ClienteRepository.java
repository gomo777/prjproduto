package com.senai.Prjteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.Prjteste.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
