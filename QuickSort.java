/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Azucena
 */
import java.util.Random;

public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();

        for (int i = 0; i < 1000001; ++i) {
            Random R = new Random();
            int x = R.nextInt(100001);

            lista.insertar(x);
        }

        lista.quickSort();
        lista.recorrer();
    }

    public static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo anterior;
    }

    public static class Lista {

        Nodo inicio = null;
        Nodo fin = null;
        
         public void sort(Nodo a, Nodo b) {
            if ((b != null) && (a != b) && (a != b.siguiente)) {
                Nodo temp = mitad(a, b);
                sort(a, temp.anterior);
                sort(temp.siguiente, b);
            }
        }

        public void insertar(int dato) {
            Nodo nuevo = new Nodo();
            nuevo.dato = dato;
            if (inicio == null) {
                inicio = nuevo;
                fin = nuevo;
            } else {
                nuevo.anterior = fin;
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        public Nodo mitad(Nodo inicio, Nodo fin) {
            int x;
            Nodo aux = inicio;
            Nodo ant = inicio.anterior;

            while (aux != fin) {
                if (aux.dato <= fin.dato) {
                    if (ant == null) {
                        ant = inicio;
                    } else {
                        ant = ant.siguiente;
                    }
                    x = ant.dato;
                    ant.dato = aux.dato;
                    aux.dato = x;
                }
                aux = aux.siguiente;
            }
            if (ant == null) {
                ant = inicio;
            } else {
                ant = ant.siguiente;
            }
            x = ant.dato;
            ant.dato = fin.dato;
            fin.dato = x;
            return ant;
        }
        
        public void recorrer() {
            Nodo aux = inicio;
            while (aux != null) {
                System.out.println(aux.dato + " ");
                aux = aux.siguiente;
            }
        }

        public void quickSort() {
            sort(inicio, fin);
        }
    }
}
