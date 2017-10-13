/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class Reg_Usuari {

    public void usuarios_reg(String txtReg_Usu, String txtReg_Pass, String txtReg_ced, String txtReg_correo) {
        try {
            String temp;
            BufferedReader bf = new BufferedReader(new FileReader("src/Archivos/cuentas.txt"));

            temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                temp = bfRead;
                String lista = temp;
                String[] lista1 = lista.split(";");
                if (lista1[0].equals(txtReg_Usu)) {
                    JOptionPane.showMessageDialog(null, "Ese Usuario ya se encuentra registrado");

                } else {
                    try {
                        String datos = txtReg_Usu + ";" + txtReg_Pass + ";" + txtReg_ced + ";" + txtReg_correo+";"+"1";
                        File archivo = new File("src/Archivos/cuentas.txt");
                        FileWriter escribir = new FileWriter(archivo, true);
                        escribir.write( datos + System.lineSeparator());
                        escribir.close();
 
          

                    } catch (IOException e) {
                        System.out.println("Error al escribir" + e);
                    }
                }

            }

        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e);
        }
    }
}
