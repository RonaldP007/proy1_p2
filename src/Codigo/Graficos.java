package Codigo;

import Objetos.Dato_Compras;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Graficos {

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
    //Graph the report information 3 and 6
    public void graficar_rep3(JPanel panel,String fecha1,String fecha2,ArrayList<Dato_Compras> lista) {
        DefaultPieDataset data = new DefaultPieDataset();
        for (Iterator<Dato_Compras> iterator = lista.iterator(); iterator.hasNext();) {
            Dato_Compras next = iterator.next();
           data.setValue(next.getNombre_Articulo(),next.getCantidad_Comprado());
           
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Ventas x Fecha x Discos\n ",
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
