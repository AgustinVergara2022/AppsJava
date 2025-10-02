package com.peliculas.peliculas.repository;

import com.peliculas.peliculas.entity.Favorita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritaRepository extends JpaRepository<Favorita, Long> {

}
