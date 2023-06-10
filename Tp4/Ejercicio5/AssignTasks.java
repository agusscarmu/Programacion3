package Ejercicio5;

import java.util.LinkedList;

public class AssignTasks {
    
    private LinkedList<Procesador>listaProcesadores;
    private LinkedList<Integer>listaTareas;

    public AssignTasks(LinkedList<Procesador>listaProcesadores,LinkedList<Integer>listaTareas){
        this.listaProcesadores=listaProcesadores;
        this.listaTareas=listaTareas;
    }

    public LinkedList<Procesador> asignar(){
        OptTasks(getCopia(listaProcesadores));
        return listaProcesadores;
    }

    private void OptTasks(LinkedList<Procesador>listProc){

        if(listaTareas.isEmpty()){
            if(max(listProc)<max(listaProcesadores))
                listaProcesadores=getCopia(listProc);
        }else{
            Integer t = listaTareas.pop();
            for(int i=0;i<listProc.size();i++){
                listProc.get(i).agregarTarea(t);
                listProc.get(i).sumarTiempo(t);
                OptTasks(listProc);
                listProc.get(i).restarTiempo(t);
                listProc.get(i).borrarPrimerTarea();

            }
            listaTareas.addFirst(t);
            }
    }
        

    private LinkedList<Procesador> getCopia(LinkedList<Procesador> list){
        LinkedList<Procesador>s=new LinkedList<>();
        for(Procesador l:list){
            s.add(new Procesador(l));
        }
        return s;
    }

    private int max(LinkedList<Procesador>list){
        int r=0;

        for(Procesador l:list){
            int sum=l.getTiempo();
            if(sum>r)
                r=sum;
        }
        if(r==0){
            return Integer.MAX_VALUE;
        }
        return r;

    }
}
