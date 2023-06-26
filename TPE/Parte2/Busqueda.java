import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import Parte1.Arco;
import Parte1.GrafoNoDirigido;

public class Busqueda {
    

    private int saltos, mejorKm;
    private HashMap<Arco<Integer>,Boolean> visitados;
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
        int[]menor_costo=new int[grafo.cantidadVertices()+1];
        int[]mas_cercano=new int[grafo.cantidadVertices()+1];
        int[]visitado=new int[grafo.cantidadVertices()+1];
        // Iterator<Integer> vertices = grafo.obtenerVertices();
        // Integer pV=vertices.next();
        for(int i = 2; i<=grafo.cantidadVertices();i++){
            menor_costo[i]=grafo.obtenerArco(1, i).getEtiqueta();
            mas_cercano[i]=1;
            visitado[i]=0;
        }
        for(int i=2;i<menor_costo.length;i++){
            saltos++;
            Integer w = min(menor_costo,visitado);
            visitado[w]=1;
            Arco<Integer> a = grafo.obtenerArco(w, mas_cercano[w]);
            solucion.add(a);
            mejorKm+=a.getEtiqueta();
            for(int j=2;j<menor_costo.length;j++){
                saltos++;
                if(costo(w,j) < menor_costo[j]){
                    menor_costo[j]=grafo.obtenerArco(w, j).getEtiqueta();
                    mas_cercano[j]=w;
                }
            }
        }
        imprimirSolucion("Greedy");

    }

    public int costo(int w, int j){
        try{
            return grafo.obtenerArco(w, j).getEtiqueta();
        }catch(Exception e){
            return Integer.MAX_VALUE;
        }
    }
    
    public Integer min(int[]menor_costo, int[]s){
        Integer menor = Integer.MAX_VALUE;
        for(int i=2;i<menor_costo.length;i++){
            if(menor_costo[i]<menor && s[i]!=1){
                menor=i;
            }
        }
        return menor;
    }
    
    public void backtracking(){
        mejorKm=Integer.MAX_VALUE;
        saltos=0;
        Iterator<Arco<Integer>> arcos = grafo.obtenerArcos();
        LinkedList<Arco<Integer>> listaArcos = new LinkedList<>();
        while(arcos.hasNext()){
            Arco<Integer> arc=arcos.next();
            visitados.put(arc, false);
            listaArcos.addFirst(arc);
        }
        
        backtracking(listaArcos.getFirst(),listaArcos, new LinkedList<>(), 0);
        
        imprimirSolucion("Backtracking");
        solucion.clear();
    }

    private void backtracking(Arco<Integer> arcoActual,LinkedList<Arco<Integer>> arcos ,LinkedList<Arco<Integer>> l, int km){
        saltos++;
        visitados.put(arcoActual, true);
        
        if(isFullyConnected(l)){ 
            if(mejorKm>km){
                solucion=new LinkedList<>(l);
                mejorKm=km; 
            }       
        }else{
            Iterator<Arco<Integer>> iterador = grafo.obtenerArcos();
            while(iterador.hasNext()){
                Arco<Integer> a = iterador.next();
                if(!visitados.get(a) && (km+a.getEtiqueta())<mejorKm && inSolution(l,a)){
                    l.addFirst(a);
                    backtracking(a,arcos ,l, km+a.getEtiqueta());
                    l.removeFirst();
                }
            }    
        }
        visitados.put(arcoActual, false);
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
                saltos++;
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

    public boolean isFullyConnected(LinkedList<Arco<Integer>> l) {
        UnionFind uf = new UnionFind(grafo.cantidadVertices());

        for (Arco<Integer> arco:l) {
            int u = arco.getVerticeOrigen()-1;
            int v = arco.getVerticeDestino()-1;
            uf.union(u, v);
        }

        int representative = uf.find(0);
        for (int i = 1; i < grafo.cantidadVertices(); i++) {
            if (uf.find(i) != representative) {
                return false;
            }
        }

        return true;
    }

    public boolean inSolution(LinkedList<Arco<Integer>> l, Arco<Integer> arcoAct){
        UnionFind uf = new UnionFind(grafo.cantidadVertices());

        for (Arco<Integer> arco:l) {
            int u = arco.getVerticeOrigen()-1;
            int v = arco.getVerticeDestino()-1;
            uf.union(u, v);
        }

        //Controla que los vertices del arco no tengan el mismo padre, de ser asi, retorna falso
        int representative = uf.find(0);
        if (uf.find(arcoAct.getVerticeOrigen()-1) != representative && uf.find(arcoAct.getVerticeDestino()-1) != representative) {
            return false;
        }
        
        
        return true;
    }
    
}
