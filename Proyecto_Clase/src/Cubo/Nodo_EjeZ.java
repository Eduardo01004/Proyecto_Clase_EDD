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
public class Nodo_EjeZ {
    public String fecha;
    public EjeXY matriz;
    public Nodo_EjeZ siguiente;
    public Nodo_EjeZ atras;

    public Nodo_EjeZ(String fecha) {
        this.fecha = fecha;
        this.siguiente = null;
        this.atras = null;
        this.matriz = new EjeXY();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EjeXY getMatriz() {
        return matriz;
    }

    public void setMatriz(EjeXY matriz) {
        this.matriz = matriz;
    }

    public Nodo_EjeZ getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_EjeZ siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo_EjeZ getAtras() {
        return atras;
    }

    public void setAtras(Nodo_EjeZ atras) {
        this.atras = atras;
    }
    
    
    
    
    
}
