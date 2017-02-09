/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gui_internalframe_webkit_cgis.java
 *
 * Created on 02-feb-2017, 23:09:28
 */
package webkit_cgi;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.sun.javafx.application.PlatformImpl;
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Emilio
 */
public class Gui_internalframe_webkit_cgis extends javax.swing.JInternalFrame {
    WebView webview;
    JFXPanel jfxpanel;  

    /** Creates new form Gui_internalframe_webkit_cgis */
    public Gui_internalframe_webkit_cgis() {
        initComponents();
        jfxpanel = new JFXPanel();  
        integrar_jfxpanel_en_panel (jPanel_webkit, jfxpanel);
        integrar_webview_en_jfxpanel();
    }

    public Image getIconImage ()
    {
        // Modificar la propiedad de Frame: iconimage -> Llamada a método: getIconImage ()
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Class clase = this.getClass();
        URL url = clase.getResource("/recursos/base_webkit.png");
        Image icon = toolkit.getImage(url);
        return icon;
    }
    public boolean poner_barra_de_progreso_en_webview (final JProgressBar jprogressbar, final int index)
    {
        boolean ret = true;
        final Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi = this;
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                WebView webview_local = gui_internalframe_webkit_cgi.getWebview ();
                WebEngine webengine_local = webview_local.getEngine();
                /**
                 * Capturar un evento de cambio en el porcentaje de progreso en la carga del contenido de una localización URL. 
                 */
                Worker<Void> worker = webengine_local.getLoadWorker();
                ReadOnlyDoubleProperty readonlydoubleproperty = worker.workDoneProperty();
                readonlydoubleproperty.addListener(new ChangeListener<Number>() {
                    /**
                     * Evento de cambio en el porcentaje de proceso de carga de un documento
                     */
                    @Override
                    public void changed(ObservableValue<? extends Number> observablevalue, Number progreso_antiguo, Number progreso_nuevo) {
                        final Number progreso = progreso_nuevo;
                        Platform.runLater(new Runnable() {
//                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                jprogressbar.setValue(progreso.intValue());
                            }
                        });
                    }
                });
            }
        });  
        return ret;
    }

    public boolean poner_barra_de_hiperenlaces_en_webview (final JLabel jLabel_status, final int index)
    {
        boolean ret = true;
        final Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi = this;
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                WebView webview_local = gui_internalframe_webkit_cgi.getWebview ();
                WebEngine webengine_local = webview_local.getEngine();
                /**
                 * Capturar un evento de cambio en los hiperenlaces. 
                 */
                webengine_local.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
                    @Override
                    public void handle(final WebEvent<String> event) {
                        jLabel_status.setText(event.getData());
                    }
                });  
            }
        });  
        return ret;
    }
                
    private boolean integrar_jfxpanel_en_panel (JPanel jPanel_jfxpanel, JFXPanel jfx_panel)
    {
        boolean ret = true;
        jPanel_jfxpanel.setLayout(new BorderLayout());
        jPanel_jfxpanel.add(jfxpanel, BorderLayout.CENTER);
        pack ();
        return ret;
    }

    private boolean integrar_webview_en_jfxpanel ()
    {
        boolean ret = true;
        final Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi = this;
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                try {
                    WebView webview_local = gui_internalframe_webkit_cgi.getWebview ();
                    if (webview_local == null) {
                        webview_local = new WebView();
                        gui_internalframe_webkit_cgi.setWebview (webview_local);
                        webview_local.setContextMenuEnabled(false);
                        JFXPanel jfxpanel = gui_internalframe_webkit_cgi.getJfxpanel ();
                        Scene scene = new Scene(webview_local);
                        jfxpanel.setScene(scene);
                    }
                } catch (Exception e) {
                    String mensaje = e.getMessage();
                    if (mensaje == null) {
                        mensaje = "";
                    }
                    gui_internalframe_webkit_cgi.poner_error ("No se ha podido obtener el visualizador Web. ");
                }
            }
        });  
        return ret;
    }
    
    public synchronized JFXPanel getJfxpanel() {
        return jfxpanel;
    }

    public synchronized WebView getWebview() {
        return webview;
    }

    public synchronized void setWebview(WebView webview) {
        this.webview = webview;
    }

    /**
     * Carga un documento en la aplicación desde una texto
     * @param texto Texto con el contenido del documento que cargar
     */
    public synchronized void cargar_texto(final String texto) 
    {
        final Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi = this;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebView webview = gui_internalframe_webkit_cgi.getWebview ();
                if (webview != null) {
                    WebEngine webengine = webview.getEngine();
                    if (webengine != null) {
                        webengine.loadContent(texto);
                    } else {
                        gui_internalframe_webkit_cgi.poner_error ("No se ha podido obtener el motor Web. ");
                    }
                } else {
                    gui_internalframe_webkit_cgi.poner_error ("No se ha podido obtener el visualizador Web. ");
                }
            }
        });
    }

    public synchronized void cargar_url(final String url) 
    {
        final Gui_internalframe_webkit_cgis gui_internalframe_webkit_cgi = this;
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {  
                String [] error = new String [1];
                String url_tmp = Gui_internalframe_webkit_cgis.conformar_url(url, error);
                if (url_tmp == null) {
                    File file = new File (url);
                    if (file.exists()) {
                        url_tmp = Gui_internalframe_webkit_cgis.conformar_url("file://" + url, error);
                    } else {
                        url_tmp = Gui_internalframe_webkit_cgis.conformar_url("http://" + url, error);
                    }
                }
                if (url_tmp != null) {
                    WebView webview = gui_internalframe_webkit_cgi.getWebview ();
                    if (webview != null) {
                        WebEngine webengine = webview.getEngine();
                        if (webengine != null) {
                            webengine.load(url_tmp);
                        } else {
                            gui_internalframe_webkit_cgi.poner_error ("No se ha podido obtener el motor Web. ");
                        }
                    } else {
                        gui_internalframe_webkit_cgi.poner_error ("No se ha podido obtener el visualizador Web. ");
                    }
                }
            }
        });  
    }

    /**
     * Detectar si una URL es correcta
     * @param str Texto con el que formar la URL 
     * @param error Array cuya posición 0 contiene un mensaje de error, si es que lo ha habido.
     * @return Un texto con la URL conformada, o null si hay algún errro.
     */
    public synchronized static String conformar_url(String str, String [] error) 
    {
        error [0] = "";
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException e) {
            String mensaje = e.getMessage ();
            if (mensaje == null) {
                mensaje = "";
            }
            error [0] = "Error, URL mal formada. " + mensaje;
            return null;
        }
    }

        /**
     * Presentar un mensaje de error en un JOptionPane
     * @param error Mensaje de error.
     * @return true si no hay error, false si ha habido algún error.
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
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_webkit = new javax.swing.JPanel();
        jPanel_inferior = new javax.swing.JPanel();
        jLabel_barra_de_estado = new javax.swing.JLabel();
        jProgressBar_carga = new javax.swing.JProgressBar();

        setAutoscrolls(true);
        setFrameIcon(null);
        setVisible(true);

        jPanel_webkit.setName("salida_estandar"); // NOI18N
        jPanel_webkit.setPreferredSize(new java.awt.Dimension(248, 498));
        jPanel_webkit.setLayout(new java.awt.BorderLayout());

        jPanel_inferior.setPreferredSize(new java.awt.Dimension(503, 19));

        jLabel_barra_de_estado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel_barra_de_estado.setText("Webkit_cgi: ejecutar aplicaciones desde Java");

        javax.swing.GroupLayout jPanel_inferiorLayout = new javax.swing.GroupLayout(jPanel_inferior);
        jPanel_inferior.setLayout(jPanel_inferiorLayout);
        jPanel_inferiorLayout.setHorizontalGroup(
            jPanel_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_inferiorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel_barra_de_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_inferiorLayout.setVerticalGroup(
            jPanel_inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_barra_de_estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jProgressBar_carga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_inferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel_webkit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 517, Short.MAX_VALUE)
                .addComponent(jPanel_inferior, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel_webkit, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGap(22, 22, 22)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_barra_de_estado;
    private javax.swing.JPanel jPanel_inferior;
    private javax.swing.JPanel jPanel_webkit;
    private javax.swing.JProgressBar jProgressBar_carga;
    // End of variables declaration//GEN-END:variables
}
