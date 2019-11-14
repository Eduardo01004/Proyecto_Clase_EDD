/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import java.io.FileWriter;
import java.io.PrintWriter;

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
    
    public void existeX(int x, String producto){
        boolean estado=true;
        boolean encontrado=false;
        Cabecera temp=firstColum;
        if(firstColum == null){
            Cabecera nuevo=new Cabecera();
            nuevo.setNumero(x);
            nuevo.setDato(producto);
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
                nuevo.setDato(producto);
                nuevo.primero=null;
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
    
    public void existeY(int y,String producto){
       boolean estado=true;
       boolean encontrado=false;
       Cabecera temp=firstF;
       Cabecera  auy;
       if(firstF == null){
          Cabecera nuevo=new Cabecera();
           nuevo.primero=null;
           nuevo.numero=y;
           nuevo.dato=producto;
           nuevo.siguiente=null;
           firstF = nuevo;
           LastF = nuevo;
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
               nuevo.dato=producto;
               if(y < firstF.numero){
                   nuevo.siguiente=firstF;
                   firstF = nuevo;
               }else if(y > LastF.numero){
                   LastF.siguiente=nuevo;
                   nuevo.siguiente=null;
                   LastF=nuevo;
               }else{
                   temp = firstF;
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
    public void guardarMatriz(int a, int b,String producto){
        
        Cabecera auxma=firstColum;
        Cabecera aux2=firstF;
        boolean estado;
        boolean encontrado=false;
        if(auxma!=null){
        while(auxma.numero!=a){
            auxma=auxma.siguiente;
        }
        while(aux2.numero!=b){
            aux2=aux2.siguiente;
        }
        
       NodoMatriz mat=new NodoMatriz(a,b,producto);//string curso
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
                    mat.atras=null;
                    mat.siguiente=auxma.primero;
                    auxma.primero.atras=mat;
                    auxma.primero=mat;
                }else if(b>auxma.ultimo.y){
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
    
    public void Insertar(int x, int y, String categoria,String producto){
       existeX(x, producto);
       existeY(y, categoria);
       guardarMatriz(x, y, producto);   
   }
    
    public void Graficar(){
       FileWriter fichero = null;
       PrintWriter pw = null;
       try{
           fichero = new FileWriter("Matriz.dot");
           pw = new PrintWriter(fichero);
           Cabecera aux2=firstColum;
           Cabecera aux=firstF;
           pw.println("digraph G{");
           pw.println("node [shape = box]");
           pw.println("raiz[label=\"Matriz\"  group=1];");
           if (aux != null){
               while(aux != null){
                   pw.println(aux.hashCode()+" [label=\""+aux.dato+"\" group = 1];");
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
                   pw.println(aux2.hashCode()+" [label=\""+aux2.dato+"\" group = " +level+"];");
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
                           pw.println(temp.hashCode()+" [style=filled,fillcolor=seashell2,label= \""+temp.producto+"\" group = "+level+" ];");
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
           String fileInputPath = "Matriz.dot";
           String fileOutPath = "Matriz.jpg";
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
