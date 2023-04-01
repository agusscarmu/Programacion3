package Tp1.Ejercicio6;

public class principal {

    // PRUEBA DE LA LISTA
    
    public static void main(String[]args){

        ListaEnlazadaIterable<Integer> lista = new ListaEnlazadaIterable<>();
        ListaEnlazadaIterable<Integer> lista2 = new ListaEnlazadaIterable<>();

        lista.insertFront(5);
        lista.insertFront(7);
        lista.insertFront(9);
        lista.insertFront(8);
        lista.insertFront(3);
        lista.insertFront(1);
        lista.insertFront(2);
        lista.insertFront(4);

        lista2.insertFront(8);
        lista2.insertFront(7);
        lista2.insertFront(2);
        lista2.insertFront(1);
        lista2.insertFront(9);
        lista2.insertFront(5);
        lista2.insertFront(4);
        lista2.insertFront(3);
        
        Compilador compilador = new Compilador();

        ListaEnlazadaIterable<Integer> nuevaLista= new ListaEnlazadaIterable<>();
        nuevaLista=compilador.enlazarListas(lista, lista2);

        for(Integer i:nuevaLista){
            System.out.println(i);
        }
        System.out.println("size: "+nuevaLista.size());

    }
}
