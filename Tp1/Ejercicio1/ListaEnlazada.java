package Tp1.Ejercicio1;

public class ListaEnlazada<T> {
    
    private Nodo<T> front;
    private int size;

    public ListaEnlazada(){
        this.front=null;
        this.size=0;
    }

    public void insertFront(T elem){
        Nodo<T>nodo=new Nodo<>(elem,null);
        nodo.setSiguiente(front);
        front=nodo;
        size++;
    }

    public T extractFront(){
        Nodo<T>aux=front;
        front=front.getSiguiente();
        aux.setSiguiente(null);
        size--;

        return aux.getInfo();
    }

    public boolean isEmpty(){
        return front==null;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        Nodo<T>aux=front;

        for(int i=0;i<index;i++){
            aux=aux.getSiguiente();
        }
        
        return aux.getInfo();
    }

    public String toString(){

        String salida="";

        Nodo<T>aux=front;

        for(int i=0;i<size();i++){
            salida+=aux.getInfo().toString();
            aux=aux.getSiguiente();
        }

        return salida;
    }
}
