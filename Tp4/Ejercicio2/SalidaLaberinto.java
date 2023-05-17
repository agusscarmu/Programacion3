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
        buscarSalida(posicionX, posicionY, caminos, fin);
        return salida;
    }

    private void buscarSalida(int posicionX, int posicionY, ArrayList<Integer> caminos, int fin){
        caminos.add(laberinto[posicionY][posicionX].getValor());

        if(laberinto[posicionY][posicionX].getValor()==fin){
            if(caminos.size()<salida.size() || salida.isEmpty()){
                salida=new ArrayList<>(caminos);
            }
        }else{
            if(laberinto[posicionY][posicionX].arriba()){
                buscarSalida(posicionX, posicionY-1, caminos, fin);
            }
            if(laberinto[posicionY][posicionX].abajo()){
                buscarSalida(posicionX, posicionY+1, caminos, fin);
            }
            if(laberinto[posicionY][posicionX].izquierda()){
                buscarSalida(posicionX-1, posicionY, caminos, fin);
            }
            if(laberinto[posicionY][posicionX].derecha()){
                buscarSalida(posicionX+1, posicionY, caminos, fin);
            }
        }

        caminos.remove(caminos.size()-1);
    }
}
