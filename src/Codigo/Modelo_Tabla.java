/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class Modelo_Tabla {

    public void Modelo_Tabla_Musica(JTable tabla) {
        Object[][] disco = Agregar_Discos_Tabla_Musica();
        tabla.setDefaultRenderer(Object.class, new Renderizar_Tabla());
        DefaultTableModel modelo = new DefaultTableModel(
                disco,
                new Object[]{"Nombre del disco", "Autor", "Categoria", "Precio", "Cantidad Disponible", "Canciones", "Agregar Carrito"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(modelo);
    }

    public void Modelo_Tabla_Pelicula(JTable tabla) {
        Object[][] discos = Agregar_Discos_Tabla_Pelicula();//Enviar por parametro el tipo de busqueda y los valores o valor
        tabla.setDefaultRenderer(Object.class, new Renderizar_Tabla());
        DefaultTableModel modelo = new DefaultTableModel(
                discos,
                new Object[]{"Nombre del disco", "Director", "Categoria", "Precio", "Cantidad Disponible", "Ver Trailer", "Agregar Carrito"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setModel(modelo);
    }

    private Object[][] Agregar_Discos_Tabla_Musica() {
        CRUB_Discos crub_disco = new CRUB_Discos();
        ArrayList<Catalogo_Musica> lista_musica = crub_disco.Buscar_Informacion_de_Musica();
        Object[][] informacion_discos = new Object[lista_musica.size()][7];
        for (int i = 0; i < lista_musica.size(); i++) {
            JButton btnAgregar = new JButton("Agregar Carrito");
            btnAgregar.setName("agregar");
            JButton btnCancion = new JButton("Reproducir Cancion");
            btnCancion.setName(lista_musica.get(i).getDireccion_Cancion());
            informacion_discos[i][0] = lista_musica.get(i).getNombre();
            informacion_discos[i][1] = lista_musica.get(i).getAutor();
            informacion_discos[i][2] = lista_musica.get(i).getCategoria();
            informacion_discos[i][3] = lista_musica.get(i).getPrecio();
            informacion_discos[i][4] = lista_musica.get(i).getCantidad_Disponible();
            informacion_discos[i][5] = btnCancion;
            informacion_discos[i][6] = btnAgregar;
        }
        return informacion_discos;
    }

    private Object[][] Agregar_Discos_Tabla_Pelicula() {
        CRUB_Discos crub_disco = new CRUB_Discos();
        ArrayList<Catalogo_Peliculas> lista_peliculas = crub_disco.Buscar_Informacion_de_peliculas();
        Object[][] informacion_discos = new Object[lista_peliculas.size()][7];
        for (int i = 0; i < lista_peliculas.size(); i++) {
            JButton btnAgregar = new JButton("Agregar Carrito");
            JButton btnVerTrailer = new JButton("Ver Trailer");
            btnVerTrailer.setName(lista_peliculas.get(i).getdireccionURL());
            informacion_discos[i][0] = lista_peliculas.get(i).getNombre();
            informacion_discos[i][1] = lista_peliculas.get(i).getAutor();
            informacion_discos[i][2] = lista_peliculas.get(i).getCategoria();
            informacion_discos[i][3] = lista_peliculas.get(i).getPrecio();
            informacion_discos[i][4] = lista_peliculas.get(i).getCantidad_Disponible();
            informacion_discos[i][5] = btnVerTrailer;
            informacion_discos[i][6] = btnAgregar;
        }
        return informacion_discos;
    }
}
