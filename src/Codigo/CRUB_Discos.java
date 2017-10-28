/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.CRUB_Archivos;
import Objetos.Catalogo_Musica;
import Objetos.Catalogo_Peliculas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class CRUB_Discos {

    public void Crear_Disco_Musica(String nombre, String autor, String categoria, int precio, int cantidad, String direccion) {
        Catalogo_Musica disco_musica = new Catalogo_Musica(nombre, autor, categoria, precio, cantidad, direccion);
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        crub_archi.Guardar_Info_Musica(disco_musica);

    }

    public void Crear_Disco_Pelicula(String nombre, String autor, String categoria, int precio, int cantidad, String direccionURL) {
        Catalogo_Peliculas disco_pelicula = new Catalogo_Peliculas(nombre, autor, categoria, precio, cantidad, direccionURL);
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        crub_archi.Guardar_Info_Pelicula(disco_pelicula);
    }

    public ArrayList<Catalogo_Peliculas> Buscar_Informacion_de_peliculas() {
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        ArrayList<Catalogo_Peliculas> discos_peliculas = crub_archi.Buscar_Informacion_Peliculas_Archi();
        return discos_peliculas;
    }

    public ArrayList<Catalogo_Musica> Buscar_Informacion_de_Musica() {
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        ArrayList<Catalogo_Musica> discos_musica = crub_archi.Buscar_Informacion_Musica_Archi();
        return discos_musica;
    }

    public boolean Verificar_Disco_En_PreOrden(String disco, String dir_archivo, String dir_archivo_preorden) {
        CRUB_Archivos crub_archivos = new CRUB_Archivos();
        boolean fue_borrado = false;
        boolean repetido = crub_archivos.Verificar_Disco_Repetido_PreOrden(disco, dir_archivo_preorden);
        if (repetido) {
            JOptionPane.showMessageDialog(null, "El disco no se puede eliminar ya que esta en lista pre-ordenes");
        } else {
            if (dir_archivo.contains("cat_musica.txt")) {
                ArrayList<Catalogo_Musica> lista = crub_archivos.Buscar_Informacion_Musica_Archi();
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getNombre().equals(disco)) {
                        lista.remove(i);
                        break;
                    }
                }
                fue_borrado = crub_archivos.Eliminar_Disco_Musica(lista, dir_archivo);
            } else {
                ArrayList<Catalogo_Peliculas> lista = crub_archivos.Buscar_Informacion_Peliculas_Archi();
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getNombre().equals(disco)) {
                        lista.remove(i);
                        break;
                    }
                }
                fue_borrado = crub_archivos.Eliminar_Disco_Pelicula(lista, dir_archivo);
            }
        }
        return fue_borrado;
    }

    public boolean Actualizar_Discos_Musica(Catalogo_Musica disco_musica, int precio, int cantidad) {
        disco_musica.setPrecio(precio);
        disco_musica.setCantidad_Disponible(cantidad);
        //Enviar a actualizar info y verificar en lista preordenes
        //El return es provisional
        return false;
    }

    public boolean Actualizar_Discos_Pelicula(Catalogo_Peliculas disco_pelicula, int precio, int cantidad,String direccionURL) {
        disco_pelicula.setPrecio(precio);
        disco_pelicula.setCantidad_Disponible(cantidad);
        disco_pelicula.setdireccionURL(direccionURL);
        //Enviar a actualizar info y verificar en lista preordenes
        //El return es provisional
        return false;
    }
}
