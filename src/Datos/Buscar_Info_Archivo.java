/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    
    public boolean Info_repetida(String nombre_archivo,String nombre_dis_peli){
        boolean disponible = true;
        String line;
        String[] info;
        try(BufferedReader br = new BufferedReader(new FileReader(nombre_archivo))){
            while((line = br.readLine()) != null){
                info = line.split(";");
                if(info[0].equals(nombre_dis_peli)){
                    disponible = false;
                }
            }
        }catch(IOException ex){
            System.out.println("Se despicho"+ ex);
        }
        return disponible;
    }
}
