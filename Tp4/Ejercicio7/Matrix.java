package Ejercicio7;

import java.util.LinkedList;

public class Matrix {
    
    private int [][]matriz;
    private int n,limit;
    private LinkedList<Integer> elements;
    private boolean posicionado;

    public Matrix(int n){
        this.n=n;
        this.elements = new LinkedList<>();
        this.limit=50;
        this.matriz = new int [n][n];
        this.posicionado=false;
        cargarElems();
    }

    public void cargar(){
        for(int i=0;i<n;i++){
            posicionado=false;
            cargar(new LinkedList<>(elements),new LinkedList<>(),i);
        }
    }
    
    private void cargar(LinkedList<Integer> elems,LinkedList<Integer> temp, int fil){

        if(temp.size()<=n && sum(temp)==limit){
            matriz[fil]=toArray(temp);
            elements.removeAll(temp);
            posicionado=true;
        }else{
            if(temp.size()<n && sum(temp)<limit){
                for(int i=elems.size()-1;i>=0 && posicionado==false;i--){
                    Integer e=elems.get(i);
                    temp.addFirst(e);
                    elems.remove(e);
                    cargar(elems, temp, fil);
                    elems.addFirst(e);
                    temp.remove(e);
                }
            }
        }
    }
    
    private int[] toArray(LinkedList<Integer>temp){
        int[]salida=new int[n];
        for(int i=0;i<salida.length;i++){
            try{
            salida[i]=temp.get(i);
            }catch(Exception e){
                salida[i]=0;
            }
        }
        return salida;
    }
    private int sum(LinkedList<Integer>arr){
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }
        return sum;
    }
    
    public void setLimit(int l){
        this.limit=l;
    }
    
    public void getMatriz(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println();
        }
    }
    
    public void cargarElems(){
        for(int i=1;i<n*n;i++){
            Integer num=i;
            elements.add(num);
        }
    }

    public LinkedList<Integer> getElems(){
        return elements;
    } 
}
