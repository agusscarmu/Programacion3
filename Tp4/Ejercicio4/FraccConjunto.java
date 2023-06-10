package Ejercicio4;

import java.util.LinkedList;

public class FraccConjunto {
    LinkedList<Subconjuntos>listaSubconjuntos;
    LinkedList<Integer> lista;

    public FraccConjunto(LinkedList<Integer> lista){
        this.lista=lista;
        this.listaSubconjuntos=new LinkedList<>();
    }

    public LinkedList<Subconjuntos> fraccionar(){
        LinkedList<Integer> subConjunto1 = new LinkedList<>();
        LinkedList<Integer> subConjunto2 = new LinkedList<>();
        cargarFracciones(subConjunto1,subConjunto2);
        return listaSubconjuntos;
    }

    private void cargarFracciones(LinkedList<Integer> subConjunto1,LinkedList<Integer> subConjunto2){
        
       if(lista.isEmpty()){
            if(sum(subConjunto1)==sum(subConjunto2)){
            Subconjuntos subconjuntos = new Subconjuntos(new LinkedList<>(subConjunto1), new LinkedList<>(subConjunto2));
            listaSubconjuntos.add(subconjuntos);
            }
        }else{
                // Integer sc = lista.pop();
                // cargarFracciones(subConjunto1, subConjunto2);
                // lista.addFirst(sc);

                Integer sc=lista.pop();
                subConjunto1.addFirst(sc);
                cargarFracciones(subConjunto1, subConjunto2);
                lista.addFirst(sc);
                subConjunto1.removeFirst();

                sc=lista.pop();
                subConjunto2.addFirst(sc);
                cargarFracciones(subConjunto1, subConjunto2);
                lista.addFirst(sc);
                subConjunto2.removeFirst();
            
        }
    }

    private int sum(LinkedList<Integer> l){
        int sum=0;
        for(Integer list:l){
            sum+=list;
        }
        return sum;
    }
}
