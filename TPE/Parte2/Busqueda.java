import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import Parte1.Arco;
import Parte1.GrafoNoDirigido;

public class Busqueda {
    

    private int saltos, mejorKm;
    private HashMap<Integer,Boolean> visitados;
    private LinkedList<Integer> solucion;
    private GrafoNoDirigido<Integer> grafo;

    public Busqueda(GrafoNoDirigido<Integer> grafo){
        this.grafo=grafo;
        this.solucion=new LinkedList<>();
        this.visitados=new HashMap<>();
    }

    
    public void greedy(){
        mejorKm=0;
        saltos=0;
        LinkedList<Integer> C = C();
        Integer v = C.getFirst();
        while (!C.isEmpty()){
            saltos++;
            C.remove(v);
            solucion.add(v);
            v = mejorAdyacente(v,C);
        }
        imprimirSolucion("Greedy");
        solucion.clear();
    }
    
    public void backtracking(){
        mejorKm=Integer.MAX_VALUE;
        saltos=0;
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            visitados.put(vertices.next(), false);
        }
        vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            saltos++;
            backtracking(vertices.next(), new LinkedList<>(), 0);
        }
        imprimirSolucion("Backtracking");
        solucion.clear();
    }

    private void backtracking(Integer vertice, LinkedList<Integer> posibleSolucion, int km){
        saltos++;
        posibleSolucion.addFirst(vertice);
        visitados.put(vertice, true);
        
        if(grafo.cantidadVertices()==posibleSolucion.size()){
            solucion=new LinkedList<>(posibleSolucion);
            mejorKm=km;        
        }else{
            Iterator<Integer>adj=grafo.obtenerAdyacentes(vertice);
            while(adj.hasNext()){
                Integer a = adj.next();
                Arco<Integer> arco=grafo.obtenerArco(a, vertice);
                if(!visitados.get(a) && (km+arco.getEtiqueta())<mejorKm){
                    backtracking(a, posibleSolucion, km+arco.getEtiqueta());
                }
            }    
        }
        visitados.put(vertice, false);
        posibleSolucion.removeFirst();
    }

    private void imprimirSolucion(String algoritmo){
        System.out.println(algoritmo);
        System.out.println(solucion.toString());
        System.out.println(mejorKm + " Kms");
        System.out.println(saltos + " Metrica");
    }

    private Integer mejorAdyacente(Integer v, LinkedList<Integer> C){
        Integer r=0;
        Integer mejorDistancia=Integer.MAX_VALUE;
        Iterator<Integer> adj= grafo.obtenerAdyacentes(v);
        while(adj.hasNext()){
            // saltos++;
            Integer a = adj.next();
            if(C.contains(a)){
                Arco<Integer> arc = grafo.obtenerArco(v, a);
                if(arc.getEtiqueta()<mejorDistancia){
                    mejorDistancia=arc.getEtiqueta();
                    r=a;
                }
            }
        }
        if(r!=0){
            Arco<Integer> arc = grafo.obtenerArco(r, v);
            mejorKm+=arc.getEtiqueta();
        }
        return r;
    }

    private LinkedList<Integer> C(){
        LinkedList<Integer> conjunto = new LinkedList<>();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            conjunto.add(vertices.next());
        }
        return conjunto;
    }

}

