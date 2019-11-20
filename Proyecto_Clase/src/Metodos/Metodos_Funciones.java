/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 *
 * @author Eduardo
 */
public class Metodos_Funciones {
    
    
    File archivo;
    FileInputStream entrada;
    
    public byte[] Imagen(File Archivo){
        byte[] img = new byte[1024*10000];
        try{
        entrada = new FileInputStream(Archivo);
        entrada.read(img);
        }catch(Exception x){
            
        }
        return img;  
    }
    
    public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
    
    
}
    
}
