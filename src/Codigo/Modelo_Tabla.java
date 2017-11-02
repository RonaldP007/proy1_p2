/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import Objetos.Dato_Compras;
import Vista.Ventana_Usuario;
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
            btnAgregar.setName("agregar");
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

    public String Obtener_Disco(JTable tabla, int row) {
        String nombre_disco =(String) tabla.getValueAt(row, 0);
        return nombre_disco;
    }
    public DefaultTableModel Limpiar_Tabla(JTable Tabla_Compras){
        DefaultTableModel modelo = (DefaultTableModel) Tabla_Compras.getModel();
            int filas = Tabla_Compras.getRowCount();
            for (int i = 0; i < filas; i++) {
                modelo.removeRow(0);
            }
            return modelo;
    }

    public DefaultTableModel Actualizar_Tabla_Compras_Musica(JTable Tabla_Compras, Catalogo_Musica disco_musica,String[] usuario,int cantidad) {
        Dato_Compras dato;
        Object[] objeto;
        dato = new Dato_Compras(usuario[0],Integer.parseInt(usuario[2]),usuario[3], disco_musica.getNombre(), (disco_musica.getPrecio()*cantidad), cantidad, "musica","");
        Ventana_Usuario.discos_para_comprar.add(dato);
        DefaultTableModel modelo = Limpiar_Tabla(Tabla_Compras);
        for(int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++){
            objeto = new Object[]{Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo(),
            Ventana_Usuario.discos_para_comprar.get(i).getPrecio(),
            Ventana_Usuario.discos_para_comprar.get(i).getCantidad_Comprado()};
            modelo.addRow(objeto);
        }
        return modelo;
    }
    public DefaultTableModel Actualizar_Tabla_Compras_Peliculas(JTable Tabla_Compras, Catalogo_Peliculas disco_pelicula,String[] usuario,int cantidad) {
        Dato_Compras dato;
        Object[] objeto;
        dato = new Dato_Compras(usuario[0],Integer.parseInt(usuario[2]),usuario[3], disco_pelicula.getNombre(), (disco_pelicula.getPrecio()*cantidad), cantidad, "pelicula","");
        Ventana_Usuario.discos_para_comprar.add(dato);
        DefaultTableModel modelo = Limpiar_Tabla(Tabla_Compras);
        for(int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++){
            objeto = new Object[]{Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo(),
            Ventana_Usuario.discos_para_comprar.get(i).getPrecio(),
            Ventana_Usuario.discos_para_comprar.get(i).getCantidad_Comprado()};
            modelo.addRow(objeto);
        }
        return modelo;
    }

    public DefaultTableModel Eliminar_Objeto_Compra(String disco, JTable Tabla_Compras) {
        Object[] objeto;
        DefaultTableModel modelo = Limpiar_Tabla(Tabla_Compras);
        for(int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++){
         if(Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo().equals(disco)){
             Ventana_Usuario.discos_para_comprar.remove(i);
             break;
         }
        }
        for(int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++){
            objeto = new Object[]{Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo(),
            Ventana_Usuario.discos_para_comprar.get(i).getPrecio(),
            Ventana_Usuario.discos_para_comprar.get(i).getCantidad_Comprado()};
            modelo.addRow(objeto);
        }
        return modelo;
    }
}
