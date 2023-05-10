package Parte1;

public class Arco<T> {
    private int verticeOrigen, verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta){
        this.verticeOrigen=verticeOrigen;
        this.verticeDestino=verticeDestino;
        this.etiqueta=etiqueta;
    }

    public int getVerticeOrigen() {
        return this.verticeOrigen;
    }

    public void setVerticeOrigen(int verticeOrigen) {
        this.verticeOrigen = verticeOrigen;
    }

    public int getVerticeDestino() {
        return this.verticeDestino;
    }

    public void setVerticeDestino(int verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public T getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "verticeOrigen: "+verticeOrigen+",verticeDestino: "+verticeDestino+",Etiqueta: "+etiqueta;
    }
    
    @Override
    public boolean equals(Object obj) {
        return ((Arco<T>)obj).etiqueta.equals(this.etiqueta);
    }
}
