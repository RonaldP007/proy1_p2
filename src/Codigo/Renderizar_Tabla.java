/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Enrique
 */
public class Renderizar_Tabla extends DefaultTableCellRenderer{
    //The following method renders the table and adds a button
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof JButton){
                JButton btn = (JButton) value;
                return btn;
            }
        return super.getTableCellRendererComponent(table, value, isSelected, 
            hasFocus, row, column);
    }
  
}
