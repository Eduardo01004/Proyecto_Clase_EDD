/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Matriz {
    public Cabecera firstColum;
    public Cabecera lastColum;
    public Cabecera firstF;
    public Cabecera LastF;
    
    public Matriz() {
        this.LastF=null;
        this.firstColum=null;
        this.firstF=null;
        this.lastColum=null;
    }
    
    public void existeX(int x,String producto,double precio){
        boolean estado=true;
        boolean encontrado=false;
        Cabecera temp=firstColum;
        if(firstColum == null){
            Cabecera nuevo=new Cabecera();
            nuevo.setNumero(x);
            nuevo.dato = producto;
            nuevo.precio = precio;
            nuevo.setPrimero(null);
            nuevo.setSiguiente(null);
            firstColum = nuevo;
            lastColum = nuevo;
        }else{
            while(estado==true){
                if(temp!=null){
                    if(temp.getNumero() == x){
                        estado=false;
                        encontrado=true;
                    }else{
                        temp=temp.siguiente;
                    }
                }else{
                    estado=false;
                    encontrado=false;
                }
            }

            if(encontrado==false){
                Cabecera nuevo=new Cabecera();
                nuevo.setNumero(x);
                nuevo.primero=null;
                nuevo.dato = producto;
                nuevo.precio = precio;
                if(x < firstColum.numero ){
                    nuevo.siguiente=firstColum;
                    firstColum=nuevo;
                }else if(x > lastColum.numero){
                    lastColum.siguiente=nuevo;
                    nuevo.siguiente=null;
                    lastColum=nuevo;
                }else{
                    temp=firstColum ;
                    estado=true;
                    while(estado){
                        if(temp.siguiente!=null){
                            if(x < temp.siguiente.numero){
                              estado=false;
                            }else{
                                temp=temp.siguiente;
                            }
                        }else{
                            estado=false;
                        }
                    }
                    Cabecera aux=temp.siguiente;
                    temp.siguiente=nuevo;
                    nuevo.siguiente=aux;
                }


            }
        }
    }
    public Cabecera BuscarProducto(String producto){
        Cabecera aux = firstColum;
        while(aux != null){
            if (aux.dato.compareTo(producto) == 0){
                return aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public void existeY(String categoria){
       boolean estado=true;
       boolean encontrado=false;
       Cabecera temp=firstF;
       Cabecera  auy;
       if(firstF == null){
          Cabecera nuevo=new Cabecera();
           nuevo.primero=null;
           nuevo.dato=categoria;
           nuevo.siguiente=null;
           firstF = nuevo;
           LastF = nuevo;
       }else{
           while(estado==true){
               if(temp!=null){
                   if(temp.dato.compareTo(categoria) == 0){
                       estado=false;
                       encontrado=true;
                   }else{
                       temp=temp.siguiente;
                   }
               }else{
                   estado=false;
                   encontrado=false;
               }
           }

           if(encontrado==false){
               Cabecera nuevo=new Cabecera();
               nuevo.primero=null;
               nuevo.dato=categoria;
               if(categoria.compareTo(firstF.dato) < 0){
                   nuevo.siguiente=firstF;
                   firstF = nuevo;
               }else if(categoria.compareTo(LastF.dato) > 0){
                   LastF.siguiente=nuevo;
                   nuevo.siguiente=null;
                   LastF=nuevo;
               }else{
                   temp = firstF;
                   estado=true;
                   while(estado){
                       if(temp.siguiente!=null){
                           if(categoria.compareTo(temp.siguiente.dato) < 0){
                             estado=false;
                           }else{
                               temp=temp.siguiente;
                           }
                       }else{
                           estado=false;
                       }
                   }
                   auy=temp.siguiente;
                   temp.siguiente=nuevo;
                   nuevo.siguiente=auy;
               }


           }
       }

   }
    public void guardarMatriz(int a, String b,String producto,double cantidad, double precio){
        
        Cabecera auxma=firstColum;
        Cabecera aux2=firstF;
        boolean estado;
        boolean encontrado=false;
        if(auxma!=null){
        while(auxma.numero!=a){
            auxma=auxma.siguiente;
        }
        while(aux2.dato.compareTo(b) != 0){
            aux2=aux2.siguiente;
        }
        
       NodoMatriz mat=new NodoMatriz(a,b,producto,cantidad,precio);//string curso
       NodoMatriz temp;
        if(auxma.primero==null){
            mat.siguiente=null;
            auxma.primero=mat;
            auxma.ultimo=mat;
        }else{
            NodoMatriz nodoma=auxma.primero;
            estado=true;
            while(estado==true){
                if(nodoma!=null){
                    if(nodoma.y.compareTo(b) == 0){
                        estado=false;
                        encontrado=true;
                    }else{
                        nodoma=nodoma.siguiente;
                    }
                }else{
                    estado=false;
                    encontrado=false;
                }
            }
            if(encontrado==false){
                if(b.compareTo(auxma.primero.y) < 0){
                    mat.atras=null;
                    mat.siguiente=auxma.primero;
                    auxma.primero.atras=mat;
                    auxma.primero=mat;
                }else if( b.compareTo(auxma.ultimo.y) > 0){
                    mat.siguiente=null;
                    mat.atras=auxma.ultimo;
                    auxma.ultimo.siguiente=mat;
                    auxma.ultimo=mat;
                }else{
                    NodoMatriz nodoauxiliar;
                    temp=auxma.primero;
                    estado=true;
                    while(estado){
                        if(temp.siguiente!=null){
                            if(b.compareTo(temp.siguiente.y) < 0){
                              estado=false;
                            }else{
                                temp=temp.siguiente;
                            }
                        }else{
                            estado=false;
                        }
                    }
                    nodoauxiliar=temp.siguiente;
                    temp.siguiente=mat;
                    mat.siguiente=nodoauxiliar;
                }
            }



        }
        if(aux2.primero==null){
           mat.arriba=null;
           aux2.primero=mat;
           aux2.ultimo=mat;
        }else{
            NodoMatriz nodoma=aux2.primero;
            estado=true;
            encontrado=false;
            while(estado==true){
                if(nodoma!=null){
                    if(nodoma.x==a){
                        estado=false;
                        encontrado=true;
                    }else{
                        nodoma=nodoma.arriba;
                    }
                }else{
                    estado=false;
                    encontrado=false;
                }
            }
             if(encontrado==false){
                 if(a<aux2.primero.x){
                     mat.abajo=null;
                     mat.arriba=aux2.primero;
                     aux2.primero.abajo=mat;
                     aux2.primero=mat;
                 }else if(a>aux2.ultimo.x){
                     mat.arriba=null;
                     mat.abajo=aux2.ultimo;
                     aux2.ultimo.arriba=mat;
                     aux2.ultimo=mat;
                 }else{
                    NodoMatriz nodoauxiliar;
                     temp=aux2.primero;
                     estado=true;
                     while(estado){
                         if(temp.arriba!=null){
                             if(a<temp.arriba.x){
                               estado=false;
                             }else{
                                 temp=temp.arriba;
                             }
                         }else{
                             estado=false;
                         }
                     }
                     nodoauxiliar=temp.arriba;
                     temp.arriba=mat;
                     mat.arriba=nodoauxiliar;
                 }

             }

        }
        }
        }
    public NodoMatriz Buscar( String producto){
       Cabecera aux = firstColum;
       boolean encontrado=false;
       while(aux != null){
           if(aux.dato.compareTo(producto) == 0 ){
              encontrado=true;
              break;  
            }
           aux=aux.siguiente;
        }
        if(encontrado){
            NodoMatriz nodo=aux.primero;
            while(nodo != null){
                if(nodo.producto.compareTo(producto) == 0){
                    return nodo;
                }
                nodo=nodo.siguiente;
            }
        }
        return null;
   }
    
    public void Cantidad_Productos(String producto,double cantidad){
        NodoMatriz aux = Buscar(producto);
        if (aux != null){
            if (cantidad > aux.getCantidad()){
                JOptionPane.showMessageDialog(null,"La cantidad que intenta comprar sobrepasa al del inventario");
            }else{
                if (aux.getCantidad() == 0.0){
                    JOptionPane.showMessageDialog(null,"El producto " +producto +" Ya no tiene suministros en inventario");
                }else{
                    aux.setCantidad(aux.getCantidad() - cantidad);
                    Graficar();
                }  
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"El producto no existe");
        }
    }
    
    public void Cantidad(String producto,double cantidad){
        NodoMatriz aux = Buscar(producto);
        if (aux != null){
            aux.setCantidad(aux.getCantidad()+cantidad);
            Graficar();   
        }else{
            JOptionPane.showMessageDialog(null,"El producto no existe");
        }
    }
    public void Insertar(int x,  String categoria,String producto,int cantidad, double precio){
       existeX(x,producto,precio);
       existeY(categoria);
       guardarMatriz(x, categoria, producto,cantidad,precio);   
   }
    
    public void Graficar(){
       FileWriter fichero = null;
       PrintWriter pw = null;
       try{
           fichero = new FileWriter("Matriz_inventario.dot");
           pw = new PrintWriter(fichero);
           Cabecera aux2=firstColum;
           Cabecera aux=firstF;
           pw.println("digraph G{");
           pw.println("node [shape = box]");
           pw.println("raiz[label=\"Matriz\"  group=1];");
           if (aux != null){
               while(aux != null){
                   pw.println(aux.hashCode()+" [label=\""+"Categoria: "+aux.dato+"\" group = 1];");
                   aux=aux.siguiente;
               }
               aux=firstF;
               while(aux != null){
                   if(aux.siguiente != null){
                       pw.println(aux.hashCode()+"->"+aux.siguiente.hashCode()+"[dir=both];");
                   }
                   aux=aux.siguiente;
               }
               
               while(aux2 != null){
                   int level = aux2.numero + 2;
                   pw.println(aux2.hashCode()+" [label=\""+"ID Producto: "+aux2.numero+"&#92;n Producto: "+aux2.dato+"\" group = " +level+"];");
                   aux2=aux2.siguiente;
               }
               aux2=firstColum;
               while(aux2 != null){
                   if(aux2.siguiente != null){
                       pw.println(aux2.hashCode()+"->"+aux2.siguiente.hashCode()+"[dir=both];");
                   }
                   aux2=aux2.siguiente;
               }              
               aux=firstF;
               aux2=firstColum;
               pw.println("raiz ->"+aux.hashCode());
               pw.println("raiz ->"+aux2.hashCode());
               pw.println("{ rank  = same; raiz ");
               while(aux2 != null){
                   pw.println(aux2.hashCode()+";");
                   aux2=aux2.siguiente;
               }
               pw.println("}");
               aux2=firstColum;
               while(aux2 != null){
                   int level = aux2.numero + 2;
                   NodoMatriz temp=aux2.primero;
                   if(temp != null){
                       while(temp != null){
                           pw.println(temp.hashCode()+" [style=filled,fillcolor=seashell2,label= \""+"Producto: "+temp.producto+"&#92;n Cantidad: "+
                                   temp.cantidad+"&#92;n Precio: "+temp.precio+"\" group = "+level+" ];");
                           temp=temp.siguiente;
                       }
                   }
                   aux2=aux2.siguiente;
               }
               aux=firstF;
               while(aux != null){
                   NodoMatriz temp=aux.primero;
                   if(temp != null){
                       pw.println(aux.hashCode()+"->"+temp.hashCode());
                       while(temp.arriba != null){
                           pw.println(temp.hashCode()+"->"+temp.arriba.hashCode()+"[dir=both];");
                           temp=temp.arriba;
                       }
                       pw.println("{ rank = same; "+aux.hashCode()+";");
                       temp=aux.primero;
                       while(temp != null){
                           pw.println(temp.hashCode()+";");
                           temp=temp.arriba;
                       }
                       pw.println("}");
                       
                   }
                   aux=aux.siguiente;
               }
               aux2=firstColum;
               while(aux2 != null){
                   NodoMatriz temp = aux2.primero;
                   if(temp != null){
                       pw.println(aux2.hashCode()+"->"+temp.hashCode()+"[dir=both];");
                       while(temp.siguiente != null){
                           pw.println(temp.hashCode()+"->"+temp.siguiente.hashCode()+"[dir=both];");
                           temp=temp.siguiente;
                       }
                   }
                   aux2=aux2.siguiente;
               }
               
               
           }
           pw.println("}");
           fichero.close();
           String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
           String fileInputPath = "Matriz_inventario.dot";
           String fileOutPath = "Matriz_inventario.png";
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
