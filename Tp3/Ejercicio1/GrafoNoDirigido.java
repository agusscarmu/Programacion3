package Ejercicio1;

public class GrafoNoDirigido extends GrafoDirigido{
    
    @Override
    public void agregarArco(int vertice1, int vertice2, Integer etiqueta){
        super.agregarArco(vertice1, vertice2, etiqueta);
        super.agregarArco(vertice2, vertice1, etiqueta);
    }

    @Override
    public void borrarArco(int vertice1, int vertice2){
        super.borrarArco(vertice1, vertice2);
        super.borrarArco(vertice2, vertice1);
    }
}
