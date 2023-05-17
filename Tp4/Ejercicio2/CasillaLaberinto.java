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
}
