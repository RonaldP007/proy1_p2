package Codigo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class Graficos {
    public static void main(String args[]){
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("C", 40);
        data.setValue("Java", 58);
        data.setValue("Python", 15);
        data.setValue("PHP", 35);
        data.setValue("Perl", 15);
        data.setValue("C++", 10);
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Reportes Discos", 
         data, 
         true, 
         true, 
         false);
 
        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Reportes");
    }
}