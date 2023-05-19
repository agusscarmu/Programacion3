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
        LinkedList<Integer> subConjunto2 = new LinkedList<>(lista);
        cargarFracciones(subConjunto1,subConjunto2);
        return listaSubconjuntos;
    }

    private void cargarFracciones(LinkedList<Integer> subConjunto1,LinkedList<Integer> subConjunto2){
        
        if(sum(subConjunto1)==sum(subConjunto2)){
            Subconjuntos subconjuntos = new Subconjuntos(new LinkedList<>(subConjunto1), new LinkedList<>(subConjunto2));
            listaSubconjuntos.add(subconjuntos);
        }else{
            for(int i=0;i<subConjunto2.size();i++){
                Integer sc=subConjunto2.pop();
                subConjunto1.add(sc);
                cargarFracciones(subConjunto1, subConjunto2);
                subConjunto2.add(sc);
                subConjunto1.remove(sc);
            }
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
