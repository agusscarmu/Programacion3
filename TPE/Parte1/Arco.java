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

    public int getVerticeDestino() {
        return this.verticeDestino;
    }

    public T getEtiqueta() {
        return this.etiqueta;
    }


    @Override
    public String toString() {
        return "verticeOrigen: "+verticeOrigen+",verticeDestino: "+verticeDestino+",Etiqueta: "+etiqueta;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + verticeOrigen;
        result = prime * result + verticeDestino;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arco other = (Arco) obj;
        if (verticeOrigen != other.verticeOrigen)
            return false;
        if (verticeDestino != other.verticeDestino)
            return false;
        return true;
    }

    
}
