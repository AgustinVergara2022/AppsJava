package com.peliculas.peliculas.controller;

import com.peliculas.peliculas.dto.PeliculaDto;
import com.peliculas.peliculas.entity.Favorita;
import com.peliculas.peliculas.service.FavoritaService;
import com.peliculas.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritas")
public class FavoritaController {

    @Autowired
    private FavoritaService favoritaService;

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<Favorita> guardar(@RequestBody Favorita favorita) {
        return ResponseEntity.ok(favoritaService.guardar(favorita));
    }

    @GetMapping
    public ResponseEntity<List<Favorita>> listar() {
        return ResponseEntity.ok(favoritaService.listarTodas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        favoritaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/agregar-por-titulo")
    public ResponseEntity<Favorita> guardarPorTitulo(@RequestParam String titulo) {
        PeliculaDto dto = peliculaService.buscarPorTitulo(titulo).block();

        if (dto != null && dto.getTitle() != null) {
            Favorita favorita = new Favorita();
            favorita.setTitulo(dto.getTitle());
            favorita.setDirector(dto.getDirector());
            favorita.setAño(dto.getYear());
            favorita.setPoster(dto.getPoster());

            Favorita guardada = favoritaService.guardar(favorita);
            return ResponseEntity.ok(guardada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
