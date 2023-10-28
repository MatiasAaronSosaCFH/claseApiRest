package com.C14equipo20NoCountry.api.modelos;

public record ProductoDTO (String nombre){

    public ProductoDTO(Producto producto){
        this(producto.getNombre());
    }
}
