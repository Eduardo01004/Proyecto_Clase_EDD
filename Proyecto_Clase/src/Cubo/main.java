/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubo;

/**
 *
 * @author Eduardo
 */
public class main {
    public  static void main(String[] args)  {
        Eje_Z cubo = new Eje_Z();
        
        cubo.Insertar("1/2/3");
        
        Nodo_EjeZ aux = cubo.Buscar("1/2/3");
        if(aux != null){
            //aux.matriz.Insertar(1, 3, "pasta");
            //aux.matriz.Insertar(2, 3, "Cola");
            //aux.matriz.Graficar();
        }
       
    }
    
}
