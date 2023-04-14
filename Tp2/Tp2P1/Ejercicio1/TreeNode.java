package Tp2.Tp2P1.Ejercicio1;

public class TreeNode {
    private Integer info;
    private TreeNode der, izq;
    private int hDer,hIzq;

    public Integer getInfo() {
        return this.info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public int getHDer() {
        if(der!=null)
            hDer+=der.getHDer();
        return this.hDer;
    }

    public int getHIzq() {
        if(izq!=null)
            hIzq+=izq.getHDer();
        return this.hIzq;
    }

    public TreeNode(Integer info){
        this.info=info;
    }

    public Integer getValor(){
        return info;
    }

    public void setDer(TreeNode valor){
        this.der=valor;
        hDer++;
    }

    public void setIzq(TreeNode valor){
        this.izq=valor;
        hIzq++;
    }

    public TreeNode getDer(){
        return der;
    }

    public TreeNode getIzq(){
        return izq;
    }

}
