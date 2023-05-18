package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;

public class SalidaLaberinto {
    private CasillaLaberinto[][]laberinto;
    private ArrayList<Integer> salida;
    private int sumaMenor;
    private HashMap<CasillaLaberinto,String> casillasVisitadas;

    public SalidaLaberinto(CasillaLaberinto[][]laberinto){
        this.laberinto=laberinto;
        this.salida=new ArrayList<>();
        this.sumaMenor=Integer.MAX_VALUE;
        this.casillasVisitadas=new HashMap<>();
        for(int i=0;i<laberinto.length;i++){
            for(int j=0;j<laberinto[i].length;j++){
                casillasVisitadas.put(laberinto[i][j], "NO_VISITED");
            }
        }
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
        casillasVisitadas.put(laberinto[posicionY][posicionX], "VISITED");
        sumaValores+=laberinto[posicionY][posicionX].getValor();
        caminos.add(laberinto[posicionY][posicionX].getValor());

        if(laberinto[posicionY][posicionX].getValor()==fin){
                salida=new ArrayList<>(caminos);
                sumaMenor=sumaValores;
        }else{
            if(sumaValores<sumaMenor){
                if(laberinto[posicionY][posicionX].arriba()){
                    if(casillasVisitadas.get(laberinto[posicionY-1][posicionX])=="NO_VISITED")
                        buscarSalida(posicionX, posicionY-1, caminos, fin, sumaValores);
                }
                if(laberinto[posicionY][posicionX].abajo()){
                    if(casillasVisitadas.get(laberinto[posicionY+1][posicionX])=="NO_VISITED")
                        buscarSalida(posicionX, posicionY+1, caminos, fin, sumaValores);
                }
                if(laberinto[posicionY][posicionX].izquierda()){
                    if(casillasVisitadas.get(laberinto[posicionY][posicionX-1])=="NO_VISITED")
                        buscarSalida(posicionX-1, posicionY, caminos, fin, sumaValores);
                }
                if(laberinto[posicionY][posicionX].derecha()){
                    if(casillasVisitadas.get(laberinto[posicionY][posicionX+1])=="NO_VISITED")
                        buscarSalida(posicionX+1, posicionY, caminos, fin, sumaValores);
                }
            }
        }
        casillasVisitadas.put(laberinto[posicionY][posicionX], "NO_VISITED");
        caminos.remove(caminos.size()-1);
    }
}
