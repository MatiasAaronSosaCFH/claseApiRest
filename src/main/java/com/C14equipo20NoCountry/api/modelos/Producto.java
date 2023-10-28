package com.C14equipo20NoCountry.api.modelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private Integer precio;

    public Producto(ProductoRECIBIDO prodi){
        this.id=prodi.id();
        this.nombre=prodi.nombre();
        this.precio=prodi.precio();
    }

    public Producto retornarProducto(ProductoRECIBIDO productoRECIBIDO){
        return new Producto(productoRECIBIDO);
    }
}
