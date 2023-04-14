package Tp1.Ejercicio8;

public class principal {

    // PRUEBA DE LA LISTA
    
    public static void main(String[]args){

        ListaDobleEnlace<Integer> lista = new ListaDobleEnlace<>();
        ListaDobleEnlace<Integer> lista2 = new ListaDobleEnlace<>();

        lista.insertFront(5);
        lista.insertFront(11);
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
        
        System.out.println(lista.get(5));

        Compilador compilador = new Compilador();

        ListaDobleEnlace<Integer> nuevaLista= new ListaDobleEnlace<>();
        nuevaLista=compilador.elementosUnicos(lista, lista2);

        // for(Integer i:nuevaLista){
        //     System.out.println(i);
        // }
        // System.out.println("size: "+nuevaLista.size());

    }
}
