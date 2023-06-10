package Ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Suma {
    
    List<List<Integer>> salida;

    public Suma(){
        this.salida=new LinkedList<>();
    }

    public List<List<Integer>> SumasPosibles(int numero, LinkedList<Integer> listaNumeros){
        LinkedList<Integer> elementos = new LinkedList<>();
        SumasPosibles(numero, listaNumeros, elementos, 0, 0);
        return salida;
    }

    private void SumasPosibles(int numero, LinkedList<Integer> lista, LinkedList<Integer> elementos, int suma, int elem){
        if(lista.isEmpty()){
            if(suma==numero)
                salida.add(new LinkedList<>(elementos));
        }else{
            Integer num = lista.removeFirst();
            SumasPosibles(numero, lista, elementos, suma, elem);
            lista.addFirst(num);

            
            num=lista.removeFirst();
            suma+=num;
            elementos.addFirst(num);
            if(suma<=numero)
                SumasPosibles(numero, lista, elementos, suma, num);
            suma-=num;
            lista.addFirst(num);
            elementos.removeFirst();           
        }
    }
}
