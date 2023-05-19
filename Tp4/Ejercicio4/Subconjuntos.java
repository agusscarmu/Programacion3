package Ejercicio4;

import java.util.List;

public class Subconjuntos {
    
    List<Integer> subconjunto1,subconjunto2;
    
    public Subconjuntos(List<Integer> subconjunto1,List<Integer> subconjunto2){
        this.subconjunto1=subconjunto1;
        this.subconjunto2=subconjunto2;
    }

    public List<Integer> getSubconjunto1() {
        return subconjunto1;
    }
    
    public void setSubconjunto1(List<Integer> subconjunto1) {
        this.subconjunto1 = subconjunto1;
    }
    
    public List<Integer> getSubconjunto2() {
        return subconjunto2;
    }
    
    public void setSubconjunto2(List<Integer> subconjunto2) {
        this.subconjunto2 = subconjunto2;
    }

    @Override
    public String toString() {
        return "\nSubconjunto 1: "+subconjunto1.toString()+"\nSubconjunto 2:"+subconjunto2.toString()+"\n";
    }
}
