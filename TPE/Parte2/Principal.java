import Parte1.GrafoNoDirigido;

public class Principal {

	public static void main(String[] args) {

		String path = "./Parte2/dataset.txt";
		CSVReader reader = new CSVReader(path);
		reader.read();

		GrafoNoDirigido<Integer> grafo = reader.traerGrafo();
		System.out.println(grafo.cantidadVertices());
		Busqueda busqueda = new Busqueda(grafo);
		System.out.println(grafo.obtenerArco(11, 5));
		// busqueda.backtracking();
		System.out.println("---------------------------------------");
		busqueda.greedy();

		
	}

}
