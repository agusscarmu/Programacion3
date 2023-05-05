package Parte1.Iteradores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Parte1.Arco;

public class IteradorAdyacentes<T> implements Iterator<Integer>{

    private HashMap<Integer,List<Arco<T>>> vertices;
    private int v;

    public IteradorAdyacentes(HashMap<Integer,List<Arco<T>>> vertices, int v){
        this.vertices=vertices;
        this.v=v;
    }

    @Override
    public boolean hasNext() {
        return !vertices.get(v).isEmpty();
    }

    @Override
    public Integer next() {
        Integer tmp = vertices.get(v).get(0).getVertice2();
        vertices.get(v).remove(vertices.get(v).get(0));
        return tmp;
    }
    
}

