/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Admin;

import Vista.Login;
import Vista.cat_mus.Catalogo_musica;
import Vista.cat_peli.Catalogo_peliculas;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class Interfaz_Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_Admnistrador
     */
    public Interfaz_Administrador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnCerrarSesion = new javax.swing.JMenu();
        btnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Opciones de Administrador");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Catalogo de Musica");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Catalogo de Peliculas");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Lista de Compras");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Lista de Pre ordenes");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Reportes");

        jLabel2.setText("Seleccione una opcion:");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrir)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton4))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addGap(18, 18, 18)
                .addComponent(btnAbrir)
                .addGap(56, 56, 56))
        );

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCerrarSesion);

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (jRadioButton1.isSelected()) {
            Catalogo_musica cm = new Catalogo_musica(this, true);
            cm.setVisible(true);
        } else if (jRadioButton2.isSelected()) {
            Catalogo_peliculas cp = new Catalogo_peliculas(this, true);
            cp.setVisible(true);
        } else if (jRadioButton3.isSelected()) {
            int opcion = musica_pelicula();
            if (opcion == 0) {
                Lista_Compras lc = new Lista_Compras(this, true, true);
                lc.setVisible(true);
            } else {
                Lista_Compras lc = new Lista_Compras(this, true, false);
                lc.setVisible(true);
            }
        } else if (jRadioButton4.isSelected()) {
            int opcion = musica_pelicula();
            if (opcion == 0) {
                Lista_Preordenes lc = new Lista_Preordenes(this, true, true);
                lc.setVisible(true);
            } else {
                Lista_Preordenes lc = new Lista_Preordenes(this, true, false);
                lc.setVisible(true);
            }
        } else {
            //reportes
        }

    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        this.dispose();
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JMenu btnCerrarSesion;
    private javax.swing.JMenu btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    // End of variables declaration//GEN-END:variables

    private int musica_pelicula(){
        int seleccion = JOptionPane.showOptionDialog(null,"¿Musica o Pelicula?",
                    "Escoja la opcion que necesite:",JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,null,new Object[]{"Musica","Peliculas"}, 
            "Musica");
            
        return seleccion;
    }
}
