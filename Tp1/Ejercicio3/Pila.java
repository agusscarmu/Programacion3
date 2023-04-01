package Tp1.Ejercicio3;

import Tp1.Ejercicio1.ListaEnlazada;

public class Pila<T> {
    private ListaEnlazada<T>lista;

    public Pila(){
        this.lista=new ListaEnlazada<>();
    }

    public void push(T o){
        this.lista.insertFront(o);
    }

    public T pop(){
        return this.lista.extractFront();
    }

    public T top(){
        return lista.get(0);
    }

    public void reverse(){
        
        ListaEnlazada<T>aux=new ListaEnlazada<>();
        int size=lista.size();
        
        for(int i=0;i<size;i++){
            aux.insertFront(lista.extractFront());
        }

        this.lista=aux;
    }
}
