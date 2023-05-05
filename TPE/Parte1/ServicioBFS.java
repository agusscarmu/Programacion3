package Parte1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioBFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> map;
    private List<Integer> lista;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.map = new HashMap<>(); 
        this.lista = new LinkedList<>();
	}
	
	public List<Integer> bfsForest() {
		Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            map.put(vertices.next(), "NO_VISITED");
        }

        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            Integer v=vertices.next();
            if(map.get(v)=="NO_VISITED"){
               BFS_visit(v); 
            }
        }
		return lista;
	}

    private void BFS_visit(Integer v){
        List<Integer> verticesVisitados = new LinkedList<>();
        map.put(v, "VISITED");
        lista.add(v);
        verticesVisitados.add(v);

        while(!verticesVisitados.isEmpty()){
            Integer valor = verticesVisitados.get(0);
            verticesVisitados.remove(valor);
            Iterator<Integer> adj = grafo.obtenerAdyacentes(valor);
            while(adj.hasNext()){
                Integer vertice = adj.next();
                if(map.get(vertice)=="NO_VISITED"){
                    map.put(vertice, "VISITED");
                    verticesVisitados.add(vertice);
                    lista.add(vertice);
                }
            }

        }
    }
}
