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
}

    