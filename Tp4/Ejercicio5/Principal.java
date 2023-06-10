package Ejercicio5;

import java.util.LinkedList;

public class Principal {
    
    public static void main(String[]args){
        LinkedList<Integer> listaTareas= new LinkedList<>();
        listaTareas.add(15);
        listaTareas.add(10);
        listaTareas.add(30);
        listaTareas.add(40);
        listaTareas.add(20);
        listaTareas.add(20);
        listaTareas.add(30);

        LinkedList<Procesador> listaProcesadores = new LinkedList<>();
        Procesador p1=new Procesador(1);
        Procesador p2=new Procesador(2);
        Procesador p3=new Procesador(3);

        listaProcesadores.add(p1);
        listaProcesadores.add(p2);
        listaProcesadores.add(p3);

        AssignTasks aTasks=new AssignTasks(listaProcesadores, listaTareas);
        System.out.println(aTasks.asignar().toString());

    }
}
