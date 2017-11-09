package Objetos;

public class Catalogo_Peliculas extends Datos_Catalogo {

    public String direccionURL;
    //This constructor receives the information of a disk
    public Catalogo_Peliculas(String nombre, String autor, String categoria, int precio, int cantidad_disponible, String direccionURL) {
        super(nombre, autor, categoria, precio, cantidad_disponible);
        this.direccionURL = direccionURL;
    }
    //This method return URL of disk
    public String getdireccionURL() {
        return direccionURL;
    }
    //This method set new URL of disk
    public void setdireccionURL(String direccionURL) {
        this.direccionURL = direccionURL;
    }
}
