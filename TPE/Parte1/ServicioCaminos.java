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
            List<Integer> caminoCopia = new LinkedList<>(camino);
            int limite=this.lim;
            caminoCopia.add(v);
            caminos(v,limite,caminoCopia,salida);
        }
		return salida;
	}

    private void caminos(int v, int limite, List<Integer> camino, List<List<Integer>> salida){

        if(limite>0){
            if(v==destino){
                salida.add(camino);
            }else{
                Iterator<Integer> vertices = grafo.obtenerAdyacentes(v);
                while(vertices.hasNext()){
                    int vertice = vertices.next();
                    List<Integer> copia = new LinkedList<>(camino);
                    // if(!camino.contains(vertice)){
                        copia.add(vertice);
                        caminos(vertice, limite-1, copia, salida);
                    // }
                }
            }
        }
    }
}
