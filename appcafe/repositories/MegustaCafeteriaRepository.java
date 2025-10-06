package com.upc.appcafe.repositories;

import com.upc.appcafe.entities.Megustacafeteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MegustaCafeteriaRepository extends JpaRepository<Megustacafeteria,Long> {
    List<Megustacafeteria> findByCafeteriaid_Id(Integer cafeteriaid);
    List<Megustacafeteria> findByConsumidorid_Usuarioid_Id(Integer consumidorUsuarioId);
    Optional<Megustacafeteria> findByCafeteriaid_IdAndConsumidorid_Usuarioid_Id(Integer cafeteriaid, Integer consumidorUsuarioId);


    boolean existsByCafeteriaid_IdAndConsumidorid_Usuarioid_Id(Integer cafeteriaid, Integer consumidorUsuarioId);
    void deleteByCafeteriaid_IdAndConsumidorid_Usuarioid_Id(Integer cafeteriaid, Integer consumidorUsuarioId);
}
