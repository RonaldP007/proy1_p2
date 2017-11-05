/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.Buscar_Info_Archivo;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ronald
 */
public class Codigo_Reportes {

    public ArrayList<String> cod_rep1(String genero) {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> lista_compra_genero = arc_lista.Info_Disc_Mus_Compras(genero);
        ArrayList<String> lista_discos_genero = arc_lista.Info_Disco_Mus_Rep1(genero);
        ArrayList<String> Lista_totales = new ArrayList();
        ArrayList<String> Lista_Mas_menos = new ArrayList();
        String[] mas_men = new String[4];

        for (int i = 0; i < lista_discos_genero.size(); i++) {
            int total = 0;
            for (int j = 0; j < lista_compra_genero.size(); j++) {
                if (lista_discos_genero.get(i).equals(lista_compra_genero.get(j))) {
                    total = total + Integer.parseInt(lista_compra_genero.get(j + 1));
                }
            }
            Lista_totales.add(lista_discos_genero.get(i));
            Lista_totales.add(String.valueOf(total));
        }
        int mayor = 0;
        int menor = 1000;
        for (int i = 0; i < Lista_totales.size(); i++) {
            if (i % 2 != 0) {
                if (Integer.parseInt(Lista_totales.get(i)) >= mayor) {
                    mayor = Integer.parseInt(Lista_totales.get(i));
                    mas_men[0] = (Lista_totales.get(i - 1));
                    mas_men[1] = (Lista_totales.get(i));
                }
                if (Integer.parseInt(Lista_totales.get(i)) <= menor) {
                    menor = Integer.parseInt(Lista_totales.get(i));
                    mas_men[2] = (Lista_totales.get(i - 1));
                    mas_men[3] = (Lista_totales.get(i));
                }
            }
        }
        Lista_Mas_menos.addAll(Arrays.asList(mas_men));
        return Lista_Mas_menos;
    }

    public ArrayList<String> cod_rep4(String genero) {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> lista_compra_genero = arc_lista.Info_Disc_Pel_Compras(genero);
        ArrayList<String> lista_pel_genero = arc_lista.Info_Disco_Pel_Rep4(genero);
        ArrayList<String> Lista_totales = new ArrayList();
        ArrayList<String> Lista_Mas_menos = new ArrayList();
        String[] mas_men = new String[4];

        for (int i = 0; i < lista_pel_genero.size(); i++) {
            int total = 0;
            for (int j = 0; j < lista_compra_genero.size(); j++) {
                if (lista_pel_genero.get(i).equals(lista_compra_genero.get(j))) {
                    total = total + Integer.parseInt(lista_compra_genero.get(j + 1));
                }
            }
            Lista_totales.add(lista_pel_genero.get(i));
            Lista_totales.add(String.valueOf(total));
        }
        int mayor = 0;
        int menor = 1000;
        for (int i = 0; i < Lista_totales.size(); i++) {
            if (i % 2 != 0) {
                if (Integer.parseInt(Lista_totales.get(i)) >= mayor) {
                    mayor = Integer.parseInt(Lista_totales.get(i));
                    mas_men[0] = (Lista_totales.get(i - 1));
                    mas_men[1] = (Lista_totales.get(i));
                }
                if (Integer.parseInt(Lista_totales.get(i)) <= menor) {
                    menor = Integer.parseInt(Lista_totales.get(i));
                    mas_men[2] = (Lista_totales.get(i - 1));
                    mas_men[3] = (Lista_totales.get(i));
                }
            }
        }
        Lista_Mas_menos.addAll(Arrays.asList(mas_men));
        return Lista_Mas_menos;
    }

    /*public ArrayList<String> cod_rep2(String nombre) {
        ArrayList<String> Lista_cumbia = new ArrayList();
        ArrayList<String> Lista_salsa = new ArrayList();
        ArrayList<String> Lista_bachata = new ArrayList();
        ArrayList<String> Lista_ranchera = new ArrayList();
        ArrayList<String> Lista_electronica = new ArrayList();
        Buscar_Info_Archivo inf =new Buscar_Info_Archivo();
        ArrayList<String> Lista_can_total = inf.Info_Disco_Mus_Can_Gen();
        ArrayList<String> Lista_can_usu = inf.Infousu_Disco_Mus_Rep2(nombre);
        String generos[]={"Cumbia","Salsa","Bachata","Electronica","Rancheras"};
       // for(int i = 0; i< generos.length;i++){
            for(int j = 0; j<Lista_can_total.size(); j++){
                if (j % 2 != 0) {
                    if(generos[0].equals(Lista_can_total.get(j))){
                        Lista_cumbia.add(Lista_can_total.get(j-1));
                    }
                    else{
                        
                    }
                    if(generos[1].equals(Lista_can_total.get(j))){
                        Lista_salsa.add(Lista_can_total.get(j-1));
                    }
                    else{
                        
                    }
                    if(generos[2].equals(Lista_can_total.get(j))){
                        Lista_bachata.add(Lista_can_total.get(j-1));
                    }
                    if(generos[3].equals(Lista_can_total.get(j))){
                        Lista_electronica.add(Lista_can_total.get(j-1));
                    }
                    if(generos[4].equals(Lista_can_total.get(j))){
                        Lista_ranchera.add(Lista_can_total.get(j-1));
                    }
                }
            }
            
       // }
        
        return Lista_ranchera; 
    }
    public ArrayList<String> cod_rep2(String nombre) {
         Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
   
        ArrayList<String> Lista_cumbia = arc_lista.Info_Disco_Mus_Rep1("Cumbia");
        ArrayList<String> Lista_salsa = arc_lista.Info_Disco_Mus_Rep1("Salsa");
        ArrayList<String> Lista_bachata = arc_lista.Info_Disco_Mus_Rep1("Bachata");
        ArrayList<String> Lista_ranchera = arc_lista.Info_Disco_Mus_Rep1("Rancheras");
        ArrayList<String> Lista_electronica = arc_lista.Info_Disco_Mus_Rep1("Electronica");
        ArrayList<String> Lista_cumbia_usu = new ArrayList();
        ArrayList<String> Lista_salsa_usu =  new ArrayList();       
        ArrayList<String> Lista_bachata_usu  = new ArrayList();      
        ArrayList<String> Lista_ranchera_usu = new ArrayList();       
        ArrayList<String> Lista_electronica_usu = new ArrayList();       
        String lista_cumbia_usu_max [] = new String[2];
        String lista_salsa_usu_max [] = new String[2];
        String lista_bachata_usu_max [] = new String[2];
        String lista_ranchera_usu_max [] = new String[2];
        String lista_electronica_usu_max [] = new String[2];
        
        
        return null;
    }*/
    public ArrayList<String> cod_rep2(String usuario) {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> Lista_cumbia = arc_lista.Info_Disco_Mus_Rep1("Cumbia");
        ArrayList<String> Lista_salsa = arc_lista.Info_Disco_Mus_Rep1("Salsa");
        ArrayList<String> Lista_bachata = arc_lista.Info_Disco_Mus_Rep1("Bachata");
        ArrayList<String> Lista_ranchera = arc_lista.Info_Disco_Mus_Rep1("Rancheras");
        ArrayList<String> Lista_electronica = arc_lista.Info_Disco_Mus_Rep1("Electronica");

        Buscar_Info_Archivo inf = new Buscar_Info_Archivo();
        ArrayList<String> Lista_com_usu = inf.Infousu_Disco_Mus_Rep2(usuario);
        ArrayList<String> Lista_com_usu_x_gen = new ArrayList();

        String generos[] = {"Cumbia", "Salsa", "Bachata", "Rancheras", "Electronica"};

        ArrayList<String> Lista_totales = new ArrayList();
        ArrayList<String> Lista_Mas = new ArrayList();
        String[] mas_men = new String[4];

        for (int i = 0; i < Lista_com_usu.size(); i++) {
           for (int j = 0; j < Lista_salsa.size(); j++) {
                if (i % 2 == 0) {
                    if (Lista_com_usu.get(i).equals(Lista_cumbia.get(j))) {
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i));
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i + 1));
                        Lista_com_usu_x_gen.add("Cumbia");
                    }
                }
            }
            for (int j = 0; j < Lista_salsa.size(); j++) {
                if (i % 2 == 0) {
                    if (Lista_com_usu.get(i).equals(Lista_salsa.get(j))) {
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i));
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i + 1));
                        Lista_com_usu_x_gen.add("Salsa");
                    }
                }
            }
            for (int j = 0; j < Lista_bachata.size(); j++) {
                if (i % 2 == 0) {
                    if (Lista_com_usu.get(i).equals(Lista_bachata.get(j))) {
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i));
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i + 1));
                        Lista_com_usu_x_gen.add("Bachata");
                    }
                }
            }
            for (int j = 0; j < Lista_ranchera.size(); j++) {
                if (i % 2 == 0) {
                    if (Lista_com_usu.get(i).equals(Lista_ranchera.get(j))) {
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i));
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i + 1));
                        Lista_com_usu_x_gen.add("Rancheras");
                    }
                }
            }
            for (int j = 0; j < Lista_electronica.size(); j++) {
                if (i % 2 == 0) {
                    if (Lista_com_usu.get(i).equals(Lista_electronica.get(j))) {
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i));
                        Lista_com_usu_x_gen.add(Lista_com_usu.get(i + 1));
                        Lista_com_usu_x_gen.add("Electronica");
                    }
                }
            }
        }
        //for (int i = 0; i <; i++) {
        //  for (int j = 0; j < Lista_com_usu_x_gen.size(); j += 3) {

        //}
        //}
        /* total = total + Integer.parseInt(lista_compra_genero.get(j + 1));
                }
            }
            Lista_totales.add(lista_discos_genero.get(i));
            Lista_totales.add(String.valueOf(total));
        }
        int mayor = 0;
        int menor = 1000;
        for (int i = 0; i < Lista_totales.size(); i++) {
            if (i % 2 != 0) {
                if (Integer.parseInt(Lista_totales.get(i)) >= mayor) {
                    mayor = Integer.parseInt(Lista_totales.get(i));
                    mas_men[0] = (Lista_totales.get(i - 1));
                    mas_men[1] = (Lista_totales.get(i));
                }
                if (Integer.parseInt(Lista_totales.get(i)) <= menor) {
                    menor = Integer.parseInt(Lista_totales.get(i));
                    mas_men[2] = (Lista_totales.get(i - 1));
                    mas_men[3] = (Lista_totales.get(i));
                }
            }
        }
        Lista_Mas_menos.addAll(Arrays.asList(mas_men));*/
        // return Lista_com_usu;
        return Lista_com_usu_x_gen;
    }
    public ArrayList<String> cod_rep2_part2(String usuario) {
        ArrayList<String> Lista_usu_comp = cod_rep1(usuario);
        ArrayList<String> Lista_usu_comp_tot = new ArrayList();
        String comparar;
        int total;
        for(int i =0;i < Lista_usu_comp.size();i++){
            if(i % 2 != 0){
                comparar =Lista_usu_comp.get(i);
            }
            for(int j = 0; j < Lista_usu_comp.size();j+=2){
                
            }
        }
        
        
        return null;
    }

}
