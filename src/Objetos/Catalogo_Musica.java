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
public class Catalogo_Musica extends Datos_Catalogo {

    String direccion_cancion;

    public Catalogo_Musica(String nombre, String autor, String categoria, int precio, int cantidad_disponible, String direccion_cancion) {
        super(nombre, autor, categoria, precio, cantidad_disponible);
        this.direccion_cancion = direccion_cancion;
    }

    public String getDireccion_Cancion() {
        return direccion_cancion;
    }

    public void setDireccion_Cancion(String direccion_cancion) {
        this.direccion_cancion = direccion_cancion;
    }
}
