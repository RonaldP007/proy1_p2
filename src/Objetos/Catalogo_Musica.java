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
    //This constructor receives the information of a disk
    public Catalogo_Musica(String nombre, String autor, String categoria, int precio, int cantidad_disponible, String direccion_cancion) {
        super(nombre, autor, categoria, precio, cantidad_disponible);
        this.direccion_cancion = direccion_cancion;
    }
    //This method return the direction of the disk
    public String getDireccion_Cancion() {
        return direccion_cancion;
    }
    //This method set direction of the disk
    public void setDireccion_Cancion(String direccion_cancion) {
        this.direccion_cancion = direccion_cancion;
    }
}
