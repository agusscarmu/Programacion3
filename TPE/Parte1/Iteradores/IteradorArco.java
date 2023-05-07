package Parte1.Iteradores;

import java.util.Iterator;

import Parte1.Arco;
import Parte1.Grafo;

public class IteradorArco<T> implements Iterator<Arco<T>>{

    private Integer verticeActual;
    private Iterator<Integer> vertices;
    private Iterator<Arco<T>> arcos;
    private Grafo<T> grafo;

    public IteradorArco(Grafo<T> grafo){
        this.grafo=grafo;
        this.vertices = grafo.obtenerVertices();
        this.verticeActual = vertices.next();
        this.arcos=grafo.obtenerArcos(verticeActual);
    }

    @Override
    public boolean hasNext() {
        if(arcos.hasNext()){
            return true;
        }
        else if(vertices.hasNext()){
            verticeActual=vertices.next();
            arcos=grafo.obtenerArcos(verticeActual);
            return this.hasNext();
        }else{
            return false;
        }
    }

    @Override
    public Arco<T> next() {
        return arcos.next();
    }
    
}
