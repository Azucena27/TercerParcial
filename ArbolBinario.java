/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author Azucena
 */
public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol arbolito = new Arbol();
        arbolito.insertar(30);
        arbolito.insertar(90);
        arbolito.insertar(10);
        arbolito.insertar(12);
        arbolito.insertar(5);
        arbolito.insertar(9);
        arbolito.insertar(24);
        arbolito.encontrar(10);  
        arbolito.inOrder();
        arbolito.borrar(90);        
        arbolito.encontrar(90);
        arbolito.inOrder();
    }
    
    public static class Arbol {

    Nodo raiz = null;

    public void insertar(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            Nodo ant = null;
            while (aux != null) {
                ant = aux;
                if (nuevo.dato > aux.dato) {
                    aux = aux.derecha;
                } else {
                    aux = aux.izquierda;
                }
            }
            if (nuevo.dato > ant.dato) {
                ant.derecha = nuevo;
            } else {
                ant.izquierda = nuevo;
            }

        }
    }
     public Nodo buscar(Nodo raiz, int dato) {
        if (raiz == null || raiz.dato == dato) {
            return raiz;
        }
        if (raiz.dato < dato) {
            return buscar(raiz.derecha, dato);
        }
        return buscar(raiz.izquierda, dato);
    }

    public Nodo buscar(int dato) {
        return buscar(raiz, dato);
    }
    
     public void preOrden() {
        inOrder(raiz);
    }

    public void preOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.dato + " ");
            inOrder(raiz.izquierda);
            inOrder(raiz.derecha);
        }
    } 

    public void inOrder() {
        inOrder(raiz);
    }

    public void inOrder(Nodo raiz) {
        if (raiz != null) {
            inOrder(raiz.izquierda);
            System.out.println(" " + raiz.dato);
            inOrder(raiz.derecha);
        }
    }

    public void postOrder() {
        inOrder(raiz);
    }

    public void postOrder(Nodo raiz) {
        if (raiz != null) {
            inOrder(raiz.izquierda);
            inOrder(raiz.derecha);
            System.out.println(raiz.dato + " ");
        }
    }

    public Nodo borrar(int dato){
        return eliminar(raiz, dato);
    }
    
    public void encontrar(int dato) {
        Nodo aux = buscar(dato);
        if (aux == null) {
            System.out.println("El numero " + dato + " No se encuentra el dato");
        } else {
            System.out.println("El numero " + dato + " Si se encuentra el dato");
        }
    }
    
    public Nodo eliminar(Nodo raiz,int dato) {                
        if (raiz == null) {            
        }else{
            if (dato > raiz.dato) {
                raiz.derecha = eliminar(raiz.derecha,dato);
            }else if(dato < raiz.dato){
                raiz.izquierda = eliminar(raiz.izquierda,dato);
            }else{
                if (raiz.izquierda==null && raiz.derecha==null) {
                    raiz = null;
                }else if(raiz.derecha == null){
                    raiz.dato = sucesor(raiz);
                    raiz.derecha = eliminar(raiz.derecha,raiz.dato);
                }else{
                    raiz.dato = predecesor(raiz);
                    raiz.izquierda = eliminar(raiz.izquierda,raiz.dato);
                }                                    
            }                                    
        }
        return raiz;
    }        
    
    public int predecesor(Nodo raiz){
        raiz = raiz.izquierda;
        while(raiz.derecha != null){
            raiz = raiz.derecha;
        }
        return raiz.dato;
    }
    
     public int sucesor(Nodo raiz){
        raiz = raiz.derecha;
        while(raiz.izquierda != null){
            raiz = raiz.izquierda;
        }
        return raiz.dato;
    }
}
    
    public static class Nodo {
    int dato;
    Nodo izquierda = null;
    Nodo derecha = null;
    
}
}
