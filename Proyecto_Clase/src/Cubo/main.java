/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubo;

import Matriz.Matriz;
import Matriz.NodoMatriz;

/**
 *
 * @author Eduardo
 */
public class main {
    public  static void main(String[] args)  {
        Eje_Z cubo = new Eje_Z();
        Matriz mat = new Matriz();
        
        cubo.Insertar("1/2/3");
        cubo.Insertar("16464");
        cubo.Insertar("1/2/3");
        cubo.Mostrar();
        mat.Insertar(1, "Embutido","huevos", 15, 1);
        mat.Insertar(2, "Dulces","snickers", 20, 8);
        mat.Insertar(3, "Bebida","Coca", 12, 3);
        mat.Insertar(4, "Limpieza","Asistin", 10, 2.50);
        mat.Graficar();
        Nodo_EjeZ aux = cubo.Buscar("1/2/3");
        if(aux != null){
            aux.matriz.Insertar( "Chino", "10:10");
            aux.matriz.Graficar();
            
            Nodo temp = aux.matriz.Buscar("Chino");
            if(aux != null ){
               temp.pila.Insertar("huevos",1,46.6 );
               temp.pila.Insertar("Leche",2,1.0 );
               temp.pila.Insertar("pan",12,1 );
               temp.pila.Graficar();
               mat.Cantidad_Productos("huevos",5);
            }else{
                System.out.println("NO se encuentra el dato");
            }
            
            
        }
       
    }
    
}
