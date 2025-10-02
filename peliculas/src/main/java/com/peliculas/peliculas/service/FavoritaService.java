package com.peliculas.peliculas.service;

import com.peliculas.peliculas.entity.Favorita;
import com.peliculas.peliculas.repository.FavoritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritaService {

    @Autowired
    private FavoritaRepository favoritaRepository;

    public Favorita guardar(Favorita favorita) {
        return favoritaRepository.save(favorita);
    }

    public List<Favorita> listarTodas() {
        return favoritaRepository.findAll();
    }

    public void eliminar(Long id) {
        favoritaRepository.deleteById(id);
    }

}
