package Parte1;
import java.util.Iterator;


public interface Grafo<T> {
    
    public void agregarVertice(int vertice);
    public void borrarVertice(int vertice);
    public void agregarArco(int vertice1, int vertice2, T etiqueta);
    public void borrarArco(int vertice1, int vertice2);
    public boolean contieneVertice(int vertice);
    public boolean existeArco(int vertice1, int vertice2);
    public Arco<T> obtenerArco(int vertice1, int vertice2);
    public int cantidadVertices();
    public int cantidadArcos();
    public Iterator<Integer> obtenerVertices();
    public Iterator<Integer> obtenerAdyacentes(int vertice);
    public Iterator<Arco<T>> obtenerArcos();
    public Iterator<Arco<T>> obtenerArcos(int vertice);
}