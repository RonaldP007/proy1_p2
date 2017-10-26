/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Datos.Cuentas_Usuarios;
import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class Codigo_Login {
    public ArrayList Verificar(String cuenta,String clave){
        String[] usuario_info;
        ArrayList lista = new ArrayList();
        boolean usuario = false;
        Cuentas_Usuarios cu = new Cuentas_Usuarios();
        if(cu.Verificar_cuenta(cuenta,clave)){
            usuario_info = cu.Buscar_cuenta(cuenta,clave);
            if(usuario_info[4].equals("0")){
                usuario = true;
                lista.add(usuario);
                lista.add("0");
            }else{
                lista.add(usuario);
                lista.add("1");
            }
        }else{
            lista.add(usuario);
            lista.add("El usuario o la contraseña no son correctos");
        }
        return lista;
    }
    
}
