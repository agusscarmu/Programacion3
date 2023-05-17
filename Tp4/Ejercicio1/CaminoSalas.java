package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoSalas {
    
    private int entrada,salida;
    private ArrayList<Integer> camino;
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, String> salasVisitadas;

    public CaminoSalas(GrafoDirigido<Integer> grafo, int entrada, int salida){
        this.entrada=entrada;
        this.salida=salida;
        this.camino=new ArrayList<>();
        this.grafo=grafo;
        this.salasVisitadas=new HashMap<>();
    }

    public ArrayList<Integer> caminoLargo(){
        ArrayList<Integer>caminosPosibles=new ArrayList<>();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            salasVisitadas.put(vertices.next(), "NO_VISITED");
        }
        caminoLargo(entrada, caminosPosibles);
        return camino;
    }

    private void caminoLargo(int actual, ArrayList<Integer> caminos){
        caminos.add(actual);
        salasVisitadas.put(actual, "VISITED");
        if(actual==salida){
            if(caminos.size()>camino.size()){
                camino=new ArrayList<>(caminos);
            }
        }else{
            Iterator<Integer> vertices = grafo.obtenerAdyacentes(actual);
            while(vertices.hasNext()){
                int v=vertices.next();
                if(salasVisitadas.get(v)!="VISITED")
                    caminoLargo(v,caminos);
            }
        }
        caminos.remove(caminos.size()-1);
        salasVisitadas.put(actual, "NO_VISITED");
    }
}
