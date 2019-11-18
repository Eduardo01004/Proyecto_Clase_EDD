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
public class NodoMatriz {
    public int x;
    public int y;
    public String producto;
    public double precio;
    public int cantidad;
    public NodoMatriz siguiente;
    public NodoMatriz atras;
    public NodoMatriz arriba;
    public NodoMatriz abajo;

    public NodoMatriz(int x, int y, String producto,int cantidad, double precio) {
        this.x = x;
        this.y = y;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.abajo = null;
        this.arriba = null;
        this.siguiente = null;
        this.atras = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMatriz getAtras() {
        return atras;
    }

    public void setAtras(NodoMatriz atras) {
        this.atras = atras;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }
    
    
    
    
}
