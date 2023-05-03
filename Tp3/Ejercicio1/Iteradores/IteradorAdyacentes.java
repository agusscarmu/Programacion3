package Ejercicio1.Iteradores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Ejercicio1.Arco;

public class IteradorAdyacentes implements Iterator<Integer>{

    private HashMap<Integer,ArrayList<Arco<Integer>>> vertices;
    private int v;

    public IteradorAdyacentes(HashMap<Integer,ArrayList<Arco<Integer>>> vertices, int v){
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
