/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Enrique
 */
public class Dato_Pre_Orden {

    String usuario;
    String nombre_disco;
    String tipo_disco;
    String correo;
    int cantidad;
    //This contructor receives the information of a pre-order and converte in a object
    public Dato_Pre_Orden(String usuario, String nombre_disco, String tipo_disco, String correo,int cantidad) {
        this.usuario = usuario;
        this.nombre_disco = nombre_disco;
        this.tipo_disco = tipo_disco;
        this.correo = correo;
        this.cantidad = cantidad;
    }
    //This method return the name of user
    public String getUsuario(){
        return usuario;
    }
    //This method set new name of user
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    //This method return the name of disk
    public String getNombre_Disco(){
        return nombre_disco;
    }
    //This method set new name of disk
    public void setNombre_Disco(String nombre_disco){
        this.nombre_disco = nombre_disco;
    }
    //This method return the kind of disk
    public String getTipo_Disco(){
        return tipo_disco;
    }
    //This method set new kind of disk
    public void setTipo_Disco(String tipo_disco){
        this.tipo_disco = tipo_disco;
    }
    //This method return the email of user
    public String getCorreo(){
        return correo;
    }
    //This method set new email of user
    public void setCorreo(String correo){
        this.correo = correo;
    }
    //This method return the amount of a disk
    public int getCantidad(){
        return cantidad;
    }
    //This method set new amount of a disk
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
}
