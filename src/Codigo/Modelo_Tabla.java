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
    //This method recieves a table and parameters for search music disk and set the information
    public void Modelo_Tabla_Musica(JTable tabla, String tipo_busqueda, String valor1, String valor2) {
        Object[][] disco = Agregar_Discos_Tabla_Musica(tipo_busqueda, valor1, valor2);
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
    //This method recieves a table and parameters for search movie disk and set the information
    public void Modelo_Tabla_Pelicula(JTable tabla, String tipo_busqueda, String valor1, String valor2) {
        Object[][] discos = Agregar_Discos_Tabla_Pelicula(tipo_busqueda, valor1, valor2);
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
    //This method add music disk in a two-dimensional array
    private Object[][] Agregar_Discos_Tabla_Musica(String tipo_busqueda, String valor1, String valor2) {
        CRUB_Discos crub_disco = new CRUB_Discos();
        ArrayList<Catalogo_Musica> lista_nueva = new ArrayList<>();
        ArrayList<Catalogo_Musica> lista_musica = crub_disco.Buscar_Informacion_de_Musica();
        switch (tipo_busqueda) {
            case "Nombre Disco":
                for (int i = 0; i < lista_musica.size(); i++) {
                    if (lista_musica.get(i).getNombre().contains(valor1)) {
                        lista_nueva.add(lista_musica.get(i));
                    }
                }
                break;
            case "Autor":
                for (int i = 0; i < lista_musica.size(); i++) {
                    if (lista_musica.get(i).getAutor().contains(valor1)) {
                        lista_nueva.add(lista_musica.get(i));

                    }
                }
                break;
            case "Categoria":
                for (int i = 0; i < lista_musica.size(); i++) {
                    if (lista_musica.get(i).getCategoria().contains(valor1)) {
                        lista_nueva.add(lista_musica.get(i));

                    }
                }
                break;
            case "Cancion":
                for (int i = 0; i < lista_musica.size(); i++) {
                    String cancion = lista_musica.get(i).getDireccion_Cancion().replace("src/Archivos/Canciones/", "");
                    if (cancion.contains(valor1)) {
                        lista_nueva.add(lista_musica.get(i));
                    }
                }
                break;
            case "Precio":
                int rango_menor = 0;
                int rango_mayor = 0;
                try {
                    rango_menor = Integer.parseInt(valor1);
                    rango_mayor = Integer.parseInt(valor2);
                    if (rango_menor <= rango_mayor) {
                        for (int i = 0; i < lista_musica.size(); i++) {
                            if (lista_musica.get(i).getPrecio() <= rango_mayor && lista_musica.get(i).getPrecio() >= rango_menor) {
                                lista_nueva.add(lista_musica.get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < lista_musica.size(); i++) {
                            if (lista_musica.get(i).getPrecio() >= rango_mayor && lista_musica.get(i).getPrecio() <= rango_menor) {
                                lista_nueva.add(lista_musica.get(i));
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    rango_menor = 0;
                    rango_mayor = 0;
                }
                break;
            default:
                for (int i = 0; i < lista_musica.size(); i++) {
                    lista_nueva.add(lista_musica.get(i));
                }
                break;
        }
        Object[][] informacion_discos = new Object[lista_nueva.size()][7];
        for (int i = 0; i < lista_nueva.size(); i++) {
            JButton btnAgregar = new JButton("Agregar Carrito");
            btnAgregar.setName("agregar");
            JButton btnCancion = new JButton("Reproducir Cancion");
            btnCancion.setName(lista_nueva.get(i).getDireccion_Cancion());
            informacion_discos[i][0] = lista_nueva.get(i).getNombre();
            informacion_discos[i][1] = lista_nueva.get(i).getAutor();
            informacion_discos[i][2] = lista_nueva.get(i).getCategoria();
            informacion_discos[i][3] = lista_nueva.get(i).getPrecio();
            informacion_discos[i][4] = lista_nueva.get(i).getCantidad_Disponible();
            informacion_discos[i][5] = btnCancion;
            informacion_discos[i][6] = btnAgregar;
        }

        return informacion_discos;
    }
    //This method add movie disk in a two-dimensional array
    private Object[][] Agregar_Discos_Tabla_Pelicula(String tipo_busqueda, String valor1, String valor2) {
        CRUB_Discos crub_disco = new CRUB_Discos();
        ArrayList<Catalogo_Peliculas> lista_nueva = new ArrayList<>();
        ArrayList<Catalogo_Peliculas> lista_pelicula = crub_disco.Buscar_Informacion_de_peliculas();
        switch (tipo_busqueda) {
            case "Nombre Disco":
                for (int i = 0; i < lista_pelicula.size(); i++) {
                    if (lista_pelicula.get(i).getNombre().contains(valor1)) {
                        lista_nueva.add(lista_pelicula.get(i));
                    }
                }
                break;
            case "Autor":
                for (int i = 0; i < lista_pelicula.size(); i++) {
                    if (lista_pelicula.get(i).getAutor().contains(valor1)) {
                        lista_nueva.add(lista_pelicula.get(i));

                    }
                }
                break;
            case "Categoria":
                for (int i = 0; i < lista_pelicula.size(); i++) {
                    if (lista_pelicula.get(i).getCategoria().contains(valor1)) {
                        lista_nueva.add(lista_pelicula.get(i));

                    }
                }
                break;
            case "Precio":
                int rango_menor = 0;
                int rango_mayor = 0;
                try {
                    rango_menor = Integer.parseInt(valor1);
                    rango_mayor = Integer.parseInt(valor2);
                    if (rango_menor <= rango_mayor) {
                        for (int i = 0; i < lista_pelicula.size(); i++) {
                            if (lista_pelicula.get(i).getPrecio() <= rango_mayor && lista_pelicula.get(i).getPrecio() >= rango_menor) {
                                lista_nueva.add(lista_pelicula.get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < lista_pelicula.size(); i++) {
                            if (lista_pelicula.get(i).getPrecio() >= rango_mayor && lista_pelicula.get(i).getPrecio() <= rango_menor) {
                                lista_nueva.add(lista_pelicula.get(i));
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    rango_menor = 0;
                    rango_mayor = 0;
                }
                break;
            default:
                for (int i = 0; i < lista_pelicula.size(); i++) {
                    lista_nueva.add(lista_pelicula.get(i));

                }
                break;
        }
        Object[][] informacion_discos = new Object[lista_nueva.size()][7];
        for (int i = 0; i < lista_nueva.size(); i++) {
            JButton btnAgregar = new JButton("Agregar Carrito");
            btnAgregar.setName("agregar");
            JButton btnPelicula = new JButton("Ver Trailer");
            btnPelicula.setName(lista_nueva.get(i).getdireccionURL());
            informacion_discos[i][0] = lista_nueva.get(i).getNombre();
            informacion_discos[i][1] = lista_nueva.get(i).getAutor();
            informacion_discos[i][2] = lista_nueva.get(i).getCategoria();
            informacion_discos[i][3] = lista_nueva.get(i).getPrecio();
            informacion_discos[i][4] = lista_nueva.get(i).getCantidad_Disponible();
            informacion_discos[i][5] = btnPelicula;
            informacion_discos[i][6] = btnAgregar;
        }
        return informacion_discos;
    }
    //This method return the name of the disk in a table
    public String Obtener_Disco(JTable tabla, int row) {
        String nombre_disco = (String) tabla.getValueAt(row, 0);
        return nombre_disco;
    }
    //This method clean a table especific "Tabla_Compras"
    public DefaultTableModel Limpiar_Tabla(JTable Tabla_Compras) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla_Compras.getModel();
        int filas = Tabla_Compras.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
        return modelo;
    }
    //This method update music table
    public DefaultTableModel Actualizar_Tabla_Compras_Musica(JTable Tabla_Compras, Catalogo_Musica disco_musica, String[] usuario, int cantidad) {
        Dato_Compras dato;
        Object[] objeto;
        dato = new Dato_Compras(usuario[0], Integer.parseInt(usuario[2]), usuario[3], disco_musica.getNombre(), (disco_musica.getPrecio() * cantidad), cantidad, "musica", "");
        Ventana_Usuario.discos_para_comprar.add(dato);
        DefaultTableModel modelo = Limpiar_Tabla(Tabla_Compras);
        for (int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++) {
            objeto = new Object[]{Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo(),
                Ventana_Usuario.discos_para_comprar.get(i).getPrecio(),
                Ventana_Usuario.discos_para_comprar.get(i).getCantidad_Comprado()};
            modelo.addRow(objeto);
        }
        return modelo;
    }
    //This method update movie table
    public DefaultTableModel Actualizar_Tabla_Compras_Peliculas(JTable Tabla_Compras, Catalogo_Peliculas disco_pelicula, String[] usuario, int cantidad) {
        Dato_Compras dato;
        Object[] objeto;
        dato = new Dato_Compras(usuario[0], Integer.parseInt(usuario[2]), usuario[3], disco_pelicula.getNombre(), (disco_pelicula.getPrecio() * cantidad), cantidad, "pelicula", "");
        Ventana_Usuario.discos_para_comprar.add(dato);
        DefaultTableModel modelo = Limpiar_Tabla(Tabla_Compras);
        for (int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++) {
            objeto = new Object[]{Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo(),
                Ventana_Usuario.discos_para_comprar.get(i).getPrecio(),
                Ventana_Usuario.discos_para_comprar.get(i).getCantidad_Comprado()};
            modelo.addRow(objeto);
        }
        return modelo;
    }
    //This method remove a disk of "Tabla_Compras"
    public DefaultTableModel Eliminar_Objeto_Compra(String disco, JTable Tabla_Compras) {
        Object[] objeto;
        DefaultTableModel modelo = Limpiar_Tabla(Tabla_Compras);
        for (int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++) {
            if (Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo().equals(disco)) {
                Ventana_Usuario.discos_para_comprar.remove(i);
                break;
            }
        }
        for (int i = 0; i < Ventana_Usuario.discos_para_comprar.size(); i++) {
            objeto = new Object[]{Ventana_Usuario.discos_para_comprar.get(i).getNombre_Articulo(),
                Ventana_Usuario.discos_para_comprar.get(i).getPrecio(),
                Ventana_Usuario.discos_para_comprar.get(i).getCantidad_Comprado()};
            modelo.addRow(objeto);
        }
        return modelo;
    }
}