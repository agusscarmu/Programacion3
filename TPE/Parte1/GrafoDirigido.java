package Parte1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Parte1.Iteradores.IteradorAdyacentes;
import Parte1.Iteradores.IteradorArco;


public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer,List<Arco<T>>> vertices;

    public GrafoDirigido(){
        this.vertices=new HashMap<>();
    }
    @Override
    public void agregarVertice(int vertice) {
        if(!contieneVertice(vertice)){
            vertices.put(vertice, new LinkedList<>());
        }
    }

    @Override
    public void borrarVertice(int vertice) {
        if(contieneVertice(vertice)){
            vertices.remove(vertice);
            borrarArcos(vertice);
        }
    }

    @Override
    public void agregarArco(int vertice1, int vertice2, T etiqueta) {
        if(contieneVertice(vertice1) && contieneVertice(vertice2)){
            Arco<T> arco = new Arco<T>(vertice1, vertice2, etiqueta);
            vertices.get(vertice1).add(arco);
        }
    }

    @Override
    public void borrarArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            Arco<T> arco = obtenerArco(vertice1, vertice2);
            vertices.get(vertice1).remove(arco);
        }
    }

    public void borrarArcos(int vertice){
        Set<Integer> s = vertices.keySet();
        for(Integer a:s){
            for(int i=0;i<vertices.get(a).size();i++){
                if(vertices.get(a).get(i).getVertice2()==vertice){
                    borrarArco(a, vertice);
                }
            }
        }
    }

    @Override
    public boolean contieneVertice(int vertice) {
        return vertices.containsKey(vertice);
    }

    @Override
    public boolean existeArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            List<Arco<T>> arco = vertices.get(vertice1);
            for(Arco<T> a:arco){
                if(a.getVertice2()==vertice2){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            for(Arco<T> a:vertices.get(vertice1)){
                if(a.getVertice2()==vertice2){
                    return new Arco<T>(vertice1, vertice2, a.getEtiqueta());
                }
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int salida=0;
        Set<Integer> s = vertices.keySet();
        for(Integer i:s){
            salida+=vertices.get(i).size();
        }
        return salida;
    }


    //Los iteradores estan bien hechos?
    @Override
    public Iterator<Integer> obtenerVertices() {
        Set<Integer> s = vertices.keySet();
        return s.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int vertice) {
        return new IteradorAdyacentes(this.vertices,vertice);
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return new IteradorArco(this.vertices, vertices.keySet());
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int vertice) {
        return vertices.get(vertice).iterator();
    }
    
}
