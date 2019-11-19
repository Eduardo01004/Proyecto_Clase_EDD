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
public class Cabecera {
    public Nodo primero;
    public Nodo ultimo;
    public Cabecera siguiente;
    public Cabecera anterior;
    public String cliente;
    public String hora;
    String total;
    public int numero;
    public Cabecera() {
        this.primero = null;
        this.ultimo = null;
        this.siguiente = null;
    }

    

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    
}
