package Parte1.Iteradores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Parte1.Arco;

public class IteradorArco<T> implements Iterator<Arco<T>>{

    private HashMap<Integer,List<Arco<T>>> vertices;
    private int puntero;
    private Iterator<Integer> iterador;
    private int index;

    public IteradorArco(HashMap<Integer,List<Arco<T>>> vertices, Set<Integer> s){
        this.vertices=new HashMap<>(vertices);
        this.iterador=s.iterator();
        puntero=iterador.next();
        index=0;
    }

    public IteradorArco(HashMap<Integer,List<Arco<T>>> vertices, Integer puntero){
        this.vertices=vertices;
        this.puntero=puntero;
    }

    @Override
    public boolean hasNext() {
        if(vertices.get(puntero).size()>index){
            return true;
        }else{
            index=0;
            if(iterador==null){
                return false;
            }else{
                if(iterador.hasNext()){
                    puntero=iterador.next();
                    return this.hasNext();
                }else{
                    return false;
                }
            }
        }
    }

    @Override
    public Arco<T> next() {
        Arco<T> tmp = vertices.get(puntero).get(index);
        index++;
        return tmp;
    }
    
}
