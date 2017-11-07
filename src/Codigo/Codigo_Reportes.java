/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.Buscar_Info_Archivo;
import Objetos.Dato_Compras;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;

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

    public ArrayList<String> cod_rep2(String genero, String usuario) {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> lista_compra_genero = arc_lista.Info_Disc_Mus_Compras_usu(genero, usuario);
        ArrayList<String> lista_discos_genero = arc_lista.Info_Disco_Mus_Rep1(genero);
        ArrayList<String> Lista_totales = new ArrayList();
        ArrayList<String> Lista_Mas = new ArrayList();
        String[] mas = new String[2];

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
        for (int i = 0; i < Lista_totales.size(); i++) {
            if (i % 2 != 0) {
                if (Integer.parseInt(Lista_totales.get(i)) >= mayor) {
                    mayor = Integer.parseInt(Lista_totales.get(i));
                    mas[0] = (Lista_totales.get(i - 1));
                    mas[1] = (Lista_totales.get(i));
                }
            }
        }
        Lista_Mas.addAll(Arrays.asList(mas));
        return Lista_Mas;
    }

    public ArrayList<String> rep2_combo_usu_mus() {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> lista_usuarios = arc_lista.Usuarios();
        return lista_usuarios;

    }

    public ArrayList<String> rep2_tod_max(JComboBox jComboBox1) {
        ArrayList<String> lista_info_usu_elect = cod_rep2("Electronica", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_ranch = cod_rep2("Rancheras", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_salsa = cod_rep2("Salsa", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_bach = cod_rep2("Bachata", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_cumb = cod_rep2("Cumbia", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_fusion = new ArrayList();

        for (int i = 0; i < lista_info_usu_elect.size(); i += 2) {
            if (lista_info_usu_elect.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_elect.get(i));
                lista_fusion.add(lista_info_usu_elect.get(i + 1));
                lista_fusion.add("Electronica");
            }
        }
        for (int i = 0; i < lista_info_usu_ranch.size(); i += 2) {
            if (lista_info_usu_ranch.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_ranch.get(i));
                lista_fusion.add(lista_info_usu_ranch.get(i + 1));
                lista_fusion.add("Rancheras");
            }
        }
        for (int i = 0; i < lista_info_usu_salsa.size(); i += 2) {
            if (lista_info_usu_salsa.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_salsa.get(i));
                lista_fusion.add(lista_info_usu_salsa.get(i + 1));
                lista_fusion.add("Salsa");
            }
        }
        for (int i = 0; i < lista_info_usu_bach.size(); i += 2) {
            if (lista_info_usu_bach.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_bach.get(i));
                lista_fusion.add(lista_info_usu_bach.get(i + 1));
                lista_fusion.add("Bachata");
            }
        }
        for (int i = 0; i < lista_info_usu_cumb.size(); i += 2) {
            if (lista_info_usu_cumb.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_cumb.get(i));
                lista_fusion.add(lista_info_usu_cumb.get(i + 1));
                lista_fusion.add("Cumbia");
            }
        }
        return lista_fusion;
    }

    public ArrayList<String> cod_rep2_pel(String genero, String usuario) {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> lista_compra_genero = arc_lista.Info_Disc_Pel_Compras_usu(genero, usuario);
        ArrayList<String> lista_discos_genero = arc_lista.Info_Disco_Pel_Rep1(genero);
        ArrayList<String> Lista_totales = new ArrayList();
        ArrayList<String> Lista_Mas = new ArrayList();
        String[] mas = new String[2];

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
        for (int i = 0; i < Lista_totales.size(); i++) {
            if (i % 2 != 0) {
                if (Integer.parseInt(Lista_totales.get(i)) >= mayor) {
                    mayor = Integer.parseInt(Lista_totales.get(i));
                    mas[0] = (Lista_totales.get(i - 1));
                    mas[1] = (Lista_totales.get(i));
                }
            }
        }
        Lista_Mas.addAll(Arrays.asList(mas));
        return Lista_Mas;
    }

    public ArrayList<String> rep2_combo_usu_pel() {
        Buscar_Info_Archivo arc_lista = new Buscar_Info_Archivo();
        ArrayList<String> lista_usuarios = arc_lista.Usuarios();
        return lista_usuarios;

    }

    public ArrayList<String> rep2_tod_max_pel(JComboBox jComboBox1) {
        ArrayList<String> lista_info_usu_ter = cod_rep2_pel("Terror", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_cien = cod_rep2_pel("Ciencia Ficcion", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_com = cod_rep2_pel("Comedia", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_fan = cod_rep2_pel("Fantasia", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_info_usu_acc = cod_rep2_pel("Accion", (String) jComboBox1.getSelectedItem());
        ArrayList<String> lista_fusion = new ArrayList();

        for (int i = 0; i < lista_info_usu_ter.size(); i += 2) {
            if (lista_info_usu_ter.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_ter.get(i));
                lista_fusion.add(lista_info_usu_ter.get(i + 1));
                lista_fusion.add("Terror");
            }
        }
        for (int i = 0; i < lista_info_usu_cien.size(); i += 2) {
            if (lista_info_usu_cien.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_cien.get(i));
                lista_fusion.add(lista_info_usu_cien.get(i + 1));
                lista_fusion.add("Ciencia Ficcion");
            }
        }
        for (int i = 0; i < lista_info_usu_com.size(); i += 2) {
            if (lista_info_usu_com.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_com.get(i));
                lista_fusion.add(lista_info_usu_com.get(i + 1));
                lista_fusion.add("Comedia");
            }
        }
        for (int i = 0; i < lista_info_usu_fan.size(); i += 2) {
            if (lista_info_usu_fan.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_fan.get(i));
                lista_fusion.add(lista_info_usu_fan.get(i + 1));
                lista_fusion.add("Fantasia");
            }
        }
        for (int i = 0; i < lista_info_usu_acc.size(); i += 2) {
            if (lista_info_usu_acc.get(i + 1).equals("0")) {
                lista_fusion.add("Sin Nombre");
                lista_fusion.add("Sin Compras");
                lista_fusion.add("Sin genero");
            } else {
                lista_fusion.add(lista_info_usu_acc.get(i));
                lista_fusion.add(lista_info_usu_acc.get(i + 1));
                lista_fusion.add("Accion");
            }
        }

        return lista_fusion;

    }

    public ArrayList<Dato_Compras> rep3(String fecha_1, String fecha_2, String archivo) {
        boolean no_esta = false;
        Buscar_Info_Archivo bia = new Buscar_Info_Archivo();
        String[] fecha_min = fecha_1.split("/");
        String[] fecha_max = fecha_2.split("/");
        LocalDate fecha_minima = LocalDate.of(Integer.parseInt(fecha_min[2]), Integer.parseInt(fecha_min[1]), Integer.parseInt(fecha_min[0]));
        LocalDate fecha_maxima = LocalDate.of(Integer.parseInt(fecha_max[2]), Integer.parseInt(fecha_max[1]), Integer.parseInt(fecha_max[0]));
        ArrayList<Dato_Compras> lista_discos = bia.info_rep3(archivo);
        ArrayList<Dato_Compras> lista_por_fecha = new ArrayList<>();
        for (Dato_Compras dato : lista_discos) {
            String[] fecha = dato.getFecha().split("/");
            LocalDate fecha_disco = LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]));
            if (fecha_disco.isAfter(fecha_minima) && fecha_disco.isBefore(fecha_maxima)) {
                if (lista_por_fecha.isEmpty()) {
                    lista_por_fecha.add(dato);
                } else {
                    for (int i = 0;i < lista_por_fecha.size();i++) {
                        if (lista_por_fecha.get(i).getNombre_Articulo().equals(dato.getNombre_Articulo())) {
                            int cantidad = lista_por_fecha.get(i).getCantidad_Comprado();
                            lista_por_fecha.get(i).setCantidad_Comprado((cantidad + dato.getCantidad_Comprado()));
                            no_esta = false;
                            break;
                        } else {
                            no_esta = true;
                        }
                    }
                    if(no_esta){
                        lista_por_fecha.add(dato);
                    }
                }
            }
        }
        return lista_por_fecha;
    }
}
