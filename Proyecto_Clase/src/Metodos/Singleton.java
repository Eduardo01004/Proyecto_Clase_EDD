/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Cubo.Eje_Z;
import Lista_Simple.Lista_Usuarios;
import Matriz.Matriz;

/**
 *
 * @author Eduardo
 */
public class Singleton {
    public static Lista_Usuarios users = new Lista_Usuarios();
    public static Matriz matriz = new Matriz();
    public static Eje_Z fecha = new Eje_Z();
    
    private static String date = "";
    private static String user = "";

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Singleton.date = date;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Singleton.user = user;
    }

    
    
    
    
    
    
}
