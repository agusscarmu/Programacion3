package Ejercicio4;

import java.util.LinkedList;

public class Principal {
    
    public static void main(String[]args){

        LinkedList<Integer> listaNumeros=new LinkedList<>();
        listaNumeros.add(9);
        listaNumeros.add(8);
        listaNumeros.add(10);
        // listaNumeros.add(6);
        // listaNumeros.add(4);
        // listaNumeros.add(2);
        listaNumeros.add(4);
        listaNumeros.add(5);

        FraccConjunto fraccConjunto=new FraccConjunto(listaNumeros);

        System.out.println(fraccConjunto.fraccionar().toString());

    }
}
