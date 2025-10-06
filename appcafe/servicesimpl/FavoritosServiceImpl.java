package com.upc.appcafe.servicesimpl;
import com.upc.appcafe.dtos.CafeteriaDTO;
import com.upc.appcafe.entities.Cafeteria;
import com.upc.appcafe.entities.Consumidor;
import com.upc.appcafe.entities.Megustacafeteria;
import com.upc.appcafe.repositories.CafeteriaRepository;
import com.upc.appcafe.repositories.ConsumidorRepository;
import com.upc.appcafe.repositories.MegustaCafeteriaRepository;
import com.upc.appcafe.services.FavoritosService;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
@Service
public class FavoritosServiceImpl implements FavoritosService {
    private final MegustaCafeteriaRepository likeRepo;
    private final CafeteriaRepository cafeteriaRepo;
    private final ConsumidorRepository consumidorRepo;
    private final ModelMapper mm;
    private final ApplicationEventPublisher events;

    public FavoritosServiceImpl(MegustaCafeteriaRepository likeRepo,
                                CafeteriaRepository cafeteriaRepo,
                                ConsumidorRepository consumidorRepo,
                                ModelMapper mm,
                                ApplicationEventPublisher events) {
        this.likeRepo = likeRepo;
        this.cafeteriaRepo = cafeteriaRepo;
        this.consumidorRepo = consumidorRepo;
        this.mm = mm;
        this.events = events;
    }

    @Override
    public void marcarFavorito(Integer cafeteriaid, Integer consumidorUsuarioId) {
        Cafeteria caf = cafeteriaRepo.findById(cafeteriaid)
                .orElseThrow(() -> new IllegalArgumentException("Cafetería no existe"));
        Consumidor cons = (Consumidor) consumidorRepo.findByUsuarioid_Id(consumidorUsuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Consumidor no existe"));

        if (likeRepo.existsByCafeteriaid_IdAndConsumidorid_Usuarioid_Id(cafeteriaid, consumidorUsuarioId)) {
            return;
        }

        Megustacafeteria nuevo = new Megustacafeteria();
        nuevo.setCafeteriaid(caf);
        nuevo.setConsumidorid(cons);
        try {
            nuevo.setFecharegistro(OffsetDateTime.now());
        } catch (Exception ignored) {}

        likeRepo.save(nuevo);
        events.publishEvent(new FavoritoCreadoEvent(this, cafeteriaid, consumidorUsuarioId));
    }

    @Override
    public void quitarFavorito(Integer cafeteriaid, Integer consumidorUsuarioId) {
        if (!likeRepo.existsByCafeteriaid_IdAndConsumidorid_Usuarioid_Id(cafeteriaid, consumidorUsuarioId)) {
            return; // idempotente
        }
        likeRepo.deleteByCafeteriaid_IdAndConsumidorid_Usuarioid_Id(cafeteriaid, consumidorUsuarioId);
    }

    @Override
    public List<CafeteriaDTO> listarFavoritos(Integer consumidorUsuarioId) {
        return likeRepo.findByConsumidorid_Usuarioid_Id(consumidorUsuarioId).stream()
                .map(Megustacafeteria::getCafeteriaid)
                .distinct()
                .map(c -> mm.map(c, CafeteriaDTO.class))
                .toList();
    }

    public record FavoritoCreadoEvent(Object source, Integer cafeteriaid, Integer consumidorUsuarioId) {}
}

