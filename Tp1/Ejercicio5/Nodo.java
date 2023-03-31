package Tp1.Ejercicio5;

import java.util.Iterator;

public class Nodo<T> implements Iterable<T>{
    private T info;
    private Nodo<T> siguiente;
    public Nodo(){
        this.info=null;
        this.siguiente=null;
    }
    public Nodo(T info, Nodo<T> siguiente){
        this.info=info;
        this.siguiente=siguiente;
    }

    public void setSiguiente(Nodo<T> sig){
        siguiente=sig;
    }

    public void setInfo(T info){
        this.info=info;
    }
    
    public Nodo<T> getSiguiente(){
        return siguiente;
    }

    public T getInfo(){
        return info;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterador<>(this);
    }
}
