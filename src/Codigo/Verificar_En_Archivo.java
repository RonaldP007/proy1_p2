/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Datos.Buscar_Info_Archivo;

/**
 *
 * @author Enrique
 */
public class Verificar_En_Archivo {
    public boolean Verificar(String nombre_archivo, String nombre_peli_dis){
        Buscar_Info_Archivo bia = new Buscar_Info_Archivo();
        boolean repetido = bia.Info_repetida(nombre_archivo, nombre_peli_dis);
        return repetido;
    }
}
