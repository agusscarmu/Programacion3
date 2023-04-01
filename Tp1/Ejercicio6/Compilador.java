package Tp1.Ejercicio6;

public class Compilador {
    
    public ListaEnlazadaIterable<Integer> enlazarListas(ListaEnlazadaIterable<Integer> l1, ListaEnlazadaIterable<Integer> l2){
        ListaEnlazadaIterable<Integer>salida=new ListaEnlazadaIterable<>();

        for(Integer e:l1){
        
            if(l2.contains(e)){
                salida.insertFrontOrder(e);
            }

        }
        
        return salida;
    }
}
