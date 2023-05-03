package Ejercicio1;

public class Arco<T> {
    private int vertice1, vertice2;
    private T etiqueta;

    public Arco(int vertice1, int vertice2, T etiqueta){
        this.vertice1=vertice1;
        this.vertice2=vertice2;
        this.etiqueta=etiqueta;
    }

    public int getVertice1() {
        return this.vertice1;
    }

    public void setVertice1(int vertice1) {
        this.vertice1 = vertice1;
    }

    public int getVertice2() {
        return this.vertice2;
    }

    public void setVertice2(int vertice2) {
        this.vertice2 = vertice2;
    }

    public T getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "Vertice1: "+vertice1+",Vertice2: "+vertice2+",Etiqueta: "+etiqueta;
    }
    
    @Override
    public boolean equals(Object obj) {
        return ((Arco<T>)obj).etiqueta.equals(this.etiqueta);
    }
}
