package Ejercicio7;

public class Principal {
    public static void main(String[]args){

        Matrix matriz= new Matrix(5);

        System.out.println(matriz.getElems().toString());
        matriz.cargar();
        matriz.getMatriz();
    }   

}
