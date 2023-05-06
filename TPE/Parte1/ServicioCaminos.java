package Parte1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCaminos {
    private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
    private HashMap<Integer, String> map;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
        this.map= new HashMap<>();
	}

	public List<List<Integer>> caminos() {
        List<List<Integer>> salida = new LinkedList<>();
        List<Integer> camino = new LinkedList<>();
        camino.add(origen);
        Iterator<Integer> adj = grafo.obtenerAdyacentes(origen);
        while(adj.hasNext()){
            int v = adj.next();
            System.out.println(v);
            int limite=this.lim;
            caminos(v,limite,camino,salida);
        }
		return salida;
	}

    private void caminos(Integer v, int limite, List<Integer> camino, List<List<Integer>> salida){
        camino.add(v);
        if(limite>0){
            if(v.equals(destino)){
                salida.add(camino);
            }else{
                Iterator<Integer> vertices = grafo.obtenerAdyacentes(v);
                while(vertices.hasNext()){
                    int vertice = vertices.next();
                    List<Integer> copia = new LinkedList<>(camino);
                    caminos(vertice, limite-1, copia, salida);
                }
            }
        }
        if(!v.equals(destino))
            camino.remove(v);
    }
}
