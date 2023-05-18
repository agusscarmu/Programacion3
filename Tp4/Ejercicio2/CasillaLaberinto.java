package Ejercicio2;

public class CasillaLaberinto {
    
    private boolean izquierda,derecha,arriba,abajo;
    private int valor;

    public CasillaLaberinto(int valor, boolean izquierda, boolean derecha, boolean arriba, boolean abajo){
        this.valor=valor;
        this.izquierda=izquierda;
        this.derecha=derecha;
        this.arriba=arriba;
        this.abajo=abajo;
    }

    public int getValor(){
        return valor;
    }
    
    public boolean arriba(){
        return arriba;
    }

    public boolean abajo(){
        return abajo;
    }

    public boolean izquierda(){
        return izquierda;
    }

    public boolean derecha(){
        return derecha;
    }

    @Override
    public String toString() {
        return Integer.toString(valor);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + valor;
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
        CasillaLaberinto other = (CasillaLaberinto) obj;
        if (valor != other.valor)
            return false;
        return true;
    }
}
