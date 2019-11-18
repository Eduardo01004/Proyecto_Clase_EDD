/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cubo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Eduardo
 */
public class EjeXY {
    public Cabecera columnaprimero;
    public Cabecera columnaultimo;
    public Cabecera filaprimero;
    public Cabecera filaultimo;

    public EjeXY() {
        this.columnaprimero = null;
        this.columnaultimo = null;
        this.filaprimero = null;
        this.filaultimo = null;
    }
    
    public void existeX(int x,String hora){
        boolean estado=true;
        boolean encontrado=false;
        Cabecera temp=columnaprimero;
        Cabecera  aux;
        if(columnaprimero==null){
           Cabecera nuevo=new Cabecera();
            nuevo.numero=x;
            nuevo.hora=hora;
            nuevo.primero=null;
            nuevo.siguiente=null;
            columnaprimero=nuevo;
            columnaultimo=nuevo;
        }else{
            while(estado==true){
                if(temp!=null){
                    if(temp.numero==x){
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
                nuevo.numero=x;
                nuevo.hora=hora;
                nuevo.primero=null;

                if(x<columnaprimero.numero){
                    nuevo.siguiente=columnaprimero;
                    columnaprimero=nuevo;
                }else if(x>columnaultimo.numero){
                    columnaultimo.siguiente=nuevo;
                    nuevo.siguiente=null;
                    columnaultimo=nuevo;
                }else{
                    temp=columnaprimero;
                    estado=true;
                    while(estado){
                        if(temp.siguiente!=null){
                            if(x<temp.siguiente.numero){
                              estado=false;
                            }else{
                                temp=temp.siguiente;
                            }
                        }else{
                            estado=false;
                        }
                    }
                    aux=temp.siguiente;
                    temp.siguiente=nuevo;
                    nuevo.siguiente=aux;
                }


            }
        }
    }
    
     public void existeY(int y,String Cliente){
       boolean estado=true;
       boolean encontrado=false;
       Cabecera temp=filaprimero;
       Cabecera  auy;
     //----------------------------------Si esta vacia la cabecera--------------------------------------
       if(filaprimero==null){
          Cabecera nuevo=new Cabecera();
           nuevo.primero=null;
           nuevo.numero=y;
           nuevo.producto = Cliente;
           nuevo.siguiente=null;
           filaprimero=nuevo;
           filaultimo=nuevo;
       }else{
           while(estado==true){
               if(temp!=null){
                   if(temp.numero==y){
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
               nuevo.numero=y;
               nuevo.producto=Cliente;
               if(y<filaprimero.numero){
                   nuevo.siguiente=filaprimero;
                   filaprimero=nuevo;
               }else if(y>filaultimo.numero){
                   filaultimo.siguiente=nuevo;
                   nuevo.siguiente=null;
                   filaultimo=nuevo;
               }else{
                   temp=filaprimero;
                   estado=true;
                   while(estado){
                       if(temp.siguiente!=null){
                           if(y<temp.siguiente.numero){
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
     
   public void guardarMatriz(int a, int b,String producto,int cantidad){
        
        Cabecera auxma=columnaprimero;
        Cabecera aux2=filaprimero;
        boolean estado;
        boolean encontrado=false;
        if(auxma!=null){
        while(auxma.numero!=a){
            auxma=auxma.siguiente;
        }
        while(aux2.numero!=b){
            aux2=aux2.siguiente;
        }
       Nodo mat=new Nodo();
       Nodo temp;
        mat.x=a;
        mat.y=b;
        mat.Producto=producto;
        mat.cantidad = cantidad;
        if(auxma.primero==null){
            mat.siguiente=null;
            auxma.primero=mat;
            auxma.ultimo=mat;
        }else{
            Nodo nodoma=auxma.primero;
            estado=true;
            while(estado==true){
                if(nodoma!=null){
                    if(nodoma.y==b){
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
                if(b<auxma.primero.y){
                    mat.anterior=null;
                    mat.siguiente=auxma.primero;
                    auxma.primero.anterior=mat;
                    auxma.primero=mat;
                }else if(b>auxma.ultimo.y){
                    mat.siguiente=null;
                    mat.anterior=auxma.ultimo;
                    auxma.ultimo.siguiente=mat;
                    auxma.ultimo=mat;
                }else{
                    Nodo nodoauxiliar;
                    temp=auxma.primero;
                    estado=true;
                    while(estado){
                        if(temp.siguiente!=null){
                            if(b<temp.siguiente.y){
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
        

        //-----------------------------------posicion en Y-------------------------------------------
        if(aux2.primero==null){
           mat.arriba=null;
           aux2.primero=mat;
           aux2.ultimo=mat;
        }else{
            Nodo nodoma=aux2.primero;
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
            //------------------------------------if de encontrado-----------------------------
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
                    Nodo nodoauxiliar;
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
    
   
   public void Insertar(int x, int y, String producto,String cliente,String hora,int canidad){
       existeX(x, hora);
       existeY(y, cliente);
       guardarMatriz(x, y, producto,canidad);   
   }
   
   public Nodo Buscar(int x, int y){
       Cabecera aux=columnaprimero;
       boolean encontrado=false;
       while(aux != null){
           if(aux.numero == x ){
              encontrado=true;
              break;  
            }
           aux=aux.siguiente;
        }
        if(encontrado){
            Nodo nodo=aux.primero;
            while(nodo != null){
                if(nodo.y == y){
                    return nodo;
                }
                nodo=nodo.siguiente;
            }
        }
        return null;
   }
   
   public void Graficar(){
       FileWriter fichero = null;
       PrintWriter pw = null;
       try{
           fichero = new FileWriter("MatrizVentas.dot");
           pw = new PrintWriter(fichero);
           Cabecera aux2=columnaprimero;
           Cabecera aux=filaprimero;
           pw.println("digraph G{");
           pw.println("node [shape = box]");
           pw.println("raiz[label=\"Matriz\"  group=1];");
           if (aux != null){
               while(aux != null){
                   pw.println(aux.hashCode()+" [label=\""+aux.producto+"\" group = 1];");
                   aux=aux.siguiente;
               }
               aux=filaprimero;
               while(aux != null){
                   if(aux.siguiente != null){
                       pw.println(aux.hashCode()+"->"+aux.siguiente.hashCode()+"[dir=both];");
                   }
                   aux=aux.siguiente;
               }
               
               while(aux2 != null){
                   int level = aux2.numero + 2;
                   pw.println(aux2.hashCode()+" [label=\""+aux2.hora+"\" group = " +level+"];");
                   aux2=aux2.siguiente;
               }
               aux2=columnaprimero;
               while(aux2 != null){
                   if(aux2.siguiente != null){
                       pw.println(aux2.hashCode()+"->"+aux2.siguiente.hashCode()+"[dir=both];");
                   }
                   aux2=aux2.siguiente;
               }              
               aux=filaprimero;
               aux2=columnaprimero;
               pw.println("raiz ->"+aux.hashCode());
               pw.println("raiz ->"+aux2.hashCode());
               pw.println("{ rank  = same; raiz ");
               while(aux2 != null){
                   pw.println(aux2.hashCode()+";");
                   aux2=aux2.siguiente;
               }
               pw.println("}");
               aux2=columnaprimero;
               while(aux2 != null){
                   int level = aux2.numero + 2;
                   Nodo temp=aux2.primero;
                   if(temp != null){
                       while(temp != null){
                           pw.println(temp.hashCode()+" [style=filled,fillcolor=seashell2,label= \""+"Producto: "+temp.Producto+"&#92;n Cantidad: "
                                   +temp.cantidad+"\" group = "+level+" ];");
                           temp=temp.siguiente;
                       }
                   }
                   aux2=aux2.siguiente;
               }
               aux=filaprimero;
               while(aux != null){
                   Nodo temp=aux.primero;
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
               aux2=columnaprimero;
               while(aux2 != null){
                   Nodo temp = aux2.primero;
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
           String fileInputPath = "MatrizVentas.dot";
           String fileOutPath = "MatrizVentas.jpg";
           String tParam = "-Tjpg";
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
