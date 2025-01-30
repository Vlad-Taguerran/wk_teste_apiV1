package com.wktecnologyteste.wkteste.repository;

import com.wktecnologyteste.wkteste.entity.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecosRepository extends JpaRepository<Enderecos, UUID> {
}