/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.Cuentas_Usuarios;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class Codigo_Login {
    //Validate if the username and password are correct
    public ArrayList Verificar(String cuenta,String clave){
        String[] usuario_info;
        ArrayList lista = new ArrayList();
        Cuentas_Usuarios cu = new Cuentas_Usuarios();
        if(cu.Verificar_cuenta(cuenta,clave)){
            usuario_info = cu.Buscar_cuenta(cuenta,clave);
            if(usuario_info[4].equals("0")){               
                lista.add("0");
                lista.add(usuario_info);
            }else{
                lista.add("1");
                lista.add(usuario_info);
            }
        }else{
            lista.add("El usuario o la contraseña no son correctos");
        }
        return lista;
    }
    
}
