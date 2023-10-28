package com.C14equipo20NoCountry.api.controller;


import com.C14equipo20NoCountry.api.modelos.Producto;
import com.C14equipo20NoCountry.api.modelos.ProductoDTO;
import com.C14equipo20NoCountry.api.modelos.ProductoRECIBIDO;
import com.C14equipo20NoCountry.api.servicio.ProductoServicio;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> productos(){
        return ResponseEntity.ok(productoServicio.todosLosProductos().stream().map(ProductoDTO::new).toList());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> guardarProducto(@RequestBody @Valid ProductoRECIBIDO prodi){

        if (prodi!=null){
            productoServicio.guardar(new Producto(prodi));
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDTO> borrarProducto(@PathVariable(value = "id") Long id){
        productoServicio.borrar(id);
        return ResponseEntity.ok().build();
    }


}
