package Tp1.Ejercicio4;

public class ListaEnlazadaCIndexOf<T> {
    
    private Nodo<T> front;
    private int size;

    public ListaEnlazadaCIndexOf(){
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

    public int indexOf(T elem){

        int index=0;
        Nodo<T>tmp=front;

        while(!(tmp.getInfo().equals(elem)) && index<this.size()){
            tmp=tmp.getSiguiente();
            index++;
        }
        
        if(index==size()){
            return -1;
        }

        return index;
    }
}
