package com.upc.appcafe.servicesimpl;

import com.upc.appcafe.dtos.MegustacafeteriaDTO;
import com.upc.appcafe.entities.Megustacafeteria;
import com.upc.appcafe.repositories.CafeteriaRepository;
import com.upc.appcafe.repositories.MegustaCafeteriaRepository;
import com.upc.appcafe.services.MegustacafeteriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MegustacafeteriaServiceImpl implements MegustacafeteriaService {

    @Autowired
    private MegustaCafeteriaRepository megustaCafeteriaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MegustacafeteriaDTO crearMegustacafeteria(MegustacafeteriaDTO megustacafeteriaDTO) {
        Megustacafeteria megustacafeteria = modelMapper.map(megustacafeteriaDTO, Megustacafeteria.class);
        megustacafeteria =megustaCafeteriaRepository.save(megustacafeteria);
        return modelMapper.map(megustacafeteria, MegustacafeteriaDTO.class);
    }

    @Override
    public MegustacafeteriaDTO actualizarMegustacafeteria(int megustacafeteriaId, MegustacafeteriaDTO megustacafeteriaDTO) {
        Megustacafeteria existe = megustaCafeteriaRepository.findById((long) megustacafeteriaId).orElseThrow(() -> new RuntimeException("Megustacafeteria no encontrado"));
        modelMapper.map(megustacafeteriaDTO, existe);
        existe =  megustaCafeteriaRepository.save(existe);
        return modelMapper.map(existe, MegustacafeteriaDTO.class);
    }

    @Override
    public void eliminarMegustacafeteria(int megustacafeteriaId) {
        megustaCafeteriaRepository.deleteById((long) megustacafeteriaId);
    }

    @Override
    public MegustacafeteriaDTO obtenerMegustacafeteria(int megustacafeteriaId) {
        return megustaCafeteriaRepository.findById((long) megustacafeteriaId)
                .map(m -> modelMapper.map(m, MegustacafeteriaDTO.class))
                .orElseThrow(() -> new RuntimeException("Megustacafeteria no encontrado"));
    }

    @Override
    public MegustacafeteriaDTO darLike(MegustacafeteriaDTO dto) {
        return null;
    }

    @Override
    public void quitarLike(int id) {

    }

    @Override
    public long contarLikes(int cafeteriaId) {
        return 0;
    }

    @Override
    public List<MegustacafeteriaDTO> listarLikesPorConsumidor(int consumidorId) {
        return List.of();
    }
}
