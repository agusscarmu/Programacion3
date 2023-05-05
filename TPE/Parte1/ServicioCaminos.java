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
        int saltos=0;
		List<List<Integer>> salida = new LinkedList<>();
    
        // Iterator<Integer> vertices = grafo.obtenerVertices();
        // while(vertices.hasNext()){
        //     map.put(vertices.next(), "NO_VISITED");
        // }
        Iterator<Integer> adj = grafo.obtenerAdyacentes(origen);
        while(adj.hasNext()){
            salida.add(caminos(saltos));
        }
		return salida;
	}

    private List<Integer> caminos(int saltos){
        List<Integer> salida = new LinkedList<>();

        return salida;
    }
}
