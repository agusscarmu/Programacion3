package Tp1.Ejercicio6;

public class principal {

    // PRUEBA DE LA LISTA
    
    public static void main(String[]args){

        ListaEnlazadaIterable<Integer> lista = new ListaEnlazadaIterable<>();
        ListaEnlazadaIterable<Integer> lista2 = new ListaEnlazadaIterable<>();

        lista.insertFront(720);
        lista.insertFront(500);
        lista.insertFront(400);
        lista.insertFront(100);
        lista.insertFront(32);
        lista.insertFront(30);
        lista.insertFront(12);
        lista.insertFront(4);

        lista2.insertFront(995);
        lista2.insertFront(821);
        lista2.insertFront(720);
        lista2.insertFront(500);
        lista2.insertFront(400);
        lista2.insertFront(100);
        lista2.insertFront(35);
        lista2.insertFront(32);
        
        Compilador compilador = new Compilador();

        ListaEnlazadaIterable<Integer> nuevaLista= new ListaEnlazadaIterable<>();
        nuevaLista=compilador.enlazarListasOrdenadas(lista, lista2);

        for(Integer i:nuevaLista){
            System.out.println(i);
        }
        System.out.println("size: "+nuevaLista.size());

    }
}
