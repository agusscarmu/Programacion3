package Tp1.Ejercicio7;

import java.util.Iterator;

public class ListaEnlazadaIterable<T extends Comparable<T>> implements Iterable<T>{
    
    private Nodo<T> front;
    private int size;

    public ListaEnlazadaIterable(){
        this.front=null;
        this.size=0;
    }

    public void insertFrontOrder(T elem){
        Nodo<T> nodo= new Nodo<T>(elem, null);
        if(front==null || front.getInfo().compareTo(elem)<0){
            nodo.setSiguiente(front);
            front=nodo;
        }else{
            Nodo<T> tmp = front;
            while(tmp.getSiguiente()!=null && tmp.getSiguiente().getInfo().compareTo(elem)>=0){
                tmp=tmp.getSiguiente();
            }
            nodo.setSiguiente(tmp.getSiguiente());
            tmp.setSiguiente(nodo);

        }
        size++;
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
        Nodo<T>cursor=front;

        for(int i=0;i<index;i++){
            cursor=cursor.getSiguiente();
        }
        
        return cursor.getInfo();
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

    public boolean contains(T elem){
        Nodo<T> tmp = front;
        for(T e:this){
            if(e.equals(elem)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterador<>(front);
    }

    // @Override
    // public int compareTo(Object o) {
        
    // }
}
