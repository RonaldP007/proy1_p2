package Codigo;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Graficos {

    public static void main(String args[]) {
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
     //Graph the report information 1
    public void graficar_rep1(String genero, JPanel panel) {
        Codigo_Reportes cr = new Codigo_Reportes();
        ArrayList<String> lista_compra_total = cr.cod_rep1(genero);
        ArrayList<String> Lista_nombres = new ArrayList();
        ArrayList<Integer> Lista_totales = new ArrayList();
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < lista_compra_total.size(); i++) {
            if (i % 2 == 0) {
                Lista_nombres.add(lista_compra_total.get(i));
            } else {
                Lista_totales.add(Integer.parseInt(lista_compra_total.get(i)));
            }
        }
        for (int j = 0; j < Lista_nombres.size(); j++) {
            data.setValue(Lista_nombres.get(j), Lista_totales.get(j));
        }

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
                "Ventas Discos Musica\n " + genero,
                data,
                true,
                true,
                true);

        panel.removeAll();
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setBounds(10, 10, 454, 342);
        panel.add(chartpanel);
        panel.repaint();
    }
    //Graph the report information 4
    public void graficar_rep4(String genero, JPanel panel) {
        Codigo_Reportes cr = new Codigo_Reportes();
        ArrayList<String> lista_compra_total = cr.cod_rep4(genero);
        ArrayList<String> Lista_nombres = new ArrayList();
        ArrayList<Integer> Lista_totales = new ArrayList();
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < lista_compra_total.size(); i++) {
            if (i % 2 == 0) {
                Lista_nombres.add(lista_compra_total.get(i));
            } else {
                Lista_totales.add(Integer.parseInt(lista_compra_total.get(i)));
            }
        }
        for (int j = 0; j < Lista_nombres.size(); j++) {
            data.setValue(Lista_nombres.get(j), Lista_totales.get(j));
        }

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
                "Ventas Discos Peliculas\n " + genero,
                data,
                true,
                true,
                true);

        panel.removeAll();
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setBounds(10, 10, 454, 342);
        panel.add(chartpanel);
        panel.repaint();
    }
 //Graph the report information 2
    public void graficar_rep2(JPanel panel,JComboBox combo) {
        Codigo_Reportes cr = new Codigo_Reportes();
        ArrayList<String> Lista_lista_max = cr.rep2_tod_max(combo);
        ArrayList<String> Lista_totales = new ArrayList();
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < Lista_lista_max.size(); i+=3) {
            if (!Lista_lista_max.get(i).equals("Sin Nombre")) {
                Lista_totales.add(Lista_lista_max.get(i));
                Lista_totales.add(Lista_lista_max.get(i+1));
                Lista_totales.add(Lista_lista_max.get(i+2));
            }
            
        }
        for (int j = 0; j < Lista_totales.size(); j+=3) {
            data.setValue(Lista_totales.get(j), Integer.parseInt(Lista_totales.get(j+1)));
        }

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
                "Compras Usuario Discos Musica\n ",
                data,
                true,
                true,
                true);

        panel.removeAll();
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setBounds(10, 10, 454, 342);
        panel.add(chartpanel);
        panel.repaint();
    }
    
     //Graph the report information 5
    public void graficar_rep5(JPanel panel,JComboBox combo) {
        Codigo_Reportes cr = new Codigo_Reportes();
        ArrayList<String> Lista_lista_max = cr.rep2_tod_max_pel(combo);
        ArrayList<String> Lista_totales = new ArrayList();
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < Lista_lista_max.size(); i+=3) {
            if (!Lista_lista_max.get(i).equals("Sin Nombre")) {
                Lista_totales.add(Lista_lista_max.get(i));
                Lista_totales.add(Lista_lista_max.get(i+1));
                Lista_totales.add(Lista_lista_max.get(i+2));
            }
            
        }
        for (int j = 0; j < Lista_totales.size(); j+=3) {
            data.setValue(Lista_totales.get(j), Integer.parseInt(Lista_totales.get(j+1)));
        }

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
                "Compras Usuario Discos Musica\n ",
                data,
                true,
                true,
                true);

        panel.removeAll();
        ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setBounds(10, 10, 454, 342);
        panel.add(chartpanel);
        panel.repaint();
    }
}
