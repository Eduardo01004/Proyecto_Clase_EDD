/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubo;

import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Eje_Z {
    private Nodo_EjeZ primero;
    private Nodo_EjeZ ultimo;

    public Eje_Z() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public void Insertar(String fecha){
        Nodo_EjeZ nuevo = new Nodo_EjeZ(fecha);
        Nodo_EjeZ aux = Buscar(fecha);
        if (aux == null){
            if (primero == null){
                primero = nuevo;
                primero.setSiguiente(null);
                primero.setAtras(null);
                ultimo = primero;
            }
            else{
                ultimo.setSiguiente(nuevo);
                nuevo.setSiguiente(null);
                nuevo.setAtras(ultimo);
                ultimo = nuevo;
            }
        }else{
            System.out.println("Ya existe, No se agrega");
        }
    }
    
    public void Mostrar(){
        Nodo_EjeZ aux = primero;
        if (aux != null){
            while(aux != null){
                System.out.println("Fecha: " +aux.fecha);
                aux = aux.getSiguiente();
            }
        }
    }
    
    public Nodo_EjeZ Buscar(String fecha){
        Nodo_EjeZ aux = primero;
        while(aux != null){
            if (aux.getFecha().compareTo(fecha) == 0){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public Nodo_EjeZ getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo_EjeZ primero) {
        this.primero = primero;
    }

    public Nodo_EjeZ getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo_EjeZ ultimo) {
        this.ultimo = ultimo;
    }
    
    
    
}
