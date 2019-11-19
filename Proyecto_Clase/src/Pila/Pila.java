/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Eduardo
 */
public class Pila {
    public NodoPila primero;
    public NodoPila ultimo;
    public double total;
    
    public double suma;

    public Pila() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public void Insertar(String producto,double cantidad,double precio){
        NodoPila nuevo= new NodoPila(producto,cantidad,precio);
        if(primero == null){
            primero = nuevo;
            nuevo.setSiguiente(null);
            ultimo = primero;
        }
        else{
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
            
    }
    public double Mostrar(){
        double a;
        NodoPila aux=primero;
        if(aux != null){
            while(aux != null){
                suma = aux.getCantidad()*aux.getPrecio();
                total=total+suma;
                System.out.println(aux.getProducto() + " "+ aux.getCantidad());
                aux=aux.getSiguiente();
            }
        }
        
        a = total;
        return a;
    }
    
    public void Graficar(){
        FileWriter fw = null;
        PrintWriter pw = null;
        double tot=Mostrar();
        try{
            fw = new FileWriter("Factura.dot");
            pw = new PrintWriter(fw);
            pw.println("digraph G{ rankdir=LR;");
            pw.println("node [shape= record, width=.1,height=.1];\n");
            pw.println("nodeTable [label = \" ");
            NodoPila aux = primero;
            if (aux != null){
                while(aux != null){
                    
                    if (aux.getSiguiente() != null){
                        pw.println("Total: "+ tot+"|"+"Producto: "+aux.getProducto()+"&#92;n Cantidad: "+aux.getCantidad()+"&#92;n Precio:" +aux.getPrecio());
                    }
                    else{
                        pw.println("Total: "+tot +"|"+"Producto: "+aux.getProducto()+"&#92;n Cantidad: "+aux.getCantidad()+"&#92;n Precio:" +aux.getPrecio());
                    }
                    aux = aux.getSiguiente();
                }
                
            }
            pw.println("\"];");
            pw.println("}");
            pw.close();
            String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath =  "Factura.dot";
            String fileOutPath = "Factura.png";
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
        }catch(Exception e){
        }
    }
    
    
    
}
