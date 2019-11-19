/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

/**
 *
 * @author Eduardo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz matrix = new Matriz();
        
        matrix.Insertar(1,"Liempieza" ,"Jabon",10,1.2);
        matrix.Insertar(2,"Chucheria" ,"Tortrix",10,1.2);
        matrix.Insertar(3,"Liquido" ,"Coca",10,1.2);
        matrix.Insertar(4,"Pastas" ,"ina",10,1.2);
        matrix.Insertar(5,"Atoles" ,"quaker",10,1.2);
        matrix.Insertar(6,"Liempieza" ,"desodorante",10,1.2);
        matrix.Insertar(7,"Liempieza" ,"shampoo",10,1.2);
        
        matrix.Graficar();
    }
    
}
