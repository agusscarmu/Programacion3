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
    private int cantidadArcos;

    public GrafoDirigido(){
        this.vertices=new HashMap<>();
        this.cantidadArcos=0;
    }

    /*
     * Al utilizar HashMap cuando se hace llamado a la funcion "put" esta destinando la clave 
     * (en este caso de tipo Integer) a una formula matematica la cual genera el
     * indice a travez del resto entre el Integer ingresado y el tamaño del HashMap. En caso de que el indice generado ya 
     * exista dentro del HashMap, va a producirse lo que se conoce como 'colision' de los elementos, lo cual genera una lista
     * enlazada de los elementos que tengan el mismo indice.
     *  En resumen, en el peor de los casos (donde todos los restos generados por la clave y el tamaño del hash sean iguales)
     * se generara una complejidad O(n), aunque en promedio practico el hashmap tenga una complejidad O(1).
     * En la catedra se tomara a HashMap como una complejidad de O(1). Por ende la funcion agregarVertice() tiene una
     * complejidad O(1)
     */
    @Override
    public void agregarVertice(int vertice) {
        if(!contieneVertice(vertice)){
            vertices.put(vertice, new LinkedList<>());
        }
    }

    /*
     * la funcion borrarVertice() cuenta con una complejidad O(n^2) ya que la funcion borrarArcos() que esta llama
     * tiene dicha complejidad, y el resto de funciones que llama (contieneVertice() y remove() son O(1))
     */
    @Override
    public void borrarVertice(int vertice) {
        if(contieneVertice(vertice)){
            cantidadArcos-=vertices.get(vertice).size();
            vertices.remove(vertice);
            borrarArcos(vertice);
        }
    }

    /*
     * La funcion agregarArco() tiene una complejidad de O(n) donde n es la cantidad de arcos que tiene el vertice,
     * esto es debido al llamado de la funcion existeArco() la cual itera sobre los arcos del vertice1. Si no fuera por
     * esa funcion estariamos hablando de una complejidad O(1) ya que al agregar un elemento a la lista vinculada de 
     * java.util mediante la funcion add() lo que hace es agregar el elemento al final, pero con un puntero que tiene la
     * lista apuntando a dicha posicion.
     */
    @Override
    public void agregarArco(int vertice1, int vertice2, T etiqueta) {
        if(contieneVertice(vertice1) && contieneVertice(vertice2)){
            if(!existeArco(vertice1, vertice2)){
            Arco<T> arco = new Arco<T>(vertice1, vertice2, etiqueta);
            vertices.get(vertice1).add(arco);
            cantidadArcos++; 
            }
        }
    }

    /*
     * La funcion borrarArco() cuenta con una complejidad O(n) donde n es la cantidad de arcos que tiene el vertice1 (en el 
     * peor de los casos el vertice1 va a estar conectado a todos los otros vertices del grafo). Lo que se hace en esta funcion
     * es crear un iterador para obtener los arcos de vertice1 y de esta forma pregunta si el vertice destino es igual a
     * vertice 2, de ser asi elimina el elemento y disminuye la cantidad de arcos.
     */
    @Override
    public void borrarArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            Iterator<Arco<T>> arcos = obtenerArcos(vertice1);
            while(arcos.hasNext()){
                Arco<T> a = arcos.next();
                if(a.getVerticeDestino() == vertice2){
                    arcos.remove();
                    cantidadArcos--;
                    return;
                }
            }
        }
    }
    
    /*
     * La funcion borrarArcos tiene una complejidad de O(n^2) siendo n la cantidad de vertices en el grafo, y tiene dicha 
     * complejidad debido a que en un principio itera todos los vertices del grafo, para despues llamar a la funcion
     * borrarArco() por cada iteracion (la cual cuenta con una complejidad O(n))
     */
    private void borrarArcos(int vertice){
        Iterator<Integer> v = this.obtenerVertices();
        while(v.hasNext()){
            borrarArco(v.next(), vertice);
        }
    }

    /*
     * La funcion contieneVertice() tiene una complejidad de O(1) si mantenemos lo propuesto en la declaracion de complejidad
     * de la funcion agregarVertice(), ya que en promedio en un HashMap se accede a un elemento de manera directa.
     */
    @Override
    public boolean contieneVertice(int vertice) {
        return vertices.containsKey(vertice);
    }

    /*
     * La funcion existeArco() tiene una complejidad O(n) dado que a la unica funcion que esta llama dispone de esa 
     * complejidad.
     */
    @Override
    public boolean existeArco(int vertice1, int vertice2) {
        return(obtenerArco(vertice1, vertice2)!=null);
    }

    /*
     * La funcion obtenerArco() cuenta con una complejidad de O(n) donde n es la cantidad de arcos que tiene un vertice, 
     * y tiene dicha complejidad dado que dentro de la funcion se iteran todos los arcos de un vertice (vertice1), y en 
     * el peor de los casos este vertice puede llegar a estar conectado a todos los otros vertices del grafo.
     */
    @Override
    public Arco<T> obtenerArco(int vertice1, int vertice2) {
        if(contieneVertice(vertice1)){
            for(Arco<T> a:vertices.get(vertice1)){
                if(a.getVerticeDestino()==vertice2){
                    return new Arco<T>(vertice1, vertice2, a.getEtiqueta());
                }
            }
        }
        return null;
    }

    /*
     * La funcion cantidadVertices() tiene una complejidad O(1) ya que la ListaEnlazada de java.util cuenta con una variable
     * de tipo int llamada "size", la cual se va modificando cuando se agrega o se elimina un elemento de la lista, 
     * manteniendo la informacion del tamaño actualizada y al hacer llamado de la funcion size() lo unico que hace es devolver
     * la variable.
     */
    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    /*
     * La funcion cantidadArcos() cuenta con una complejidad O(1) ya que de manera similar a la funcion size() de una 
     * LinkedList explicada anteriormente, la clase GrafoDirigido cuenta con una variable de tipo int llamada cantidadArcos, 
     * la cual se va modificando cuando se agregan o eliminan arcos asi manteniendola actualizada, haciendo que al momento
     * de acceder a la variable ya nos permita ver la cantidad de arcos sin necesidad de iterar
     */
    @Override
    public int cantidadArcos() {
        return cantidadArcos;
    }


    /*
     * La funcion obtenerVertices() devuelve un iterador y tiene una complejidad de O(1) porque simplemente lo instancia
     */
    @Override
    public Iterator<Integer> obtenerVertices() {
        Set<Integer> s = vertices.keySet();
        return s.iterator();
    }

    /*
     * La funcion obtenerAdyacentes() devuelve un iterador y tiene una complejidad de O(1) porque simplemente lo instancia
     */
    @Override
    public Iterator<Integer> obtenerAdyacentes(int vertice) {
        return new IteradorAdyacentes<T>(this.vertices,vertice);
    }

    /*
     * La funcion obtenerArcos() devuelve un iterador y tiene una complejidad de O(1) porque simplemente lo instancia y 
     * dentro del iterador lo que se hace es iterar cada lista de arcos de cada vertice del grafo
     */
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return new IteradorArco<T>(this);
    }

    /*
     * La funcion obtenerArcos(int vertice) devuelve un iterador y tiene una complejidad de O(1) porque simplemente 
     * lo instancia
     */
    @Override
    public Iterator<Arco<T>> obtenerArcos(int vertice) {
        return vertices.get(vertice).iterator();
    }
    
}
