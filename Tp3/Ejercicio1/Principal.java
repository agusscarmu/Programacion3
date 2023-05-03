package Ejercicio1;

public class Principal {
    
    public static void main(String[]args){
        Grafo<Integer> grafo = new GrafoDirigido();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArco(1, 2, 20);
        grafo.agregarArco(2, 3, 40);
        grafo.agregarArco(1, 3, 30);

        // grafo.borrarVertice(1);
        // System.out.println(grafo.obtenerArco(1, 2));

        // Iterator<Arco<Integer>> g = grafo.obtenerArcos();

        // while(g.hasNext()){
        //     System.out.println(g.next());
        // }
        System.out.println(grafo.contieneVertice(6));
        Busquedas<Integer> busquedas = new Busquedas<>();
        
        // busquedas.DepthFirstSearch(grafo);
        // busquedas.BreadthFirstSearch(grafo);
    }
}
