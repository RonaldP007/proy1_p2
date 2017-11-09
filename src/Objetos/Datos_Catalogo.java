/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

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
    //This contructor receives information of a disk and converte in object
    public Datos_Catalogo(String nombre, String autor, String categoria, int precio, int cantidad_disponible) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
    }
    //This method return name of disk
    public String getNombre() {
        return nombre;
    }
    //This method set a new name of disk
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //This method return Author of disk
    public String getAutor() {
        return autor;
    }
    //This method set new Author of disk
    public void setAutor(String autor) {
        this.autor = autor;
    }
    //This method return genre of disk
    public String getCategoria() {
        return categoria;
    }
    //This method set new genre of disk
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //This method return price of disk
    public int getPrecio() {
        return precio;
    }
    //This method new price of disk
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    //This method return amount of disk
    public int getCantidad_Disponible() {
        return cantidad_disponible;
    }
    //This method new amount of disk
    public void setCantidad_Disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
}
