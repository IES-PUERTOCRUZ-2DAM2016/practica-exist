/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gui_webkit_cgis.java
 *
 * Created on 24-ene-2017, 10:55:45
 */
package webkit_cgi;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Emilio
 */
public class Gui_webkit_cgis extends javax.swing.JFrame implements I_webkits {
    Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi = null;
    Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi_1 = null;

    public Gui_webkit_cgis() {
        initComponents();
        gui_internalframe_webkit_cgi = new Gui_internalframe_webkit_cgis ();
        this.jDesktopPane_salida_estandar.add(gui_internalframe_webkit_cgi);
        gui_internalframe_webkit_cgi.setVisible(true);
        try {
              gui_internalframe_webkit_cgi.setMaximum(true);
        } catch (Exception e) {
            String mensaje = e.getMessage ();
            if (mensaje == null) {
                mensaje = "";
            }
            poner_error ("Error al maximizar marco interno. " + mensaje);
        }
        gui_internalframe_webkit_cgi_1 = new Gui_internalframe_webkit_cgis ();
        this.jDesktopPane_salida_error.add(gui_internalframe_webkit_cgi_1);
        gui_internalframe_webkit_cgi_1.setVisible(true);
        try {
              gui_internalframe_webkit_cgi_1.setMaximum(true);
        } catch (Exception e) {
            String mensaje = e.getMessage ();
            if (mensaje == null) {
                mensaje = "";
            }
            poner_error ("Error al maximizar marco interno. " + mensaje);
        }
    }
    
    @Override
    public Image getIconImage ()
    {
        // Modificar la propiedad de Frame: iconimage -> Llamada a mï¿½todo: getIconImage ()
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Class clase = this.getClass();
        URL url = clase.getResource("/recursos/base_webkit.png");
        Image icon = toolkit.getImage(url);
        return icon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_principal = new javax.swing.JScrollPane();
        jTabbedPane_principal = new javax.swing.JTabbedPane();
        jDesktopPane_salida_estandar = new javax.swing.JDesktopPane();
        jDesktopPane_salida_error = new javax.swing.JDesktopPane();
        jMenuBar_superior = new javax.swing.JMenuBar();
        jMenu_accion = new javax.swing.JMenu();
        jMenu_acerca_de = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uso de Webkit con Swing para ejecutar aplicaciones");
        setIconImage(getIconImage());

        jTabbedPane_principal.setName(""); // NOI18N
        jTabbedPane_principal.setPreferredSize(new java.awt.Dimension(435, 555));

        jDesktopPane_salida_estandar.setBackground(getBackground());
        jDesktopPane_salida_estandar.setAutoscrolls(true);
        jDesktopPane_salida_estandar.setPreferredSize(new java.awt.Dimension(435, 555));
        jTabbedPane_principal.addTab("Salida estándar", jDesktopPane_salida_estandar);

        jDesktopPane_salida_error.setBackground(getBackground());
        jDesktopPane_salida_error.setAutoscrolls(true);
        jDesktopPane_salida_error.setPreferredSize(new java.awt.Dimension(435, 555));
        jTabbedPane_principal.addTab("Salida de error", jDesktopPane_salida_error);

        jScrollPane_principal.setViewportView(jTabbedPane_principal);
        jTabbedPane_principal.getAccessibleContext().setAccessibleName("multi_panel");

        jMenu_accion.setMnemonic('I');
        jMenu_accion.setText("Introducir comando");
        jMenu_accion.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu_accionMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar_superior.add(jMenu_accion);

        jMenu_acerca_de.setMnemonic('c');
        jMenu_acerca_de.setText("Acerca de");
        jMenu_acerca_de.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu_acerca_deMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        jMenuBar_superior.add(jMenu_acerca_de);

        setJMenuBar(jMenuBar_superior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu_accionMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu_accionMenuSelected
        Gui_leer_comandos gui_leer_url = new Gui_leer_comandos (this, false);
        gui_leer_url.i_webkit = this;
        gui_leer_url.setVisible(true);
    }//GEN-LAST:event_jMenu_accionMenuSelected

    private void jMenu_acerca_deMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu_acerca_deMenuSelected
        try {
            String texto = "";
            Class clase = this.getClass();
            URL url = clase.getResource("/recursos/acerca_de.html");
            File file = new File (url.toURI());
            FileInputStream fileinputstream = new FileInputStream(file);
            long tam = file.length();
            int tam_int = (int) tam;
            int leido = 0;
            byte [] cadena_char = new byte [tam_int];
            while (true) {
                leido = leido + fileinputstream.read(cadena_char, 0, tam_int);
                texto = texto + new String(cadena_char, "UTF-8");
                if (leido >= tam) {
                    break;
                } else if (leido < 0) {
                    break;
                }
            }
            this.cargar_texto(texto, 0);
        } catch (Exception e) {
            String mensaje = e.getMessage ();
            if (mensaje == null) {
                mensaje = "";
            }
            poner_error ("Error al acceder a un recurso. " + mensaje);
        }
    }//GEN-LAST:event_jMenu_acerca_deMenuSelected

    @Override
    public void cargar_texto(final String texto, int indice)
    {
        if (indice == 0) {
            if (gui_internalframe_webkit_cgi != null) {
                gui_internalframe_webkit_cgi.cargar_texto(texto);
            }        
        } else if (indice == 1) {
            if (gui_internalframe_webkit_cgi_1 != null) {
                gui_internalframe_webkit_cgi_1.cargar_texto(texto);
            }        
        }
    }
    
    @Override
    public void cargar_url(final String url, int indice)
    {
        if (indice == 0) {
            if (gui_internalframe_webkit_cgi != null) {
                gui_internalframe_webkit_cgi.cargar_url(url);
            }        
        } else if (indice == 1) {
            if (gui_internalframe_webkit_cgi_1 != null) {
                gui_internalframe_webkit_cgi_1.cargar_url(url);
            }        
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_webkit_cgis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_webkit_cgis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_webkit_cgis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_webkit_cgis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_webkit_cgis().setVisible(true);
            }
        });
    }
    
     /**
     * Presentar un mensaje de error en un JOptionPane
     * @param error Mensaje de error.
     * @return true si no hay error, false si ha habido algÃºn error.
     */
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane_salida_error;
    private javax.swing.JDesktopPane jDesktopPane_salida_estandar;
    private javax.swing.JMenuBar jMenuBar_superior;
    private javax.swing.JMenu jMenu_accion;
    private javax.swing.JMenu jMenu_acerca_de;
    private javax.swing.JScrollPane jScrollPane_principal;
    private javax.swing.JTabbedPane jTabbedPane_principal;
    // End of variables declaration//GEN-END:variables

}
