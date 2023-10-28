package com.C14equipo20NoCountry.api.servicio;

import com.C14equipo20NoCountry.api.modelos.Producto;
import com.C14equipo20NoCountry.api.modelos.ProductoDTO;
import com.C14equipo20NoCountry.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> todosLosProductos(){
        return productoRepository.findAll();
    }

    public Producto buscarProducto(Long id){
        Optional<Producto> produc = productoRepository.findById(id);
        if (produc.isPresent()) return produc.get();
        else return null;
    }

    public void guardar(Producto producto){
        productoRepository.save(producto);
    }

    public void borrar(Long id){
        productoRepository.deleteById(id);
    }

    public List<ProductoDTO> encontrarPorNombre(String nombre){
        List<Producto> prod = productoRepository.findByNombre(nombre);
        if (prod.isEmpty()) return null;
        else return prod.stream().map(ProductoDTO::new).toList();
    }
}