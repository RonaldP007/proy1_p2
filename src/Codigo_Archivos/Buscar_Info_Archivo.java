/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Archivos;

import Objetos.Catalogo_Musica;
import Objetos.Dato_Compras;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class Buscar_Info_Archivo {
    //This method check if the account is equals
    public boolean Info_repetida(String nombre_archivo, String nombre_dis_peli) {
        boolean disponible = true;
        String line;
        String[] info;
        try (BufferedReader br = new BufferedReader(new FileReader(nombre_archivo))) {
            while ((line = br.readLine()) != null) {
                info = line.split(";");
                if (info[0].equals(nombre_dis_peli)) {
                    disponible = false;
                }
            }
        } catch (IOException ex) {
            System.out.println("Se despicho" + ex);
        }
        return disponible;
    }
    //This method return all music disks of a genre
    public ArrayList<String> Info_Disco_Mus_Rep1(String genero) {
        String line;
        ArrayList<String> Lista_datos_nombre_genero = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_musica.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco = line.split(";");
                if (info_disco[2].equals(genero)) {
                    Lista_datos_nombre_genero.add(info_disco[0]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_nombre_genero;
    }
    //This method return all movie disks of a genre
    public ArrayList<String> Info_Disco_Pel_Rep1(String genero) {
        String line;
        ArrayList<String> Lista_datos_nombre_genero = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_peliculas.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco = line.split(";");
                if (info_disco[2].equals(genero)) {
                    Lista_datos_nombre_genero.add(info_disco[0]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_nombre_genero;
    }
    //This method return the information for genre to the second report from discs music
    public ArrayList<String> Info_Disc_Mus_Compras(String genero) {
        ArrayList<String> Lista_nombre = Info_Disco_Mus_Rep1(genero);
        ArrayList<String> Lista_datos_compras = new ArrayList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Compra_Musica.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco_compra = line.split(";");
                for (int s = 0; s < Lista_nombre.size(); s++) {
                    if (Lista_nombre.get(s).equals(info_disco_compra[3])) {
                        Lista_datos_compras.add(info_disco_compra[3]);
                        Lista_datos_compras.add(info_disco_compra[5]);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_compras;
    }
    //This method return the information of music disk for genre and user to the second report
    public ArrayList<String> Info_Disc_Mus_Compras_usu(String genero, String usuario) {
        ArrayList<String> Lista_nombre = Info_Disco_Mus_Rep1(genero);
        ArrayList<String> Lista_datos_compras = new ArrayList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Compra_Musica.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco_compra = line.split(";");
                for (int s = 0; s < Lista_nombre.size(); s++) {
                    if (Lista_nombre.get(s).equals(info_disco_compra[3]) & info_disco_compra[0].equals(usuario)) {
                        Lista_datos_compras.add(info_disco_compra[3]);
                        Lista_datos_compras.add(info_disco_compra[5]);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_compras;
    }
    //This method return the information of movie disk for genre and user to the second report
    public ArrayList<String> Info_Disc_Pel_Compras_usu(String genero, String usuario) {
        ArrayList<String> Lista_nombre = Info_Disco_Pel_Rep1(genero);
        ArrayList<String> Lista_datos_compras = new ArrayList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Compra_Peliculas.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco_compra = line.split(";");
                for (int s = 0; s < Lista_nombre.size(); s++) {
                    if (Lista_nombre.get(s).equals(info_disco_compra[3]) & info_disco_compra[0].equals(usuario)) {
                        Lista_datos_compras.add(info_disco_compra[3]);
                        Lista_datos_compras.add(info_disco_compra[5]);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_compras;
    }
    //This method return the information the report four from discs movie
    public ArrayList<String> Info_Disco_Pel_Rep4(String genero) {
        String line;
        ArrayList<String> Lista_datos_nombre_genero = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_peliculas.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco = line.split(";");
                if (info_disco[2].equals(genero)) {
                    Lista_datos_nombre_genero.add(info_disco[0]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_nombre_genero;
    }
    //This method return the information for genre to the second report from discs movie
    public ArrayList<String> Info_Disc_Pel_Compras(String genero) {
        ArrayList<String> Lista_nombre = Info_Disco_Pel_Rep4(genero);
        ArrayList<String> Lista_datos_compras = new ArrayList();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Compra_Peliculas.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco_compra = line.split(";");
                for (int s = 0; s < Lista_nombre.size(); s++) {
                    if (Lista_nombre.get(s).equals(info_disco_compra[3])) {
                        Lista_datos_compras.add(info_disco_compra[3]);
                        Lista_datos_compras.add(info_disco_compra[5]);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_compras;
    }
    //This methods return a user
    public ArrayList<String> Usuarios() {
        ArrayList<String> Lista_Usuarios = new ArrayList();
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("src/Archivos/cuentas.txt"));
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[4].equals("0")) {
                    Lista_Usuarios.add(lista1[0]);
                }
            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
        return Lista_Usuarios;
    }
        //This method return the purchased discs
    public ArrayList<Dato_Compras> info_rep3(String archivo){
        String linea;
        ArrayList<Dato_Compras> lista = new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(archivo))){
            while((linea = br.readLine()) != null){
                String[] info_disco = linea.split(";");
                Dato_Compras dato;
                dato = new Dato_Compras(info_disco[0], Integer.parseInt(info_disco[1]),
                        info_disco[2], info_disco[3], Integer.parseInt(info_disco[4]), 
                        Integer.parseInt(info_disco[5]), info_disco[6], info_disco[7]);
                lista.add(dato);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    return lista;
    }
    
}
