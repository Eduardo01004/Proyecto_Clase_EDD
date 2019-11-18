/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Simple;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

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
        Nodo_Simple aux2 = Buscar(nombre);
        if (aux2 != null){
            if (esVacia()){
                primero = nuevo;
            }else{
                Nodo_Simple aux = primero;
                while(aux.getSiguiente() != null){
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
            }
        }else{
            JOptionPane.showMessageDialog(null, "El usuario "+ nombre +" Ya existe");
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
    
    public void Graficar(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("Lista_Usuarios.dot");
            pw = new PrintWriter(fichero);
            Nodo_Simple aux = primero;
            pw.println("digraph G{");
            if (aux != null){
                while (aux != null){
                    pw.println(aux.hashCode()+"[shape=record, style=filled, fillcolor=seashell2,label=\"Usuario: "+aux.getUser()+  "\"];");
                    if (aux.getSiguiente() != null){
                        pw.println(aux.hashCode()+"->"+aux.getSiguiente().hashCode());
                    }
                    aux = aux.getSiguiente();
                }
            }
            pw.println("}");
            pw.close();
            String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
           String fileInputPath = "Lista_Usuarios.dot";
           String fileOutPath = "Lista_Usuarios.png";
           String tParam = "-Tpng";
           String toParam = "-o";
           String[] cmd = new String[5];
           cmd[0] = doPath;
           cmd[1] = tParam;
           cmd[2] = fileInputPath;
           cmd[3] = toParam;
           cmd[4] = fileOutPath;

           Runtime rt = Runtime.getRuntime();
           rt.exec(cmd);
            
        }catch(Exception e){}
    }
    
}
