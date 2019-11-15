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
public class Lista_Usuarios {
    public Nodo_Simple primero;

    public Lista_Usuarios() {
        this.primero = null;
    }
    public boolean esVacia(){
	return primero == null;
    }
    
    public void Insertar(String nombre,String apellido, String password){
        Nodo_Simple nuevo = new Nodo_Simple(nombre,apellido,password);
        if (esVacia()){
            primero = nuevo;
        }else{
            Nodo_Simple aux = primero;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            
        }   
    }
    
    public Nodo_Simple Buscar(String nombre){
        Nodo_Simple aux = primero;
        while(aux != null){
            if(aux.getUser().compareTo(nombre) == 0)return aux;
            aux = aux.getSiguiente();
        }
        return null;
    }
    public Nodo_Simple Loguin(String nombre, String password){
        Nodo_Simple aux = primero;
        while(aux != null){
            if(aux.getUser().compareTo(nombre) == 0 && aux.getPassword().compareTo(password) == 0)return aux;
            aux = aux.getSiguiente();
        }
        return null;
    }
    
}
