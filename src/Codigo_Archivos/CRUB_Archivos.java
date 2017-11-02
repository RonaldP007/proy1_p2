/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Archivos;

import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class CRUB_Archivos {

    public void Guardar_Info_Musica(Catalogo_Musica disco_musica) {
        String info_disco_music = disco_musica.getNombre()+";"+disco_musica.getAutor()+";"+disco_musica.getCategoria()+";"
                 +disco_musica.getPrecio()+";"+disco_musica.getCantidad_Disponible()+";"+disco_musica.getDireccion_Cancion();
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

    public ArrayList<Catalogo_Peliculas> Buscar_Informacion_Peliculas_Archi() {
        ArrayList<Catalogo_Peliculas> lista_de_discos = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_peliculas.txt"))){
            while((line = br.readLine())!= null){
                String[] disco = line.split(";");
                Catalogo_Peliculas disco_pelicula;
                disco_pelicula = new Catalogo_Peliculas(disco[0],disco[1],disco[2],
                        Integer.parseInt(disco[3]),Integer.parseInt(disco[4]),disco[5]);
                lista_de_discos.add(disco_pelicula);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista_de_discos;
    }
    public ArrayList<Catalogo_Musica> Buscar_Informacion_Musica_Archi() {
        ArrayList<Catalogo_Musica> lista_de_discos = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_musica.txt"))){
            while((line = br.readLine())!= null){
                String[] disco = line.split(";");
                Catalogo_Musica disco_musica;
                disco_musica = new Catalogo_Musica(disco[0],disco[1],disco[2],
                        Integer.parseInt(disco[3]),Integer.parseInt(disco[4]),disco[5]);
                lista_de_discos.add(disco_musica);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista_de_discos;
    }

    public boolean Verificar_Disco_Repetido_PreOrden(String disco_musica, String dir_archivo) {
        String line;
        boolean encontro_repetido = false;
        try(BufferedReader br = new BufferedReader(new FileReader(dir_archivo))){
            while((line = br.readLine())!= null){
                String[] musica = line.split(";");
                if(disco_musica.equals(musica[0])){
                    encontro_repetido = true;
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
        return encontro_repetido;
    }

    public boolean Actualizar_Disco_Musica(ArrayList<Catalogo_Musica> lista_discos, String dir_archivo) {
        boolean se_borro = false;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dir_archivo))){
            for (Catalogo_Musica disco_musica : lista_discos) {
                String info_disco_music = disco_musica.getNombre()+";"+disco_musica.getAutor()+";"+disco_musica.getCategoria()+";"
                +disco_musica.getPrecio()+";"+disco_musica.getCantidad_Disponible()+";"+disco_musica.getDireccion_Cancion();
                bw.write(info_disco_music+System.lineSeparator());
            }
            se_borro = true;
        }catch(IOException ex){
            System.out.println(ex);
        }
        return se_borro;
    }
    public boolean Actualizar_Disco_Pelicula(ArrayList<Catalogo_Peliculas> lista_discos, String dir_archivo) {
        boolean se_borro = false;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dir_archivo))){
            for (Catalogo_Peliculas disco_pelicula : lista_discos) {
                String info_disco_pelicula = disco_pelicula.getNombre()+";"+disco_pelicula.getAutor()+";"+disco_pelicula.getCategoria()+";"
                +disco_pelicula.getPrecio()+";"+disco_pelicula.getCantidad_Disponible()+";"+disco_pelicula.getdireccionURL();
                bw.write(info_disco_pelicula+System.lineSeparator());
            }
            se_borro = true;
        }catch(IOException ex){
            System.out.println(ex);
        }
        return se_borro;
    }  
    
    public ArrayList<String> Envio_Disco_Actualizar(String nombre_Disco, String dir_archivo) {
        String line;
        ArrayList<String> Lista_datos = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(dir_archivo))) {
            while((line = br.readLine())!= null){
                String[] PreOrdenes = line.split(";");
                if(nombre_Disco.equals(PreOrdenes[1])){
                    Lista_datos.add(PreOrdenes[3]);
                    Lista_datos.add(PreOrdenes[4]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos;
    }
}
