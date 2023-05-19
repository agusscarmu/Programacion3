package Ejercicio4;

import java.util.LinkedList;

public class Principal {
    
    public static void main(String[]args){

        LinkedList<Integer> listaNumeros=new LinkedList<>();
        listaNumeros.add(1);
        listaNumeros.add(2);
        listaNumeros.add(3);
        listaNumeros.add(6);
        listaNumeros.add(4);
        listaNumeros.add(2);
        listaNumeros.add(3);
        listaNumeros.add(3);

        FraccConjunto fraccConjunto=new FraccConjunto(listaNumeros);

        System.out.println(fraccConjunto.fraccionar().toString());

    }
}
