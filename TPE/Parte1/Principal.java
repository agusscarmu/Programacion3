package Parte1;

public class Principal {
    
    public static void main(String[]args){

        Grafo<Integer> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);


        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 20);
        grafo.agregarArco(2, 4, 30);
        grafo.agregarArco(4, 1, 40);
        grafo.agregarArco(1, 5, 50);
        grafo.agregarArco(2, 5, 60);
        grafo.agregarArco(5, 4, 70);
        grafo.agregarArco(3, 5, 80);
        grafo.agregarArco(3, 6, 90);
        grafo.agregarArco(6, 5, 100);
        grafo.agregarArco(8, 5, 110);
        grafo.agregarArco(7, 3, 120);
        grafo.agregarArco(7, 6, 130);
        grafo.agregarArco(7, 8, 140);
        



        ServicioDFS dfs = new ServicioDFS(grafo); 
        ServicioBFS bfs = new ServicioBFS(grafo);

        // System.out.println(dfs.dfsForest().toString());
        // System.out.println(bfs.bfsForest().toString());

        // grafo.borrarVertice(1);

        ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, 2, 5, 4);
        System.out.println(servicioCaminos.caminos().toString());



        // Iterator<Arco<Integer>> it=grafo.obtenerArcos();
       
        
        // while(it.hasNext())
        // System.out.println(it.next());

        // System.out.println(grafo.cantidadVertices()+" "+grafo.cantidadArcos());
    }
}
        