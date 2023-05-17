package Ejercicio2;

import java.util.ArrayList;

public class SalidaLaberinto {
    private CasillaLaberinto[][]laberinto;
    private ArrayList<Integer> salida;
    private int sumaMenor;

    public SalidaLaberinto(CasillaLaberinto[][]laberinto){
        this.laberinto=laberinto;
        this.salida=new ArrayList<>();
        this.sumaMenor=0;
    }

    public ArrayList<Integer> buscarSalida(int comienzo, int fin){
        ArrayList<Integer> caminos = new ArrayList<>();
        int posicionX=0, posicionY=0;
        boolean posicionEncontrada=false;

        for(int i=0;i<laberinto.length && !posicionEncontrada;i++){
            for(int j=0; j<laberinto[i].length && !posicionEncontrada; i++){
                if(laberinto[i][j].getValor()==comienzo){
                    posicionX=j;
                    posicionY=i;
                    posicionEncontrada=true;
                }
            }
        }
        buscarSalida(posicionX, posicionY, caminos, fin, 0);
        return salida;
    }

    private void buscarSalida(int posicionX, int posicionY, ArrayList<Integer> caminos, int fin, int sumaValores){
        sumaValores+=laberinto[posicionY][posicionX].getValor();
        caminos.add(laberinto[posicionY][posicionX].getValor());

        if(laberinto[posicionY][posicionX].getValor()==fin){
            if(sumaMenor==0 || sumaValores<sumaMenor){
                salida=new ArrayList<>(caminos);
            }
        }else{
            if(laberinto[posicionY][posicionX].arriba()){
                buscarSalida(posicionX, posicionY-1, caminos, fin, sumaValores);
            }
            if(laberinto[posicionY][posicionX].abajo()){
                buscarSalida(posicionX, posicionY+1, caminos, fin, sumaValores);
            }
            if(laberinto[posicionY][posicionX].izquierda()){
                buscarSalida(posicionX-1, posicionY, caminos, fin, sumaValores);
            }
            if(laberinto[posicionY][posicionX].derecha()){
                buscarSalida(posicionX+1, posicionY, caminos, fin, sumaValores);
            }
        }

        caminos.remove(caminos.size()-1);
    }
}
