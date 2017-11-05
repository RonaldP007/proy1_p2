/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Archivos;

import Objetos.Catalogo_Musica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class Buscar_Info_Archivo {

    //Saca la informacion del archivo ya sea de musica o peliculas
    /*public String Buscar_info(String nombre_archivo,String nombre_dis_peli){
        String informacion = "";
        String line;
        String[] info;
        try(BufferedReader br = new BufferedReader(new FileReader(nombre_archivo))){
            while((line = br.readLine()) != null){
                info = line.split(";");
                if(info[0].equals(nombre_dis_peli)){
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("Se despicho"+ ex);
        }
        return informacion;
    }*/
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

    public ArrayList<String> Infousu_Disco_Mus_Rep2(String nombre) {
        String line;
        ArrayList<String> Lista_datos_nombre_genero = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Compra_Musica.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco = line.split(";");
                if (info_disco[0].equals(nombre)) {
                    Lista_datos_nombre_genero.add(info_disco[3]);
                    Lista_datos_nombre_genero.add(info_disco[5]);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_nombre_genero;
    }

    public ArrayList<String> Info_Disco_Mus_Can_Gen() {
        String line;
        ArrayList<String> Lista_datos_nombre_genero = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/cat_musica.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] info_disco = line.split(";");
                Lista_datos_nombre_genero.add(info_disco[0]);
                Lista_datos_nombre_genero.add(info_disco[2]);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return Lista_datos_nombre_genero;
    }
}
