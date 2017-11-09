/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.CRUB_Archivos;
import Objetos.*;
import Vista.Ventana_Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class Metodos_Compras {
    //Return the date
    public String Obtener_Fecha() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    //Return position CD of music
    public int Buscar_Objeto_Musica(ArrayList<Catalogo_Musica> lista, String nombre) {
        int posicion = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    //Return position CD of movie
    public int Buscar_Objeto_Pelicula(ArrayList<Catalogo_Peliculas> lista, String nombre) {
        int posicion = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    //This method send the CDs purchased and CDs of pre-order to txt
    public boolean Realizando_Compras_Peliculas_Musica(ArrayList<Catalogo_Peliculas> lista_peli, ArrayList<Catalogo_Musica> lista_musica) {
        boolean agregado_compras = false;
        ArrayList<Dato_Compras> lista_comprados_archivo = new ArrayList<>();
        ArrayList<Dato_Compras> lista_preorden_archivo = new ArrayList<>();
        for (int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++) {
            Dato_Compras dato = Ventana_Usuario.discos_para_comprar.get(i);

            if (dato.getTipo_Articulo().equals("musica")) {
                int posicion = Buscar_Objeto_Musica(lista_musica, dato.getNombre_Articulo());
                if (lista_musica.get(posicion).getCantidad_Disponible() < dato.getCantidad_Comprado()) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "¿Quieres agregar a preordenes " + dato.getNombre_Articulo() + "?", null, JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        lista_preorden_archivo.add(dato);
                    }
                } else {
                    lista_musica.get(posicion).setCantidad_Disponible(lista_musica.get(posicion).getCantidad_Disponible() - dato.getCantidad_Comprado());
                    dato.setFecha(Obtener_Fecha());
                    lista_comprados_archivo.add(dato);
                }
            }

            if (dato.getTipo_Articulo().equals("pelicula")) {
                int posicion = Buscar_Objeto_Pelicula(lista_peli, dato.getNombre_Articulo());
                if (lista_peli.get(posicion).getCantidad_Disponible() < dato.getCantidad_Comprado()) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "¿Quieres agregar a preordenes " + dato.getNombre_Articulo() + "?", null, JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        lista_preorden_archivo.add(dato);
                    }
                } else {
                    lista_peli.get(posicion).setCantidad_Disponible(lista_peli.get(posicion).getCantidad_Disponible() - dato.getCantidad_Comprado());
                    dato.setFecha(Obtener_Fecha());
                    lista_comprados_archivo.add(dato);
                }
            }
        }
        CRUB_Archivos crub_archivos = new CRUB_Archivos();
        agregado_compras = crub_archivos.Actualizar_Disco_Musica(lista_musica, "src/Archivos/cat_musica.txt");
        agregado_compras = crub_archivos.Actualizar_Disco_Pelicula(lista_peli, "src/Archivos/cat_peliculas.txt");
        crub_archivos.Agregar_PreOrden_Y_Compra(lista_preorden_archivo ,lista_comprados_archivo);
        return agregado_compras;
    }
     //This method Return the sum of the all CDs of the client   
    public int Costo_Total(ArrayList<Dato_Compras> lista){
        int costo_total = 0;
        if(lista != null){
        for (Dato_Compras dato_Compras : lista) {
            costo_total = costo_total + dato_Compras.getPrecio();
        }
        }
        
        return costo_total;
    }
}
