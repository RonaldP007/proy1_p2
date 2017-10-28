/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.CRUB_Archivos;
import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class CRUB_Discos {

    public void Crear_Disco_Musica(String nombre, String autor, String categoria, int precio, int cantidad, String direccion) {
        Catalogo_Musica disco_musica = new Catalogo_Musica(nombre, autor, categoria, precio, cantidad, direccion);
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        crub_archi.Guardar_Info_Musica(disco_musica);
        
    }

    public void Crear_Disco_Pelicula(String nombre, String autor, String categoria, int precio, int cantidad, String direccionURL) {
        Catalogo_Peliculas disco_pelicula = new Catalogo_Peliculas(nombre,autor,categoria,precio,cantidad,direccionURL);
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        crub_archi.Guardar_Info_Pelicula(disco_pelicula);
    }

    public ArrayList<Catalogo_Peliculas> Buscar_Informacion_de_peliculas() {
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        ArrayList<Catalogo_Peliculas> discos_peliculas = crub_archi.Buscar_Informacion_Peliculas_Archi();
        return discos_peliculas;
    }
}
