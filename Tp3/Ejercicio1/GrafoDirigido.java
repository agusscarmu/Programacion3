package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import Ejercicio1.Iteradores.IteradorAdyacentes;
import Ejercicio1.Iteradores.IteradorArco;

public class GrafoDirigido implements Grafo<Integer> {
    private HashMap<Integer,ArrayList<Arco<Integer>>> vertices;

    public GrafoDirigido(){
        this.vertices=new HashMap<>();
    }
    @Override
    public void agregarVertice(int vertice) {
        if(!contieneVertice(vertice)){
            vertices.put(vertice, new ArrayList<>());
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
    public void agregarArco(int vertice1, int vertice2, Integer etiqueta) {
        if(contieneVertice(vertice1)){
            Arco<Integer> arco = new Arco<Integer>(vertice1, vertice2, etiqueta);
            vertices.get(vertice1).add(arco);
        }
    }

    @Override
    public void borrarArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            Arco<Integer> arco = obtenerArco(vertice1, vertice2);
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
        if(vertices.get(vertice)!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean existeArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            ArrayList<Arco<Integer>> arco = vertices.get(vertice1);
            for(Arco<Integer> a:arco){
                if(a.getVertice2()==vertice2){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Arco<Integer> obtenerArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            for(Arco<Integer> a:vertices.get(vertice1)){
                if(a.getVertice2()==vertice2){
                    return new Arco<Integer>(vertice1, vertice2, a.getEtiqueta());
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
    public Iterator<Arco<Integer>> obtenerArcos() {
        return new IteradorArco(this.vertices, vertices.keySet());
    }

    @Override
    public Iterator<Arco<Integer>> obtenerArcos(int vertice) {
        return new IteradorArco(vertices, vertice);
    }
    
}
