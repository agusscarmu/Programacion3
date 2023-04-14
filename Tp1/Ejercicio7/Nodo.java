package Tp1.Ejercicio7;

public class Nodo<T>{
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
}
