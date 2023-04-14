package Tp1.Ejercicio12;

public class Principal {
    
    public static void main(String[]args){
        System.out.println(Binario(26));
    }

    public static String convertirBinario(int numero){
        String salida = "";

        if(numero>1){
        salida+=convertirBinario(numero/2);
        }
        if(numero%2!=0){
            salida+="1";
        }else{
            salida+="0";
        }

        return salida;
    }

    public static Integer Binario(int numero){
        Integer salida=0;

        if(numero>1){
            salida = Integer.parseInt(convertirBinario(numero/2).toString());
        }
        if(numero%2!=0){
            salida = Integer.parseInt(salida.toString()+1);
        }else{
            salida = Integer.parseInt(salida.toString()+0);
        }

        return salida;
    }
}
