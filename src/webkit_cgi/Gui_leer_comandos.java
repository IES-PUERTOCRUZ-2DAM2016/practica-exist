/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webkit_cgi;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author daw
 */
public class Gui_leer_comandos extends javax.swing.JDialog {
    public I_webkits i_webkit = null;
    /** Creates new form Gui_leer_urls */
    public Gui_leer_comandos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Image getIconImage() {
        // Modificar la propiedad IconImage->Custom Code: getIconImage()
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Class clase = this.getClass();
        URL url = clase.getResource("/recursos/base_webkit.png");
        Image icon = toolkit.getImage(url);
        return icon;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_principal = new javax.swing.JPanel();
        jTextField_url = new javax.swing.JTextField();
        jButton_ir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escriba el comando que ejecutar");
        setIconImage(getIconImage());

        jPanel_principal.setPreferredSize(new java.awt.Dimension(500, 55));

        jTextField_url.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_urlActionPerformed(evt);
            }
        });

        jButton_ir.setText("Ir");
        jButton_ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_irActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_principalLayout = new javax.swing.GroupLayout(jPanel_principal);
        jPanel_principal.setLayout(jPanel_principalLayout);
        jPanel_principalLayout.setHorizontalGroup(
            jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_principalLayout.createSequentialGroup()
                .addComponent(jTextField_url, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ir))
        );
        jPanel_principalLayout.setVerticalGroup(
            jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_urlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_urlActionPerformed
        String url_string = jTextField_url.getText();
        ejecutar_comando(url_string);
    }//GEN-LAST:event_jTextField_urlActionPerformed

    private void jButton_irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_irActionPerformed
        String url_string = jTextField_url.getText();
        ejecutar_comando(url_string);

    }//GEN-LAST:event_jButton_irActionPerformed

    public String pasar_texto_a_html (String texto)
    {
        boolean ret = true;
        String resultado = "";
        // Poner c�digo del ejercicio
        return resultado;
    }
    
    public boolean ejecutar_comando(String url_string)
    {
        boolean ret = true;
        // Poner c�digo del ejercicio
        return ret;
    }
    
    public synchronized boolean poner_error (String error)
    {
        boolean ret = true;       
        if (error != null && ! error.isEmpty ()) {
            int tam = error.length();
            if (tam > 150) {
                tam = 150;
            }
            JOptionPane.showMessageDialog(null,
              error.substring(0, tam), 
              "Error...",
              JOptionPane.ERROR_MESSAGE);
//            System.exit (-1);           
        }
        return ret;
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
            java.util.logging.Logger.getLogger(Gui_leer_comandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_leer_comandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_leer_comandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_leer_comandos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gui_leer_comandos dialog = new Gui_leer_comandos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ir;
    private javax.swing.JPanel jPanel_principal;
    private javax.swing.JTextField jTextField_url;
    // End of variables declaration//GEN-END:variables

}
