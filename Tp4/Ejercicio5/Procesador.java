package Ejercicio5;

import java.util.LinkedList;

public class Procesador {
    private LinkedList<Integer> lista;
    private int nro;
    private int tiempo;

    public Procesador(int nro){
        this.nro=nro;
        this.lista=new LinkedList<>();
        this.tiempo=0;
    }
    
    public void sumarTiempo(int tarea){
        tiempo+=tarea;
    }

    public void restarTiempo(int tarea){
        tiempo-=tarea;
    }

    public Procesador(Procesador p){
        this.lista=p.getTareas();
        this.nro=p.getNro();
        this.tiempo=p.getTiempo();
    }

    public LinkedList<Integer> getTareas(){
        return new LinkedList<>(lista);
    }

    public void setTareas(LinkedList<Integer> lista) {
        this.lista = lista;
    }

    public void agregarTarea(Integer tarea){
        lista.addFirst(tarea);
    }
    
    public boolean borrarTareas(){
        return lista.removeAll(lista);
    }

    public void borrarPrimerTarea(){
        lista.removeFirst();
    }

    public int getTiempo(){
        return tiempo;
    }

    public int getNro() {
        return nro;
    }

    @Override
    public String toString() {
        return "\nProcesador: "+this.nro+"\nTareas: "+this.lista.toString();
    }
}
