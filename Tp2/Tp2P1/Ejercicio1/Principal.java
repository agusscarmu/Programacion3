package Tp2.Tp2P1.Ejercicio1;

public class Principal {
    
    public static void main(String[]args){

        Tree arbol=new Tree();

        arbol.add(5);
        arbol.add(6);
        arbol.add(4);
        arbol.add(3);
        arbol.add(1);
        arbol.add(2);
        arbol.add(9);
        arbol.add(10);
        arbol.add(11);
        arbol.add(13);
        arbol.add(12);
        arbol.add(14);
        arbol.add(15);


        // System.out.println(arbol.hasElem(7));
        // System.out.println(arbol.getRoot());
        arbol.printInOrder();
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
        arbol.Delete(5);
        arbol.printInOrder();
        // System.out.println(arbol.getMinElem()); 


    }
}
