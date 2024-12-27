package com.agustin.SistemaEmpleados.repositorio;

import com.agustin.SistemaEmpleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
