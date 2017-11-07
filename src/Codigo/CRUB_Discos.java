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
    
    
    //Create a new music disc
    public void Crear_Disco_Musica(String nombre, String autor, String categoria, int precio, int cantidad, String direccion) {
        Catalogo_Musica disco_musica = new Catalogo_Musica(nombre, autor, categoria, precio, cantidad, direccion);
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        crub_archi.Guardar_Info_Musica(disco_musica);

    }
    //Create a new movie disc
    public void Crear_Disco_Pelicula(String nombre, String autor, String categoria, int precio, int cantidad, String direccionURL) {
        Catalogo_Peliculas disco_pelicula = new Catalogo_Peliculas(nombre, autor, categoria, precio, cantidad, direccionURL);
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        crub_archi.Guardar_Info_Pelicula(disco_pelicula);
    }
    // Search the information of the movies
    public ArrayList<Catalogo_Peliculas> Buscar_Informacion_de_peliculas() {
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        ArrayList<Catalogo_Peliculas> discos_peliculas = crub_archi.Buscar_Informacion_Peliculas_Archi();
        return discos_peliculas;
    }
    // Search the music disc information
    public ArrayList<Catalogo_Musica> Buscar_Informacion_de_Musica() {
        CRUB_Archivos crub_archi = new CRUB_Archivos();
        ArrayList<Catalogo_Musica> discos_musica = crub_archi.Buscar_Informacion_Musica_Archi();
        return discos_musica;
    }
    //Check if the disk is in a preorder
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
                fue_borrado = crub_archivos.Actualizar_Disco_Musica(lista, dir_archivo);
            } else {
                ArrayList<Catalogo_Peliculas> lista = crub_archivos.Buscar_Informacion_Peliculas_Archi();
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getNombre().equals(disco)) {
                        lista.remove(i);
                        break;
                    }
                }
                fue_borrado = crub_archivos.Actualizar_Disco_Pelicula(lista, dir_archivo);
            }
        }
        return fue_borrado;
    }
//Update the information of a music disc
    public boolean Actualizar_Discos_Musica(Catalogo_Musica disco_musica, int precio, int cantidad) {
        disco_musica.setPrecio(precio);
        disco_musica.setCantidad_Disponible(cantidad);
        CRUB_Archivos crub_archivos = new CRUB_Archivos();
        ArrayList<Catalogo_Musica> lista = crub_archivos.Buscar_Informacion_Musica_Archi();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(disco_musica.getNombre())) {
                lista.remove(i);
                lista.add(disco_musica);
                break;
            }
        }
        crub_archivos.Actualizar_Disco_Musica(lista,"src/Archivos/cat_musica.txt");
        //verificar en lista preordenes puede enviar el objeto
        //boolean correo = Lista_enviar_mod_disco_mus(nombre_cd, precio);
        //El return es provisional
        return true;
    }
//Update the information of a movie disc
    public boolean Actualizar_Discos_Pelicula(Catalogo_Peliculas disco_pelicula, int precio, int cantidad, String direccionURL) {
        disco_pelicula.setPrecio(precio);
        disco_pelicula.setCantidad_Disponible(cantidad);
        disco_pelicula.setdireccionURL(direccionURL);
        CRUB_Archivos crub_archivos = new CRUB_Archivos();
        ArrayList<Catalogo_Peliculas> lista = crub_archivos.Buscar_Informacion_Peliculas_Archi();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(disco_pelicula.getNombre())) {
                lista.remove(i);
                lista.add(disco_pelicula);
                break;
            }
        }
        crub_archivos.Actualizar_Disco_Pelicula(lista,"src/Archivos/cat_peliculas.txt");
        //verificar en lista preordenes puede enviar el objeto
        
        //El return es provisional
        return false;
    }
    
    // Send an email to the users of the preordenes when a music disc is modified
    public boolean Lista_enviar_mod_disco_mus(String nombre_disco, int precio) {
        boolean registro = false;
        CRUB_Archivos info = new CRUB_Archivos();
        Envios_correos envio = new Envios_correos();
        ArrayList<String> lista = info.Envio_Disco_Actualizar(nombre_disco, "src/Archivos/Pre_Ordenes_Musica.txt");
        ArrayList<String> lista_correos = new ArrayList();
        ArrayList<Integer> lista_cant_preord = new ArrayList();
        ArrayList<Integer> lista_total = new ArrayList();
        int total;
        if (lista != null) {
            
            for (int s = 0; s < lista.size(); s++) {
                if (s % 2 == 0) {
                    lista_correos.add(lista.get(s));
                } else {
                    lista_cant_preord.add(Integer.parseInt(lista.get(s)));
                }
            }
            for (int t = 0; t < lista_cant_preord.size(); t++) {
                total = lista_cant_preord.get(t) * precio;
                lista_total.add(total);
            }

            for (int i = 0; i < lista_correos.size(); i++) {
                registro = true;
                envio.SendMail("proyecto1p2tienda@gmail.com", "UTN2017UTN", "Le informamos ya tenemos en existencias el disco que usted preordeno, Nombre: " + nombre_disco + ", Cantidad: " + lista_cant_preord.get(i) + ", Tipo: Musica" + ", Total de PreOrden: " + lista_total.get(i) + " Gracias", lista_correos.get(i), "Tienda M Y P");
            }
        }
        return registro;
    }
    
      // Send an email to the users of the preordenes when a movie disc is modified
     public boolean Lista_enviar_mod_disco_pel(String nombre_disco, int precio) {
        boolean registro = false;
        CRUB_Archivos info = new CRUB_Archivos();
        Envios_correos envio = new Envios_correos();
        ArrayList<String> lista = info.Envio_Disco_Actualizar(nombre_disco, "src/Archivos/Pre_Ordenes_Peliculas.txt");
        ArrayList<String> lista_correos = new ArrayList();
        ArrayList<Integer> lista_cant_preord = new ArrayList();
        ArrayList<Integer> lista_total = new ArrayList();
        int total;
        if (lista != null) {
            
            for (int s = 0; s < lista.size(); s++) {
                if (s % 2 == 0) {
                    lista_correos.add(lista.get(s));
                } else {
                    lista_cant_preord.add(Integer.parseInt(lista.get(s)));
                }
            }
            for (int t = 0; t < lista_cant_preord.size(); t++) {
                total = lista_cant_preord.get(t) * precio;
                lista_total.add(total);
            }

            for (int i = 0; i < lista_correos.size(); i++) {
                registro = true;
                envio.SendMail("proyecto1p2tienda@gmail.com", "UTN2017UTN", "Le informamos ya tenemos en existencias la pelicula que usted preordeno, Nombre: " + nombre_disco + ", Cantidad: " + lista_cant_preord.get(i) + ", Tipo: Pelicula" + ", Total de PreOrden: " + lista_total.get(i) + " Gracias", lista_correos.get(i), "Tienda M Y P");
            }
        }
        return registro;
    }
}
