package com.wktecnologyteste.wkteste.repository;

import com.wktecnologyteste.wkteste.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
}