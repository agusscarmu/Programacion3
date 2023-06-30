import java.util.Iterator;
import java.util.LinkedList;

import Parte1.Arco;
import Parte1.GrafoNoDirigido;

public class Busqueda {
    

    private int saltos, mejorKm;
    private LinkedList<Arco<Integer>> solucion;
    private GrafoNoDirigido<Integer> grafo;

    public Busqueda(GrafoNoDirigido<Integer> grafo){
        this.grafo=grafo;
        this.solucion=new LinkedList<>();
    }

    //O(n^3)
    public void greedy(){
        mejorKm=0;
        saltos=0;
        int[]menor_costo=new int[grafo.cantidadVertices()+1];
        int[]mas_cercano=new int[grafo.cantidadVertices()+1];
        int[]s=new int[grafo.cantidadVertices()+1];
        for(int i = 2; i<=grafo.cantidadVertices();i++){
            menor_costo[i]=grafo.obtenerArco(1, i).getEtiqueta();
            mas_cercano[i]=1;
            s[i]=0;
        }

        for(int i=2;i<=grafo.cantidadVertices();i++){
            saltos++;
            Integer w = min(menor_costo,s);
            s[w]=1;
            Arco<Integer> a = grafo.obtenerArco(w, mas_cercano[w]);
            solucion.add(a);
            mejorKm+=a.getEtiqueta();
            for(int j=2;j<=grafo.cantidadVertices();j++){
                saltos++;
                if(costo(w,j) < menor_costo[j]){
                    menor_costo[j]=grafo.obtenerArco(w, j).getEtiqueta();
                    mas_cercano[j]=w;
                }
            }
        }
        imprimirSolucion("Greedy");

    }

    private int costo(int w, int j){
        try{
            return grafo.obtenerArco(w, j).getEtiqueta();
        }catch(Exception e){
            return Integer.MAX_VALUE;
        }
    }
    
    private Integer min(int[]menor_costo, int[]s){
        Integer menor = Integer.MAX_VALUE;
        Integer valorMenor = Integer.MAX_VALUE;
        for(int i=2;i<menor_costo.length;i++){
            if(menor_costo[i]<valorMenor && s[i]!=1){
                menor=i;
                valorMenor=menor_costo[i];
            }
        }
        return menor;
    }
    
    public void backtracking(){
        mejorKm=Integer.MAX_VALUE;
        saltos=0;      
        LinkedList<Arco<Integer>> arcs = obtenerArcosNoRepetidos();

        backtracking(null, arcs, new LinkedList<>(), 0);
        
        imprimirSolucion("Backtracking");
        solucion.clear();
    }

    //O(n!)
    private void backtracking(Arco<Integer> arcoActual, LinkedList<Arco<Integer>> arcos, LinkedList<Arco<Integer>> l, int km){
        saltos++;
        if((l.size() == grafo.cantidadVertices()-1)){ 
                solucion=new LinkedList<>(l);
                mejorKm=km; 
        }else{
            for(int i=0;i<arcos.size();i++){
                Arco<Integer> a = arcos.remove(i);
                if((km+a.getEtiqueta())<mejorKm && !enSolucion(l, a)){
                    l.addFirst(a);
                    backtracking(a, arcos, l,km+a.getEtiqueta());
                    l.removeFirst();
                }
                arcos.add(i, a);
            }    
        }
        
    }

    private void imprimirSolucion(String algoritmo){
        System.out.println(algoritmo);
        System.out.println(solucion.toString());
        System.out.println(mejorKm + " Kms");
        System.out.println(saltos + " Metrica");
    }


    /*
     * O(v + v*n)
     * Teniendo en cuenta que v = n-1  ->  O(n^2) 
     */
    private boolean enSolucion(LinkedList<Arco<Integer>> l, Arco<Integer> arcoAct){
        UnionFind uf = new UnionFind(grafo.cantidadVertices());

        /*
         * O(v*n)
         * v=cantidad de vertices
         * n=cantidad de arcos
         */
        for (Arco<Integer> arco:l) {
            int u = arco.getVerticeOrigen()-1;
            int v = arco.getVerticeDestino()-1;
            uf.union(u, v);
        }

        //O(v)
        if (uf.find(arcoAct.getVerticeOrigen()-1) != uf.find(arcoAct.getVerticeDestino()-1)) {
            return false;
        }
        
        
        return true;
    }
    
    private LinkedList<Arco<Integer>> obtenerArcosNoRepetidos(){
        LinkedList<Arco<Integer>> arcos = new LinkedList<>();
        Iterator<Arco<Integer>> a = grafo.obtenerArcos();
        //O(n^2)
        while(a.hasNext()){
            Arco<Integer> arc = a.next();
            if(notIn(arc, arcos)){
                arcos.add(arc);
            }
        }
        return arcos;
    }

    private boolean notIn(Arco<Integer> a, LinkedList<Arco<Integer>> lista){
        for(Arco<Integer> arc:lista){
            if(a.getVerticeDestino()==arc.getVerticeDestino() && a.getVerticeOrigen()==arc.getVerticeOrigen()
            || a.getVerticeDestino()==arc.getVerticeOrigen() && a.getVerticeOrigen()==arc.getVerticeDestino()){
                return false;
            }
        }
        return true;
    }
}