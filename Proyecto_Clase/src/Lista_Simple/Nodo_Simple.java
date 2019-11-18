/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Simple;

import Cubo.Eje_Z;

/**
 *
 * @author Eduardo
 */
public class Nodo_Simple {
    private String user;
    private String password;
    private String apellido;
    private Nodo_Simple siguiente;
    public Eje_Z cubo;

    public Nodo_Simple(String user,String apellido, String password) {
        this.user = user;
        this.apellido = apellido;
        this.password = password;
        this.siguiente = null;
        this.cubo = new Eje_Z();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Nodo_Simple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_Simple siguiente) {
        this.siguiente = siguiente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    
}
