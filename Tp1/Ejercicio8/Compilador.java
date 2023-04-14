package Tp1.Ejercicio8;

public class Compilador {
    
    public ListaDobleEnlace<Integer> enlazarListas(ListaDobleEnlace<Integer> l1, ListaDobleEnlace<Integer> l2){
        ListaDobleEnlace<Integer>salida=new ListaDobleEnlace<>();

        for(Integer e:l1){
        
            if(l2.contains(e)){
                salida.insertFrontOrder(e);
            }

        }
        
        return salida;
    }

    public ListaDobleEnlace<Integer> elementosUnicos(ListaDobleEnlace<Integer> l1, ListaDobleEnlace<Integer> l2){
        ListaDobleEnlace<Integer> salida = new ListaDobleEnlace<>();

        for(Integer e:l1){
            if(!l2.contains(e)){
                salida.insertFront(e);
            }
        }

        return salida;
    }
}
