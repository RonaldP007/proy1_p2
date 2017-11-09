/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Ronald
 */
public class Dato_Compras {
    String nombre;
    int cedula;
    String correo;
    String nombre_articulo;
    int cantidad_comprado;
    String tipo_articulo;
    int precio;
    String fecha;
    
    //This contructor receives the information of a purchased disk and converte in a object
    public Dato_Compras(String nombre, int cedula, String correo, String nombre_articulo,int precio, int cantidad_comprado,String tipo_articulo,
    String fecha) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre_articulo = nombre_articulo;
        this.precio = precio;
        this.cantidad_comprado = cantidad_comprado;
        this.tipo_articulo = tipo_articulo;
        this.fecha = fecha;
    }
    //This method return the name of user
    public String getNombre() {
        return nombre;
    }
    //This method set new name of user
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //This method return identification of user
    public int getCedula() {
        return cedula;
    }
    //This method set new identification of user
    public void setCedula (int cedula) {
        this.cedula  = cedula ;
    }
    //This method return the email of user
    public String getCorreo() {
        return correo ;
    }
    //This method set new email of user
    public void setCorreo(String correo) {
        this.correo  = correo ;
    }
    //This method return a name of a disk
    public String getNombre_Articulo() {
        return nombre_articulo;
    }
    //This method set new name of a disk
    public void setNombre_Articulo(String nombre_articulo) {
        this.nombre_articulo= nombre_articulo;
    }
    //This method return the price of a disk
    public int getPrecio() {
        return precio;
    }
    //This method set new price of a disk
    public void setPrecio(int precio) {
        this.precio = precio;
    }
        //This method return amount of a disk
    public int getCantidad_Comprado() {
        return cantidad_comprado;
    }
    //This method set new amount of a disk
    public void setCantidad_Comprado(int cantidad_comprado) {
        this.cantidad_comprado = cantidad_comprado;
    }
    //This method return kind of disk
    public String getTipo_Articulo() {
        return tipo_articulo;
    }
    //This method set new kind of disk
    public void setTipo_Articulo(String tipo_articulo) {
        this.tipo_articulo = tipo_articulo;
    }
    //This method return the date of purchased disk
    public String getFecha() {
        return fecha;
    }
    //This method set the date of purchased disk
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
