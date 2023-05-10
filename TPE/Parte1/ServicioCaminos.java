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
    private HashMap<Arco<?>, String> map;
    private List<List<Integer>> salida;
    private List<Integer> camino;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
        this.map = new HashMap<>();
        this.salida = new LinkedList<>();
        this.camino = new LinkedList<>();
	}

	public List<List<Integer>> caminos() {
        Iterator<?> arcos = grafo.obtenerArcos();
        while(arcos.hasNext()){
            map.put((Arco<?>) arcos.next(), "NO_VISITED");
        }
        camino.add(origen);
        Iterator<Integer> adj = grafo.obtenerAdyacentes(origen);
        while(adj.hasNext()){
            int v = adj.next();
            Arco<?>arco = grafo.obtenerArco(origen, v);
            caminos(v,lim,arco);
        }
		return salida;
	}

    private void caminos(Integer v, int limite, Arco<?> arcoActual){
        camino.add(v);
        map.put(arcoActual, "VISITED");
        if(limite>0){
            if(v.equals(destino)){
                salida.add(new LinkedList<>(camino)); //Es necesaria la copia? si no la genero me remueve los originales
            }else{
                Iterator<Integer> vertices = grafo.obtenerAdyacentes(v);
                while(vertices.hasNext()){
                    int vertice = vertices.next();
                    Arco<?>arco = grafo.obtenerArco(v, vertice);//Si devuelve copia no anda, esta bien devolver el arco original?
                    // System.out.println(map.get(arco));
                    if(map.get(arco)=="NO_VISITED") 
                        caminos(vertice, limite-1, arco); 
                }
            }
        }
        map.put(arcoActual, "NO_VISITED");
        camino.remove(camino.size()-1);
        
    }
}
