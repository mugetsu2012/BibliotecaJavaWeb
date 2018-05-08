/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Utiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Douglas
 */
public class UtilesGenerales {
    
    public static String getFechaActual(){
         //Get current date time
        LocalDateTime now = LocalDateTime.now();        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);
        
        return formatDateTime;
    }
}
