package Tp2.Tp2P1.Ejercicio1;

public class TreeNode {
    private Integer info;
    private TreeNode der, izq;

    public Integer getInfo() {
        return this.info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public TreeNode(Integer info){
        this.info=info;
    }

    public Integer getValor(){
        return info;
    }

    public void setDer(TreeNode valor){
        this.der=valor;
    }

    public void setIzq(TreeNode valor){
        this.izq=valor;
    }

    public TreeNode getDer(){
        return der;
    }

    public TreeNode getIzq(){
        return izq;
    }

}
