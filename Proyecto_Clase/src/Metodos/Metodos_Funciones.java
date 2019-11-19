/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.File;
import java.io.FileInputStream;

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
    
}
