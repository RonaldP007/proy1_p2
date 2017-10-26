/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author Enrique
 */
public class Datos_Catalogo {

    String nombre;
    String autor;
    String categoria;
    int precio;
    int cantidad_disponible;

    public Datos_Catalogo(String nombre, String autor, String categoria, int precio, int cantidad_disponible) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad_Disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_Disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
}
