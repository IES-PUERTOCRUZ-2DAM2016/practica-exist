/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webkit_cgi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Esta clase proporciona métodos de clase (estaticos), que tienen <br>
 * como finalidad principal convertir y formatear diversas fuentes de 
 * datos en String
 * @author tabaiba
 */
public class Util {
    
/*
_________________________________________________________________- 
                 ___  _  ___  _      ___  _   __ 
             /\   |  |_)  |  |_) | |  |  / \ (_  
            /--\  |  | \ _|_ |_) |_|  |  \_/ __) 
_________________________________________________________________    

*/

//static final String NAME_OS = System.getProperty("os.name");
    static final String FINAL_LINEA = System.getProperty("line.separator");
  //static final String HOME_DIR = System.getProperty("user.dir");
    


/*
 ___________________________________________________________________________
 __  __ _____ _____ ___  ____   ___  ____  
|  \/  | ____|_   _/ _ \|  _ \ / _ \/ ___| 
| |\/| |  _|   | || | | | | | | | | \___ \ 
| |  | | |___  | || |_| | |_| | |_| |___) |
|_|  |_|_____| |_| \___/|____/ \___/|____/ 
                                           
                                     ____ _____  _  _____ ___ ____ 
                                    / ___|_   _|/ \|_   _|_ _/ ___|
                                    \___ \ | | / _ \ | |  | | |    
                                     ___) || |/ ___ \| |  | | |___ 
                                    |____/ |_/_/   \_\_| |___\____|
___________________________________________________________________________
*/

    
    /**
     *  Ejecuta sobre el sistema operativo un proceso o aplicación.
     * @param proceso La orden, aplicación a ejecutar en el sistema operativo.
     * @return Un objeto Process. que representa el proceso ejecutado.
     * @throws Exception <br>
     * Se genera una Exception si el comando es null, vacio, si no se tienen<br>
     * permisos para ejecutar el comando o aplicación, o si hay un error IO
     */
    public static Process ejecutarProceso(String proceso) throws Exception{
        return Runtime.getRuntime().exec(proceso);
    }
    /**
     * Ejecuta sobre el sistema operativo un proceso o aplicación.
     * @param proceso La orden, aplicación a ejecutar en el sistema operativo.
     * @param esmsdos si es  true se se ejecuta "cmd /c proceso";
     * @return Un objeto Process. que representa el proceso ejecutado.
     * @throws Exception <br>
     * Se genera una Exception si el comando es null, vacio, si no se tienen<br>
     * permisos para ejecutar el comando o aplicación, o si hay un error IO.
     */
    public static Process ejecutarProceso(String proceso,boolean esmsdos) throws Exception{
        Process proc;
        if (esmsdos){
            proc = ejecutarProceso("cmd /c "+proceso);
        }else{
            proc = ejecutarProceso(proceso);
        }
        return proc;
    }
    
    /**
     * Devuelve el contenido de un fichero dentro de un String.
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getStringtoFile(File file) throws FileNotFoundException, IOException{

            InputStream is = new FileInputStream(file);
            return Util.getStringtoInputStream(is);            
    }
    
    /**
     * Crea un String a partir de un InputStream
     * @param datos una fuente de datos tipo InputStream
     * @return un String que representa a la fuente InputStream.
     * @throws IOException 
     */
    public static String getStringtoInputStream(InputStream datos) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(datos));
        String salida,aux;
        
        aux = br.readLine();
        salida = "";
        while (aux!=null){
            salida = salida + aux + Util.FINAL_LINEA;
            aux = br.readLine();
        }
        return new String(salida.getBytes(),"UTF-8");
    }
    
}
