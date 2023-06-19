import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import Parte1.Arco;
import Parte1.GrafoNoDirigido;

public class Busqueda {
    

    private int saltos, mejorKm;
    private HashMap<Integer,Boolean> visitados;
    private LinkedList<Arco<Integer>> solucion;
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
            Integer vA = mejorAdyacente(v,C);
            if(vA!=null)
                solucion.add(grafo.obtenerArco(v, vA));
            v=vA;
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
            Integer v = vertices.next();
            backtracking(v, new LinkedList<>(), 0,1);
        }
        imprimirSolucion("Backtracking");
        solucion.clear();
    }

    private void backtracking(Integer vertice ,LinkedList<Arco<Integer>> l, int km, int solucionActual){
        saltos++;
        visitados.put(vertice, true);
        
        if(grafo.cantidadVertices()==solucionActual){
            solucion=new LinkedList<>(l);
            mejorKm=km;        
        }else{
            Iterator<Integer>adj=grafo.obtenerAdyacentes(vertice);
            while(adj.hasNext()){
                Integer a = adj.next();
                Arco<Integer> arco=grafo.obtenerArco(a, vertice);
                if(!visitados.get(a) && (km+arco.getEtiqueta())<mejorKm){
                    l.addFirst(arco);
                    backtracking(a ,l, km+arco.getEtiqueta(),solucionActual+1);
                    l.removeFirst();
                }
            }    
        }
        visitados.put(vertice, false);
    }

    private void imprimirSolucion(String algoritmo){
        System.out.println(algoritmo);
        System.out.println(solucion.toString());
        System.out.println(mejorKm + " Kms");
        System.out.println(saltos + " Metrica");
    }

    private Integer mejorAdyacente(Integer v, LinkedList<Integer> C){
        Integer r=null;
        Integer mejorDistancia=Integer.MAX_VALUE;
        if(v!=null){
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
            if(r!=null){
                Arco<Integer> arc = grafo.obtenerArco(r, v);
                mejorKm+=arc.getEtiqueta();
            }
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

