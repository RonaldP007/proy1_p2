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
    
    public Dato_Compras(String nombre, int cedula, String correo, String nombre_articulo,int precio, int cantidad_comprado,String tipo_articulo,
    String fecha
    ) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre_articulo = nombre_articulo;
        this.precio = precio;
        this.cantidad_comprado = cantidad_comprado;
        this.tipo_articulo = tipo_articulo;
        this.fecha = fecha;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula (int cedula) {
        this.cedula  = cedula ;
    }

    public String getCorreo() {
        return correo ;
    }

    public void setCorreo(String correo) {
        this.correo  = correo ;
    }

    public String getNombre_Articulo() {
        return nombre_articulo;
    }

    public void setNombre_Articulo(String nombre_articulo) {
        this.nombre_articulo= nombre_articulo;
    }
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad_Comprado() {
        return cantidad_comprado;
    }

    public void setCantidad_Comprado(int cantidad_comprado) {
        this.cantidad_comprado = cantidad_comprado;
    }
    public String getTipo_Articulo() {
        return tipo_articulo;
    }

    public void setTipo_Articulo(String tipo_articulo) {
        this.tipo_articulo = tipo_articulo;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
