package Ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Suma {
    
    List<List<Integer>> salida;

    public Suma(){
        this.salida=new LinkedList<>();
    }

    public List<List<Integer>> SumasPosibles(int numero, List<Integer> listaNumeros){
        List<Integer> elementos = new LinkedList<>();
        SumasPosibles(numero, listaNumeros, elementos, 0, 0);
        return salida;
    }

    private void SumasPosibles(int numero, List<Integer> lista, List<Integer> elementos, int suma, int elem){
        if(suma==numero){
            salida.add(new LinkedList<>(elementos));
        }else if(suma<numero){
            for(Integer e:lista){
                suma+=e;
                elementos.add(e);
                SumasPosibles(numero, lista, elementos, suma, e);
                suma-=e;
                elementos.remove(elementos.size()-1);
            }
        }
    }
}
