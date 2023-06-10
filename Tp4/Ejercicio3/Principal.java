package Ejercicio3;

import java.util.LinkedList;

public class Principal {
    
    public static void main(String[]args){
        LinkedList<Integer> listaNumeros=new LinkedList<>();
        listaNumeros.add(1);
        listaNumeros.add(2);
        listaNumeros.add(3);
        listaNumeros.add(4);
        listaNumeros.add(5);
        listaNumeros.add(6);
        listaNumeros.add(7);

        Suma suma= new Suma();

        System.out.println(suma.SumasPosibles(8, listaNumeros)); 
    }
}
