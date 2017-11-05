/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import java.util.ArrayList;
/**
 *
 * @author Enrique
 */
public class Metodos_Para_Ventanas {

    public int Buscar_Objeto_Musica(ArrayList<Catalogo_Musica> lista, String nombre) {
        int posicion = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public int Buscar_Objeto_Pelicula(ArrayList<Catalogo_Peliculas> lista, String nombre) {
        int posicion = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    
}
