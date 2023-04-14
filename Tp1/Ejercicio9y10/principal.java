package Tp1.Ejercicio9y10;

public class principal {
    
    public static void main(String[]args){
        // System.out.println(esCapicua("neuquen ama a ama neuquen",0));
        int[]arreglo={1,2,3,4,5,6,7,9,8};
        System.out.println(estaOrdenado(arreglo,0));
        /*
         * 10.1) tiene complejidad O(n)
         * 10.2) para el programa es mas costoso y en este caso seria menos costoso hacer un while por ejemplo
         * 10.3) si fuera una lista la complejidad cambiaria a O(n) (si lo hiciera con iterador)
         */
    }

    public static boolean esCapicua(String palabra,int index){
        
       char primerLetra=palabra.charAt(index);
       char ultimaLetra=palabra.charAt(palabra.length()-index-1);

       if(primerLetra==ultimaLetra){
            index++;
            if (index>palabra.length()/2){
                return true;
            }
            return esCapicua(palabra, index);
       }else{
            return false;
       }

    }

    public static boolean estaOrdenado(int[]arr,int index){
        if(index<arr.length-1){
            if(arr[index]<arr[index+1]){
                index++;
                return estaOrdenado(arr, index);
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}
