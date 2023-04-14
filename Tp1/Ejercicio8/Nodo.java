package Tp1.Ejercicio8;

public class Nodo<T>{
    private T info;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

    
    public Nodo(){
        this.info=null;
        this.siguiente=null;
    }
    public Nodo(T info, Nodo<T> siguiente){
        this.info=info;
        this.siguiente=siguiente;
    }

    public Nodo<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Nodo<T> ant) {
        this.anterior = ant;
    }

    public void setSiguiente(Nodo<T> sig){
        this.siguiente=sig;
    }

    public void setInfo(T info){
        this.info=info;
    }
    
    public Nodo<T> getSiguiente(){
        return this.siguiente;
    }

    public T getInfo(){
        return info;
    }
}
