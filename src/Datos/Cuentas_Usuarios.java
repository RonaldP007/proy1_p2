/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Enrique
 */
public class Cuentas_Usuarios {
    public boolean Verificar_cuenta(String cuenta,String clave){
        boolean existe_usuario = false;
        String line;
        String[] usuario_archivo = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/archivos/cuentas.txt"))){
            while(((line = br.readLine())!= null)){
                usuario_archivo = line.split(";");
                if(usuario_archivo[0].equals(cuenta) && usuario_archivo[1].equals(clave)){
                    existe_usuario = true;
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("Se despicho" + ex);
        }
        return existe_usuario;
    }
        public String[] Buscar_cuenta(String cuenta,String clave){
        String line;
        String[] usuario_archivo = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/archivos/cuentas.txt"))){
            while(((line = br.readLine())!= null)){
                usuario_archivo = line.split(";");
                if(usuario_archivo[0].equals(cuenta) && usuario_archivo[1].equals(clave)){
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("Se despicho" + ex);
        }
        return usuario_archivo;
    }
}
