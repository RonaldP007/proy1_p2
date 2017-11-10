/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.Buscar_Info_Archivo;
import Codigo_Archivos.CRUB_Archivos;
import Objetos.Dato_Compras;
import Objetos.Dato_Pre_Orden;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class Verificar_En_Archivo {
    
    //Check if the name of a music or movie disk is repeated
    public boolean Verificar(String nombre_archivo, String nombre_peli_dis){
        Buscar_Info_Archivo bia = new Buscar_Info_Archivo();
        boolean repetido = bia.Info_repetida(nombre_archivo, nombre_peli_dis);
        return repetido;
    }
    //Return a list with all pre-order discs
    public ArrayList<Dato_Pre_Orden> Buscar_Pre_Ordenes(String archivo){
        CRUB_Archivos crub_archivos = new CRUB_Archivos();
        ArrayList<Dato_Pre_Orden> lista = crub_archivos.Buscar_Pre_Orden_Archivo(archivo);
        return lista;
    }
    //Add in the table all pre-order discs
    public void Agregar_En_Preoden(JTable tabla, ArrayList<Dato_Pre_Orden> lista){
        Modelo_Tabla mt = new Modelo_Tabla();
        mt.Limpiar_Tabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (Dato_Pre_Orden dato_Pre_Orden : lista) {
            Object[] disco = {dato_Pre_Orden.getNombre_Disco(),dato_Pre_Orden.getTipo_Disco(),dato_Pre_Orden.getCantidad()};
            modelo.addRow(disco);
        }
    }
    //Return a list with all purchased discs 
    public ArrayList<Dato_Compras> Buscar_Compras(String archivo,String cedula){
        CRUB_Archivos crub_archivos = new CRUB_Archivos();
        ArrayList<Dato_Compras> lista = crub_archivos.Buscar_Compras_Archivo(archivo, cedula);
        return lista;
    }
    //Add in the table all purchased discs
    public void Agregar_En_Tabla_Compras(JTable tabla, ArrayList<Dato_Compras> lista){
        Modelo_Tabla mt = new Modelo_Tabla();
        mt.Limpiar_Tabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (Dato_Compras dato_compra : lista) {
            Object[] disco = {dato_compra.getNombre(),dato_compra.getCedula(),
                dato_compra.getCorreo(),dato_compra.getNombre_Articulo(),
                dato_compra.getCantidad_Comprado()};
            modelo.addRow(disco);
        }
    }
}
