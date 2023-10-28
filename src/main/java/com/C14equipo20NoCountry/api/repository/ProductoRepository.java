package com.C14equipo20NoCountry.api.repository;

import com.C14equipo20NoCountry.api.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombre(String nombre);
}
