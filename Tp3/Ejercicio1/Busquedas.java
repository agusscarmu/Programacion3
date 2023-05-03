package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Busquedas<T> {
    
    public void DepthFirstSearch(Grafo<T> grafo){
        HashMap<Integer, String> map = new HashMap<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            map.put(vertices.next(), "NO_VISITED");
        }

        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while(vertices2.hasNext()){
            Integer v=vertices2.next();
            if(map.get(v)=="NO_VISITED"){
                DFS_visit(v,grafo,map);
            }
        }
    }

    public void DFS_visit(Integer v, Grafo<T> grafo, HashMap<Integer,String> map){
        map.put(v, "VISITED");
        System.out.println(v);
        Iterator<Integer> adj = grafo.obtenerAdyacentes(v);
        
        while(adj.hasNext()){
            Integer a = adj.next();
            
            if(map.get(a)=="NO_VISITED"){
                DFS_visit(a,grafo,map);
            }
        }
        
        map.put(v, "ALL_VISITED");

    }


    public void BreadthFirstSearch(Grafo<T> grafo){
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Integer> lista = new ArrayList<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            map.put(vertices.next(), "NO_VISITED");
        }

        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while(vertices2.hasNext()){
            Integer v=vertices2.next();
            if(map.get(v)=="NO_VISITED"){
                BFS_visit(v,grafo,map,lista);
            }
        }

    }

    public void BFS_visit(Integer v, Grafo<T> grafo, HashMap<Integer,String> map, ArrayList<Integer> lista){
        map.put(v, "VISITED");
        lista.add(v);

        System.out.println(lista);
        while(!lista.isEmpty()){
            Integer valor = lista.get(0);
            lista.remove(valor);
            Iterator<Integer> adj = grafo.obtenerAdyacentes(valor);
            while(adj.hasNext()){
                Integer vertice = adj.next();
                if(map.get(vertice)=="NO_VISITED"){
                    map.put(vertice, "VISITED");
                    lista.add(vertice);
                }
            }
            System.out.println(lista);
        }
    }
}
