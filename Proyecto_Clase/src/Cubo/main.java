/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubo;

import Matriz.NodoMatriz;

/**
 *
 * @author Eduardo
 */
public class main {
    public  static void main(String[] args)  {
        Eje_Z cubo = new Eje_Z();
        
        cubo.Insertar("1/2/3");
        cubo.Insertar("16464");
        cubo.Insertar("1/2/3");
        cubo.Mostrar();
        Nodo_EjeZ aux = cubo.Buscar("1/2/3");
        if(aux != null){
            aux.matriz.Insertar(1, "Chino", "10:10");
            aux.matriz.Graficar();
            
            Nodo temp = aux.matriz.Buscar("10:10", 1);
            if(aux != null ){
               temp.pila.Insertar("huevos",1,46.6 );
               temp.pila.Insertar("Leche",2,1.0 );
               temp.pila.Insertar("pan",12,1 );
               temp.pila.Graficar();
            }else{
                System.out.println("NO se encuentra el dato");
            }
            
            
        }
       
    }
    
}
