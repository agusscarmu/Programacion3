package Tp1.Ejercicio5;

public class principal {

    // PRUEBA DE LA LISTA
    
    public static void main(String[]args){

        ListaEnlazadaIterable<String> lista = new ListaEnlazadaIterable<>();

        lista.insertFront("hola");
        lista.insertFront("como");
        lista.insertFront("estas?");

        for(String e:lista){
            System.out.println(e);
        }

    }
}
