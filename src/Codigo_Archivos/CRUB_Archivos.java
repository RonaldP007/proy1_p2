/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Archivos;

import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Enrique
 */
public class CRUB_Archivos {

    public void Guardar_Info_Musica(Catalogo_Musica disco_musica) {
        String info_disco_music = disco_musica.getNombre()+";"+disco_musica.getAutor()+";"+disco_musica.getCategoria()+";"
                +disco_musica.getCantidad_Disponible()+";"+disco_musica.getDireccion_Cancion();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/cat_musica.txt", true))){
            bw.write(info_disco_music+System.lineSeparator());
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void Guardar_Info_Pelicula(Catalogo_Peliculas disco_pelicula) {
        String info_disco_pelicula = disco_pelicula.getNombre()+";"+disco_pelicula.getAutor()+";"+disco_pelicula.getCategoria()+";"
                +disco_pelicula.getPrecio()+";"+disco_pelicula.getCantidad_Disponible()+";"
                +disco_pelicula.getdireccionURL();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/cat_peliculas.txt", true))){
            bw.write(info_disco_pelicula);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
}
