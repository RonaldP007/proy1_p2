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
    
    public Dato_Pre_Orden(String usuario, String nombre_disco, String tipo_disco, String correo,int cantidad) {
        this.usuario = usuario;
        this.nombre_disco = nombre_disco;
        this.tipo_disco = tipo_disco;
        this.correo = correo;
        this.cantidad = cantidad;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getNombre_Disco(){
        return nombre_disco;
    }
    public void setNombre_Disco(String nombre_disco){
        this.nombre_disco = nombre_disco;
    }
    public String getTipo_Disco(){
        return tipo_disco;
    }
    public void setTipo_Disco(String tipo_disco){
        this.tipo_disco = tipo_disco;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
}
