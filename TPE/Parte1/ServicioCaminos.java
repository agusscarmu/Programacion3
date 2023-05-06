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
    private List<List<Integer>> salida;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
        this.map = new HashMap<>();
        this.salida = new LinkedList<>();
	}

	public List<List<Integer>> caminos() {
        List<Integer> camino = new LinkedList<>();
        camino.add(origen);
        Iterator<Integer> adj = grafo.obtenerAdyacentes(origen);
        while(adj.hasNext()){
            int v = adj.next();
            System.out.println(v);
            int limite=this.lim;
            caminos(v,limite,camino);
        }
		return salida;
	}

    private void caminos(Integer v, int limite, List<Integer> camino){
        camino.add(v);
        if(limite>0){
            if(v.equals(destino)){
                salida.add(new LinkedList<>(camino));
            }else{
                Iterator<Integer> vertices = grafo.obtenerAdyacentes(v);
                while(vertices.hasNext()){
                    int vertice = vertices.next();
                    caminos(vertice, limite-1, camino);
                }
            }
        }
        camino.remove(camino.size()-1);
        
    }
}
