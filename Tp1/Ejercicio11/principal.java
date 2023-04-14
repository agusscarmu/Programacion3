package Tp1.Ejercicio11;

public class principal {
    

    public static void main (String[]args){
        int[]arreglo={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,17,82,3769,393784,4769723};

        
        System.out.println(busquedaRecursiva(arreglo,17,0,(arreglo.length-1)));
    }

    public static int busquedaRecursiva(int[]arr, int numero,int inicio, int fin){
        int mitad=(inicio + fin)/2;
        if(inicio!=mitad){
            if(arr[mitad]>numero){
                return busquedaRecursiva(arr, numero, inicio, mitad);
            }else if(arr[mitad]<numero){
                return busquedaRecursiva(arr, numero, mitad, fin);
            }else{
                return mitad;
            }
        }else if(arr[mitad]==numero){
            return mitad;
        }else{
            return -1;
        }

    }
    

}
