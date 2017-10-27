package Objetos;

public class Catalogo_Peliculas extends Datos_Catalogo {

    public String direccionURL;
    public Catalogo_Peliculas(String nombre, String autor, String categoria, int precio, int cantidad_disponible, String direccionURL) {
        super(nombre, autor, categoria, precio, cantidad_disponible);
        this.direccionURL = direccionURL;
    }

    public String getdireccionURL() {
        return direccionURL;
    }

    public void setdireccionURL(String direccionURL) {
        this.direccionURL = direccionURL;
    }
}
