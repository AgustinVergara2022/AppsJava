package com.shady.tareas.repositorio;

import com.shady.tareas.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea, Integer> {

}
