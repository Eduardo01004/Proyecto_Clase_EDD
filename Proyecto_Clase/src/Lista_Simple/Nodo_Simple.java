/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Simple;

/**
 *
 * @author Eduardo
 */
public class Nodo_Simple {
    private String user;
    private Nodo_Simple siguiente;

    public Nodo_Simple(String user) {
        this.user = user;
        this.siguiente = null;
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
    
    
    
    
}
