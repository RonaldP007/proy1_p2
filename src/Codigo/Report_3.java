/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Objetos.Dato_Compras;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class Report_3 {
    
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
    public ArrayList<Dato_Compras> rep3(String fecha_1,String fecha_2){
        String[] fecha_min = fecha_1.split("/");
        String[] fecha_max = fecha_2.split("/");
        LocalDate fecha_minima = LocalDate.of(Integer.parseInt(fecha_min[2]), Integer.parseInt(fecha_min[1]), Integer.parseInt(fecha_min[0]));
        LocalDate fecha_maxima = LocalDate.of(Integer.parseInt(fecha_max[2]), Integer.parseInt(fecha_max[1]), Integer.parseInt(fecha_max[0]));
        ArrayList<Dato_Compras> lista_discos = info_rep3("src/Archivo/Compra_Musica.txt");
        ArrayList<Dato_Compras> lista_por_fecha = new ArrayList<>();
        for(Dato_Compras dato : lista_discos){
            String[] fecha = dato.getFecha().split("/");
            LocalDate fecha_disco = LocalDate.of(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]));
            if(fecha_minima.isBefore(fecha_disco) && fecha_maxima.isAfter(fecha_disco)){
                for(Dato_Compras verificando_dato : lista_por_fecha){
                    if(verificando_dato.getNombre_Articulo().equals(dato.getNombre_Articulo())){
                        verificando_dato.setCantidad_Comprado(verificando_dato.getCantidad_Comprado()+dato.getCantidad_Comprado());
                    }else{
                        lista_por_fecha.add(dato);
                    }
                }
            }
        }
        return lista_por_fecha;
    }
}
