/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Archivos;

import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import Objetos.Dato_Compras;
import Objetos.Datos_Catalogo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class CRUB_Archivos {
    // Save the music disc information in the file
    public void Guardar_Info_Musica(Catalogo_Musica disco_musica) {
        String info_disco_music = disco_musica.getNombre() + ";" + disco_musica.getAutor() + ";" + disco_musica.getCategoria() + ";"
                + disco_musica.getPrecio() + ";" + disco_musica.getCantidad_Disponible() + ";" + disco_musica.getDireccion_Cancion();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/cat_musica.txt", true))) {
            bw.write(info_disco_music + System.lineSeparator());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    //Save the movie disc information in the file
    public void Guardar_Info_Pelicula(Catalogo_Peliculas disco_pelicula) {
        String info_disco_pelicula = disco_pelicula.getNombre() + ";" + disco_pelicula.getAutor() + ";" + disco_pelicula.getCategoria() + ";"
                + disco_pelicula.getPrecio() + ";" + disco_pelicula.getCantidad_Disponible() + ";"
                + disco_pelicula.getdireccionURL();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/cat_peliculas.txt", true))) {
            bw.write(info_disco_pelicula);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    // Search the information of the movies in the file
    public ArrayList<Catalogo_Peliculas> Buscar_Informacion_Peliculas_Archi() {
        ArrayList<Catalogo_Peliculas> lista_de_discos = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_peliculas.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] disco = line.split(";");
                Catalogo_Peliculas disco_pelicula;
                disco_pelicula = new Catalogo_Peliculas(disco[0], disco[1], disco[2],
                        Integer.parseInt(disco[3]), Integer.parseInt(disco[4]), disco[5]);
                lista_de_discos.add(disco_pelicula);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista_de_discos;
    }
    //Search the information of the music disc  in the file
    public ArrayList<Catalogo_Musica> Buscar_Informacion_Musica_Archi() {
        ArrayList<Catalogo_Musica> lista_de_discos = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_musica.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] disco = line.split(";");
                Catalogo_Musica disco_musica;
                disco_musica = new Catalogo_Musica(disco[0], disco[1], disco[2],
                        Integer.parseInt(disco[3]), Integer.parseInt(disco[4]), disco[5]);
                lista_de_discos.add(disco_musica);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista_de_discos;
    }
    //  Check if a disk already contains a preorder
    public boolean Verificar_Disco_Repetido_PreOrden(String disco_musica, String dir_archivo) {
        String line;
        boolean encontro_repetido = false;
        try (BufferedReader br = new BufferedReader(new FileReader(dir_archivo))) {
            while ((line = br.readLine()) != null) {
                String[] musica = line.split(";");
                if (disco_musica.equals(musica[0])) {
                    encontro_repetido = true;
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return encontro_repetido;
    }
    // Update the music disc information in the file
    public boolean Actualizar_Disco_Musica(ArrayList<Catalogo_Musica> lista_discos, String dir_archivo) {
        boolean se_borro = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dir_archivo))) {
            for (Catalogo_Musica disco_musica : lista_discos) {
                String info_disco_music = disco_musica.getNombre() + ";" + disco_musica.getAutor() + ";" + disco_musica.getCategoria() + ";"
                        + disco_musica.getPrecio() + ";" + disco_musica.getCantidad_Disponible() + ";" + disco_musica.getDireccion_Cancion();
                bw.write(info_disco_music + System.lineSeparator());
            }
            se_borro = true;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return se_borro;
    }
    //Update the movie disc information in the file
    public boolean Actualizar_Disco_Pelicula(ArrayList<Catalogo_Peliculas> lista_discos, String dir_archivo) {
        boolean se_borro = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dir_archivo))) {
            for (Catalogo_Peliculas disco_pelicula : lista_discos) {
                String info_disco_pelicula = disco_pelicula.getNombre() + ";" + disco_pelicula.getAutor() + ";" + disco_pelicula.getCategoria() + ";"
                        + disco_pelicula.getPrecio() + ";" + disco_pelicula.getCantidad_Disponible() + ";" + disco_pelicula.getdireccionURL();
                bw.write(info_disco_pelicula + System.lineSeparator());
            }
            se_borro = true;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return se_borro;
    }
    // Send the information of the disk to be updated
    public ArrayList<String> Envio_Disco_Actualizar(String nombre_Disco, String dir_archivo) {
        String line;
        ArrayList<String> Lista_datos = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(dir_archivo))) {
            while ((line = br.readLine()) != null) {
                String[] PreOrdenes = line.split(";");
                if (nombre_Disco.equals(PreOrdenes[1])) {
                    Lista_datos.add(PreOrdenes[3]);
                    Lista_datos.add(PreOrdenes[4]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos;
    }
    // Add purchase information to the file and perform the preorders if there are no discs
    public boolean Agregar_PreOrden_Y_Compra(ArrayList<Dato_Compras> lista_preorden, ArrayList<Dato_Compras> lista_comprados) {
        boolean registrados = false;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/Compra_Musica.txt", true))) {
            for (Dato_Compras disco_comprado : lista_comprados) {
                if (disco_comprado.getTipo_Articulo().equals("musica")) {
                    String info_disco_comprado = disco_comprado.getNombre() + ";" + disco_comprado.getCedula() + ";" + disco_comprado.getCorreo()
                            + ";" + disco_comprado.getNombre_Articulo() + ";" + disco_comprado.getPrecio() + ";" + disco_comprado.getCantidad_Comprado()
                            + ";" + disco_comprado.getTipo_Articulo() + ";" + disco_comprado.getFecha();
                    bw.write(info_disco_comprado + System.lineSeparator());
                } else {
                    try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/Archivos/Compra_Peliculas.txt", true))) {
                        String info_disco_comprado = disco_comprado.getNombre() + ";" + disco_comprado.getCedula() + ";" + disco_comprado.getCorreo()
                                + ";" + disco_comprado.getNombre_Articulo() + ";" + disco_comprado.getPrecio() + ";" + disco_comprado.getCantidad_Comprado()
                                + ";" + disco_comprado.getTipo_Articulo() + ";" + disco_comprado.getFecha();
                        bw1.write(info_disco_comprado + System.lineSeparator());
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }

            }
            registrados = true;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/Pre_Ordenes_Musica.txt", true))) {
            for (Dato_Compras disco_preordenado : lista_preorden) {
                if (disco_preordenado.getTipo_Articulo().equals("musica")) {
                    String info_disco_preordenado = disco_preordenado.getNombre()
                            + ";" + disco_preordenado.getNombre_Articulo()
                            + ";" + disco_preordenado.getTipo_Articulo()
                            + ";" + disco_preordenado.getCorreo() + ";" + disco_preordenado.getCantidad_Comprado();
                    bw.write(info_disco_preordenado + System.lineSeparator());
                } else {
                    try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/Archivos/Pre_Ordenes_Peliculas.txt", true))) {
                        String info_disco_preordenado = disco_preordenado.getNombre()
                                + ";" + disco_preordenado.getNombre_Articulo()
                                + ";" + disco_preordenado.getTipo_Articulo()
                                + ";" + disco_preordenado.getCorreo() + ";" + disco_preordenado.getCantidad_Comprado();
                        bw1.write(info_disco_preordenado + System.lineSeparator());
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

                }

            }
            registrados = true;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return registrados;
    }
     public void eliminar_preorden(String nombre_dis, String dir_archivo){
        try {
            String temp;
            try (BufferedReader bf = new BufferedReader(new FileReader(dir_archivo))) {
                String bfRead;
                while ((bfRead = bf.readLine()) != null) {
                    temp = bfRead;
                    String lista = temp;
                    String[] lista1 = lista.split(";");
                    if (lista1[1].equals(nombre_dis)) {
                        try {
                            File archivo = new File(dir_archivo);
                            FileWriter escribir = new FileWriter(archivo, true);
                            String temp1;
                            try (BufferedReader bf1 = new BufferedReader(new FileReader(dir_archivo))) {

                                String bf1Read;

                                while ((bf1Read = bf1.readLine()) != null) {
                                    temp1 = bf1Read;

                                    if (temp1.equals(lista)) {
                                        BufferedWriter br = new BufferedWriter(new FileWriter(dir_archivo));

                                        continue;
                                    }
                                    escribir.write(temp1 + "\r\n");
                                }
                                escribir.close();

                            }
                        } catch (IOException e) {
                            System.err.println("No se encontro el archivo");
                        }

                        break;

                    } 
                }
            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo2");
        }
    }
    
}
