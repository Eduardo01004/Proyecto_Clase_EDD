/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import javax.swing.JComboBox;

/**
 *
 * @author Eduardo
 */
public class Cabecera {
    public Cabecera siguiente;
    public Cabecera anterior;
    public NodoMatriz primero;
    public NodoMatriz ultimo;
    public int numero;
    public String dato;
    public double precio;

    public Cabecera() {
        this.siguiente = null;
        this.anterior = null;
        this.primero = null;
        this.ultimo = null;
    }

    public Cabecera getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Cabecera siguiente) {
        this.siguiente = siguiente;
    }

    public Cabecera getAnterior() {
        return anterior;
    }

    public void setAnterior(Cabecera anterior) {
        this.anterior = anterior;
    }

    public NodoMatriz getPrimero() {
        return primero;
    }

    public void setPrimero(NodoMatriz primero) {
        this.primero = primero;
    }

    public NodoMatriz getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoMatriz ultimo) {
        this.ultimo = ultimo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
    
    
    
    
}
