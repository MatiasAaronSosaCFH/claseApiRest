package com.C14equipo20NoCountry.api.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductoRECIBIDO (@NotBlank Long id,
                                @NotBlank @Size(min = 5, max = 15) String nombre,
                                @NotBlank Integer precio){

    public ProductoRECIBIDO(Producto producto){
        this(producto.getId(), producto.getNombre(), producto.getPrecio());
    }
}
