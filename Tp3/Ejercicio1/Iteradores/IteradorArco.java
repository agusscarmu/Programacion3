package Ejercicio1.Iteradores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import Ejercicio1.Arco;

public class IteradorArco implements Iterator<Arco<Integer>>{

    private HashMap<Integer,ArrayList<Arco<Integer>>> vertices;
    private int puntero;
    private Iterator<Integer> iterador;

    public IteradorArco(HashMap<Integer,ArrayList<Arco<Integer>>> vertices, Set<Integer> s){
        this.vertices=vertices;
        this.iterador=s.iterator();
        puntero=iterador.next();
    }

    public IteradorArco(HashMap<Integer,ArrayList<Arco<Integer>>> vertices, Integer puntero){
        this.vertices=vertices;
        this.puntero=puntero;
    }

    @Override
    public boolean hasNext() {
        if(!vertices.get(puntero).isEmpty()){
            return true;
        }else{
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
    public Arco<Integer> next() {
        Arco<Integer> tmp = vertices.get(puntero).get(0);
        vertices.get(puntero).remove(tmp);
        return tmp;
    }
    
}
