package es.medac.MascotaApp.vistas;

import es.medac.MascotaApp.controller.ConexionBD;
import es.medac.MascotaApp.model.Loggin;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Inicio extends javax.swing.JFrame {
    
    protected Connection conexionBD;
    
    /**
     * Creates new form Inicio
     */
    public Inicio() {
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

        nombreUsuario = new javax.swing.JTextField();
        contraseñaUsuario = new javax.swing.JPasswordField();
        bIniciar = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        jIconUser = new javax.swing.JLabel();
        jIconPassword = new javax.swing.JLabel();
        jTituloBienvenido = new javax.swing.JLabel();
        jFondoInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 170, 30));
        getContentPane().add(contraseñaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 170, 30));

        bIniciar.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        bIniciar.setForeground(new java.awt.Color(255, 255, 255));
        bIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-cerrar-sesión-60.png"))); // NOI18N
        bIniciar.setText("Entrar");
        bIniciar.setContentAreaFilled(false);
        bIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(bIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 150, 40));

        bCerrar.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        bCerrar.setForeground(new java.awt.Color(255, 255, 255));
        bCerrar.setText("Cerrar ");
        bCerrar.setContentAreaFilled(false);
        bCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 150, 40));

        jIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-usuario-60.png"))); // NOI18N
        getContentPane().add(jIconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 50));

        jIconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/icons8-contraseña-60.png"))); // NOI18N
        getContentPane().add(jIconPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, 50));

        jTituloBienvenido.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jTituloBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        jTituloBienvenido.setText("Bienvenido");
        getContentPane().add(jTituloBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        jFondoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img's/cat-8415620_640.jpg"))); // NOI18N
        jFondoInicio.setText("jLabel3");
        getContentPane().add(jFondoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarActionPerformed
        Loggin log1 = new Loggin(nombreUsuario.getText(),contraseñaUsuario.getText());
        if(log1.comprobarUsuario() == true){
            JOptionPane.showMessageDialog(this, "Inicio Correcto");
            conexionBD = new ConexionBD().getConexion();
            setVisible(false);
            Menu m = new Menu();
            m.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Inicio Incorrecto", "Error al Iniciar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bIniciarActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea Salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            dispose();
        }else{
        }
    }//GEN-LAST:event_bCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bIniciar;
    private javax.swing.JPasswordField contraseñaUsuario;
    private javax.swing.JLabel jFondoInicio;
    private javax.swing.JLabel jIconPassword;
    private javax.swing.JLabel jIconUser;
    private javax.swing.JLabel jTituloBienvenido;
    private javax.swing.JTextField nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
