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
        // grafo.agregarVertice(9);
        // grafo.agregarVertice(10);
        // grafo.agregarVertice(11);
        // grafo.agregarVertice(12);
        // grafo.agregarVertice(13);
        // grafo.agregarVertice(14);
        // grafo.agregarVertice(15);

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



        // grafo.agregarArco(1, 2, 10);
        // grafo.agregarArco(1, 3, 20);
        // grafo.agregarArco(1, 5, 30);
        // grafo.agregarArco(2, 3, 40);
        // grafo.agregarArco(2, 6, 50);
        // grafo.agregarArco(6, 12, 60);
        // grafo.agregarArco(12, 2, 70);
        // grafo.agregarArco(3, 4, 80);
        // grafo.agregarArco(3, 8, 90);
        // grafo.agregarArco(4, 9, 100);
        // grafo.agregarArco(4, 8, 110);
        // grafo.agregarArco(5, 11, 120);
        // grafo.agregarArco(5, 7, 130);
        // grafo.agregarArco(7, 6, 140);
        // grafo.agregarArco(6, 13, 150);
        // grafo.agregarArco(11, 10, 160);
        // grafo.agregarArco(14, 11, 170);
        // grafo.agregarArco(15, 14, 180);
        // grafo.agregarArco(13, 15, 190);


        ServicioDFS dfs = new ServicioDFS(grafo); 
        ServicioBFS bfs = new ServicioBFS(grafo);

        System.out.println(dfs.dfsForest().toString());

    }
}
