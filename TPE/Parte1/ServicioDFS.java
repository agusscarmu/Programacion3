package Parte1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioDFS {

	private Grafo<?> grafo;
    private HashMap<Integer, String> map;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.map = new HashMap<>();
	}
	
	public List<Integer> dfsForest() {
        List<Integer> salida = new LinkedList<>();
		Iterator<Integer> vertices = grafo.obtenerVertices();
        
        while(vertices.hasNext()){
            map.put(vertices.next(), "NO_VISITED");
        }

        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v=vertices.next();
            if(map.get(v)=="NO_VISITED"){
                salida.addAll(DFS_visit(v)); 
            }
        }
		return salida;
	}

    private List<Integer> DFS_visit(Integer v){
        List<Integer> salida = new LinkedList<>();
        map.put(v, "VISITED");
        salida.add(v);
        Iterator<Integer> adj = grafo.obtenerAdyacentes(v);
        
        while(adj.hasNext()){
            Integer a = adj.next();
            
            if(map.get(a)=="NO_VISITED"){
                salida.addAll(DFS_visit(a));
            }
        }
        
        map.put(v, "ALL_VISITED");

        return salida;
    }


}