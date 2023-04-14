package Tp1.Ejercicio7;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T>{

    private Nodo<T> cursor;

    public Iterador(Nodo<T> cursor){
        this.cursor=cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor!=null;
    }

    @Override
    public T next() {
        T tmp = cursor.getInfo();
        cursor = cursor.getSiguiente();
        return tmp;
    }
    
}
