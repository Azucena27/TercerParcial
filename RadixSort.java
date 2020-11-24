
/**
 *
 * @author Azucena
 */

import java.util.Random;

public class RadixSort {

    /**
     * @param args the command line arguments
     */
    static Nodo inicio = null;
    
    public static void main(String[] args) {
        
        for(int i = 0; i < 1000001; ++i){
            Random R = new Random();
            int x = R.nextInt(100001);
            insertar(x);
        }
        ordenamientoRadix();
        imprimir();
    } 
    
    public static void insertar (int dato){
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        if (inicio != null){
            nuevo.siguiente = inicio;
        }
        inicio = nuevo;
        System.out.print(dato + " ");
    }

    public static void imprimir(){
        Nodo aux = inicio;
        while(aux != null){
            System.out.println(aux.dato + " ");
            aux = aux.siguiente;
        }
    }

    public static int numeroMayor(Nodo incio){
        Nodo aux = inicio;
        int digitoMayor = aux.dato;
        while (aux != null){
            if (aux.dato > digitoMayor){
                digitoMayor = aux.dato;
            }
            aux = aux.siguiente;
        }
        return digitoMayor;
    }

    public static int Digitos(){
        int digitos = numeroMayor(inicio);
        int i = 0;
        while (digitos != 0){
            digitos /= 10;
            i++;
        }
        return i;
    }

    public static int[] mat(){
        int[] radix = new int[elementos()+1];
        Nodo aux = inicio;
        while (aux != null){
            int i = 0;
            radix[i] = aux.dato;
            aux = aux.siguiente;
            i++;
        }
        return radix;
    }

    public static void Radix(int matriz[], int tamaño, int lugar ){
        int[] output = new int[tamaño + 1];
        int max = matriz[0];
        for (int i = 1; i < tamaño; i++) {
            if (matriz[i] > max)
                max = matriz[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        for (int i = 0; i < tamaño; i++)
            count[(matriz[i] / lugar) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = tamaño - 1; i >= 0; i--) {
            output[count[(matriz[i] / lugar) % 10] - 1] = matriz[i];
            count[(matriz[i] / lugar) % 10]--;
        }

        for (int i = 0; i < tamaño; i++) {
            matriz[i] = output[i];
            System.out.println(matriz[i]);
        }
    }

    public static void ordenamientoRadix(){
        int max = numeroMayor(inicio);

        for (int lugar = 1; max/lugar > 0; lugar*=10) {
            Radix(mat(), Digitos(), lugar);
        }
       
    }

    public static int elementos(){
        Nodo aux = inicio;
        int i = 0;
        while (aux != null){
            i++;
            aux = aux.siguiente;
        }
        return i;
    }

}
    

