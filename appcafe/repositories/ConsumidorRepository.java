package com.upc.appcafe.repositories;

import com.upc.appcafe.entities.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsumidorRepository extends JpaRepository<Consumidor,Integer> {
    Optional<Object> findByUsuarioid_Id(Integer consumidorUsuarioId);
}
