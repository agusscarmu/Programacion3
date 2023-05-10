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

    /*
     * agregarVertice implica una complejidad de O(n) ya que al utilizar HashMap cuando se hace llamado a
     * la funcion "put" esta destinando la clave (en este caso de tipo Integer) a una formula matematica la cual genera el
     * indice a travez del resto entre el Integer ingresado y el tamaño del HashMap. En caso de que el indice generado ya 
     * exista dentro del HashMap, va a producirse lo que se conoce como 'colision' de los elementos, lo cual genera una lista
     * enlazada de los elementos que tengan el mismo indice.
     *  En resumen, en el peor de los casos (donde todos los restos generados por la clave y el tamaño del hash sean iguales)
     * se generara una complejidad O(n), aunque en promedio practico el hashmap tenga una complejidad O(1).
     */
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
            if(!existeArco(vertice1, vertice2)){
            Arco<T> arco = new Arco<T>(vertice1, vertice2, etiqueta);
            vertices.get(vertice1).add(arco);
            }
        }
    }

    @Override
    public void borrarArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            Arco<T> arco = obtenerArco(vertice1, vertice2);
            vertices.get(vertice1).remove(arco); // O(n*m)
        }
    }

    public void borrarArcos(int vertice){
        Iterator<Integer> v = this.obtenerVertices();
        while(v.hasNext()){ // O(n)
            Integer a = v.next();
            for(int i=0;i<vertices.get(a).size();i++){
                if(vertices.get(a).get(i).getVerticeDestino()==vertice){ // O(n*m)
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
        return(obtenerArco(vertice1, vertice2)!=null);
    }

    @Override
    public Arco<T> obtenerArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            for(Arco<T> a:vertices.get(vertice1)){
                if(a.getVerticeDestino()==vertice2){
                    return a;
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
        return new IteradorAdyacentes<T>(this.vertices,vertice);
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return new IteradorArco<T>(this);
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int vertice) {
        return vertices.get(vertice).iterator();
    }
    
}
