/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Codigo_Archivos.Reg_Usuari;

/**
 *
 * @author estudiante
 */
public class Reg_Usuario {
    Reg_Usuari usu_new = new Reg_Usuari();
    
    //Check the information of the user
    public boolean Comp_usu(String txtReg_Usu) {
        boolean dp = usu_new.usuarios_reg(txtReg_Usu);

        return dp;

    }
    // Save the information of the user
    public void  Guard_Usu(String txtReg_Usu, String txtReg_Pass, String txtReg_ced, String txtReg_correo) {
        usu_new.guardar_usuario(txtReg_Usu, txtReg_Pass, txtReg_ced, txtReg_correo);
    }

}
