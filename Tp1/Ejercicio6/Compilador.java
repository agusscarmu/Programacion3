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

    public ListaEnlazadaIterable<Integer> enlazarListasOrdenadas(ListaEnlazadaIterable<Integer> l1, ListaEnlazadaIterable<Integer> l2){
        ListaEnlazadaIterable<Integer>salida=new ListaEnlazadaIterable<>();
        Iterador<Integer> it = (Iterador<Integer>) l1.iterator();
        Iterador<Integer> it2 = (Iterador<Integer>) l2.iterator();

        while(it.hasNext() && it2.hasNext()){

            if(it.actual().equals(it2.actual())){
                salida.insertFront(it.actual());
                it.next();
                it2.next();
            }else if(it.actual()>it2.actual()){
                it2.next();
            }else{
                it.next();
            }
        }
        
        return salida;
    }
}
