/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class Catalogo_Disco extends Datos_Catalogo {

    ArrayList<String> lista_canciones;

    public Catalogo_Disco(String nombre, String autor, String categoria, int precio, int cantidad_disponible, ArrayList<String> lista_canciones) {
        super(nombre, autor, categoria, precio, cantidad_disponible);
        this.lista_canciones = lista_canciones;
    }

    public ArrayList getLista_Canciones() {
        return lista_canciones;
    }

    public void setLista_Canciones(ArrayList lista_canciones) {
        this.lista_canciones = lista_canciones;
    }
}
