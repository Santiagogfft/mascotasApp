/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.medac.MascotaApp.vistas;
import es.medac.MascotaApp.controller.ConexionBD;
import es.medac.MascotaApp.controller.Consultas;
import es.medac.MascotaApp.model.Mascotas;
import es.medac.MascotaApp.model.Pesos;
import es.medac.MascotaApp.model.Vacunas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Menu extends javax.swing.JFrame {
    private Connection conexionBD;
    /**
     * Creates new form Menu
     */
    public Menu() {
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

        menuConquistar = new javax.swing.JButton();
        jInformación = new javax.swing.JLabel();
        InsertarMascota = new javax.swing.JButton();
        ModificarMascota = new javax.swing.JButton();
        EliminarMascota = new javax.swing.JButton();
        jMásOpciones = new javax.swing.JLabel();
        MascotaEspecifica = new javax.swing.JButton();
        topPesadas = new javax.swing.JToggleButton();
        topVacunadas = new javax.swing.JButton();
        menuCerrarSesion = new javax.swing.JButton();
        menuSalir = new javax.swing.JButton();
        topLivianas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoMenu = new javax.swing.JTable();
        limpiarTabla = new javax.swing.JButton();
        jLimpiarTabla = new javax.swing.JLabel();
        jFondoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(897, 551));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuConquistar.setBackground(new java.awt.Color(0, 153, 153));
        menuConquistar.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        menuConquistar.setText("CONSULTAR ");
        menuConquistar.setContentAreaFilled(false);
        menuConquistar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuConquistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConquistarActionPerformed(evt);
            }
        });
        getContentPane().add(menuConquistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 210, 50));

        jInformación.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jInformación.setForeground(new java.awt.Color(0, 153, 153));
        jInformación.setText("INFORMACION ");
        getContentPane().add(jInformación, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 290, 30));

        InsertarMascota.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        InsertarMascota.setForeground(new java.awt.Color(0, 102, 102));
        InsertarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-insertar-80.png"))); // NOI18N
        InsertarMascota.setText("Insertar mascota");
        InsertarMascota.setBorder(null);
        InsertarMascota.setBorderPainted(false);
        InsertarMascota.setContentAreaFilled(false);
        InsertarMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InsertarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarMascotaActionPerformed(evt);
            }
        });
        getContentPane().add(InsertarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 210, 60));

        ModificarMascota.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        ModificarMascota.setForeground(new java.awt.Color(0, 102, 102));
        ModificarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-modificar-80.png"))); // NOI18N
        ModificarMascota.setText("Modificar mascota");
        ModificarMascota.setContentAreaFilled(false);
        ModificarMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModificarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarMascotaActionPerformed(evt);
            }
        });
        getContentPane().add(ModificarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 240, 60));

        EliminarMascota.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        EliminarMascota.setForeground(new java.awt.Color(0, 102, 102));
        EliminarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-eliminar-80.png"))); // NOI18N
        EliminarMascota.setText("Eliminar mascota");
        EliminarMascota.setContentAreaFilled(false);
        EliminarMascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EliminarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarMascotaActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 230, 60));

        jMásOpciones.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jMásOpciones.setForeground(new java.awt.Color(0, 153, 153));
        jMásOpciones.setText("MAS OPCIONES");
        getContentPane().add(jMásOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 160, 30));

        MascotaEspecifica.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        MascotaEspecifica.setForeground(new java.awt.Color(0, 102, 102));
        MascotaEspecifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-enlace-externo-80.png"))); // NOI18N
        MascotaEspecifica.setText("Consulta especifica");
        MascotaEspecifica.setContentAreaFilled(false);
        MascotaEspecifica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MascotaEspecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MascotaEspecificaActionPerformed(evt);
            }
        });
        getContentPane().add(MascotaEspecifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 250, 60));

        topPesadas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        topPesadas.setForeground(new java.awt.Color(0, 102, 102));
        topPesadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-arriba-círculo-80.png"))); // NOI18N
        topPesadas.setText("Top mascotas pesadas");
        topPesadas.setContentAreaFilled(false);
        topPesadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topPesadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topPesadasActionPerformed(evt);
            }
        });
        getContentPane().add(topPesadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 260, 60));

        topVacunadas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        topVacunadas.setForeground(new java.awt.Color(0, 102, 102));
        topVacunadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-arriba-círculo-80.png"))); // NOI18N
        topVacunadas.setText("Top mascotas vacunadas");
        topVacunadas.setContentAreaFilled(false);
        topVacunadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topVacunadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topVacunadasActionPerformed(evt);
            }
        });
        getContentPane().add(topVacunadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 280, 60));

        menuCerrarSesion.setBackground(new java.awt.Color(0, 153, 153));
        menuCerrarSesion.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        menuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-cerrar-sesión-60.png"))); // NOI18N
        menuCerrarSesion.setText("CERRAR SESION");
        menuCerrarSesion.setContentAreaFilled(false);
        menuCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(menuCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuSalir.setBackground(new java.awt.Color(0, 153, 153));
        menuSalir.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-cerrar-sesión-60.png"))); // NOI18N
        menuSalir.setText("SALIR");
        menuSalir.setContentAreaFilled(false);
        menuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        getContentPane().add(menuSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        topLivianas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        topLivianas.setForeground(new java.awt.Color(0, 102, 102));
        topLivianas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-arriba-círculo-80.png"))); // NOI18N
        topLivianas.setText("Top mascotas mas livianas");
        topLivianas.setContentAreaFilled(false);
        topLivianas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topLivianas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topLivianasActionPerformed(evt);
            }
        });
        getContentPane().add(topLivianas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, 60));

        infoMenu.setEnabled(false);
        infoMenu.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(infoMenu);
        infoMenu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 880, 210));

        limpiarTabla.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        limpiarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-limpiar-80.png"))); // NOI18N
        limpiarTabla.setContentAreaFilled(false);
        limpiarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarTablaActionPerformed(evt);
            }
        });
        getContentPane().add(limpiarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, 60));

        jLimpiarTabla.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLimpiarTabla.setForeground(new java.awt.Color(0, 153, 153));
        jLimpiarTabla.setText("LIMPIAR TABLA");
        getContentPane().add(jLimpiarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, -1, -1));

        jFondoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/HuellasF.jpg"))); // NOI18N
        jFondoMenu.setMaximumSize(new java.awt.Dimension(897, 551));
        jFondoMenu.setMinimumSize(new java.awt.Dimension(897, 551));
        jFondoMenu.setPreferredSize(new java.awt.Dimension(897, 551));
        getContentPane().add(jFondoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuConquistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConquistarActionPerformed
        try {
            // TODO add your handling code here:
            infoMenu();
            //infoMenu.setText(mn.info()+pn.info()+vn.info());
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menuConquistarActionPerformed

    private void ModificarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarMascotaActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        ModificarMascota m1 = new ModificarMascota();
        m1.setVisible(true);
    }//GEN-LAST:event_ModificarMascotaActionPerformed

    private void EliminarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarMascotaActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        EliminarMascota m1 = new EliminarMascota();
        m1.setVisible(true);
    }//GEN-LAST:event_EliminarMascotaActionPerformed

    private void InsertarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarMascotaActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        InsertarMascota m1 = new InsertarMascota();
        m1.setVisible(true);
    }//GEN-LAST:event_InsertarMascotaActionPerformed

    private void MascotaEspecificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MascotaEspecificaActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        consultaEspMascota m1 = new consultaEspMascota();
        m1.setVisible(true);
    }//GEN-LAST:event_MascotaEspecificaActionPerformed

    private void topVacunadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topVacunadasActionPerformed
        // TODO add your handling code here:
        Consultas c1 = new Consultas();
        tops(c1.top5vacunados, "VACUNAS");   
    }//GEN-LAST:event_topVacunadasActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        // TODO add your handling code here:
        setVisible (false);
        Inicio m1 = new Inicio();
        m1.setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void topLivianasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topLivianasActionPerformed
        // TODO add your handling code here:
        Consultas c1 = new Consultas();
        tops(c1.top5livianos, "PESO");
      
    }//GEN-LAST:event_topLivianasActionPerformed

    private void limpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarTablaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("");
        infoMenu.setModel(model);
    }//GEN-LAST:event_limpiarTablaActionPerformed

    private void topPesadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topPesadasActionPerformed
        // TODO add your handling code here:
        Consultas c1 = new Consultas();
        tops(c1.top5pesados, "PESO");
    }//GEN-LAST:event_topPesadasActionPerformed
    
    private void infoMenu() throws SQLException{
        String sql = "SELECT * FROM mascotas;";
        Statement st;
        conexionBD = new ConexionBD().getConexion();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };      
        model.addColumn("ID MASCOTA");
        model.addColumn("ID CLIENTE");
        model.addColumn("ALIAS");
        model.addColumn("ESPECIE");
        model.addColumn("RAZA");
        model.addColumn("COLOR PELO");
        model.addColumn("FECHA NACIMIENTO");
        model.addColumn("VACUNAS");
        infoMenu.setModel(model);
        
        String [] datos = new String [8];
        try{
            st = conexionBD.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                model.addRow(datos);
            }           
        }catch(SQLException e){
                    System.out.println(e.toString());
                    }
        finally{
            conexionBD.close();
        }
    }
    private void tops(String sql, String columna){
        String consulta = sql;
        Statement st;
        conexionBD = new ConexionBD().getConexion();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };      
        model.addColumn("ID MASCOTA");
        model.addColumn("ID CLIENTE");
        model.addColumn("ALIAS");
        model.addColumn(columna);
        infoMenu.setModel(model);
        
        String [] datos = new String [8];
        try{
            st = conexionBD.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                model.addRow(datos);
            }
            st.close();
        }catch(SQLException e){
                    System.out.println(e.toString());
                    }
        finally{
            try {
                conexionBD.close();
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarMascota;
    private javax.swing.JButton InsertarMascota;
    private javax.swing.JButton MascotaEspecifica;
    private javax.swing.JButton ModificarMascota;
    public javax.swing.JTable infoMenu;
    private javax.swing.JLabel jFondoMenu;
    private javax.swing.JLabel jInformación;
    private javax.swing.JLabel jLimpiarTabla;
    private javax.swing.JLabel jMásOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarTabla;
    private javax.swing.JButton menuCerrarSesion;
    private javax.swing.JButton menuConquistar;
    private javax.swing.JButton menuSalir;
    private javax.swing.JButton topLivianas;
    private javax.swing.JToggleButton topPesadas;
    private javax.swing.JButton topVacunadas;
    // End of variables declaration//GEN-END:variables
}