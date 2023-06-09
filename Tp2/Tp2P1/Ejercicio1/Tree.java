package Tp2.Tp2P1.Ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    
    public TreeNode raiz;
    
    public void add(Integer valor){
        if(raiz==null){
            raiz=new TreeNode(valor);
        }else{
            add(this.raiz,valor);
        }
    }
    
    public void add(TreeNode nodo, Integer valor){
        TreeNode tmp = new TreeNode(valor);
        if(nodo.getValor()<valor){
            if(nodo.getDer()==null){
                nodo.setDer(tmp);
            }else{
                add(nodo.getDer(),valor);
            }
        }else if(nodo.getValor()>valor){
            if(nodo.getIzq()==null){
                nodo.setIzq(tmp);
            }else{
                add(nodo.getIzq(),valor);
            }
        }
    }
    public Integer getRoot(){
        return raiz.getValor();
    }
    
    public boolean isEmpty(){
        return raiz==null;
    }
    
    public boolean hasElem(Integer valor){
        return hasElem(this.raiz,valor);
    }
    
    public void printPosOrder(){
        printPosOrder(this.raiz);
    }
    
    public List<Integer> getFrontera(){
        return getFrontera(this.raiz);
    }
    
    public List<Integer> getLongestBranch(){
        return getLongestBranch(this.raiz);
    }
    
    private List<Integer> getLongestBranch(TreeNode nodo){
        List<Integer> listaIzquierda = new LinkedList<>();
        List<Integer> listaDerecha = new LinkedList<>();

        if(nodo.getIzq()!=null)
            listaIzquierda=getLongestBranch(nodo.getIzq());
        if(nodo.getDer()!=null)
            listaDerecha=getLongestBranch(nodo.getDer());
   
        if(listaIzquierda.size()>listaDerecha.size()){
            listaIzquierda.add(0, nodo.getInfo());
            return listaIzquierda;
        }else{
            listaDerecha.add(0, nodo.getInfo());
            return listaDerecha;
        }
    }
    
    public int getHeight(){
        return getHeight(this.raiz);
    }

    private int getHeight(TreeNode nodo){
        int hIzq=0,hDer=0;
        if(nodo.getIzq()!=null)
            hIzq=getHeight(nodo.getIzq())+1;
        if(nodo.getDer()!=null)
            hDer=getHeight(nodo.getDer())+1;

        if(hIzq<hDer){
            return hDer;
        }else
            return hIzq;
    }
    
    private List<Integer> getFrontera(TreeNode nodo){
        List<Integer> salida= new ArrayList<>();
        if(nodo.getIzq()!=null)
            salida.addAll(getFrontera(nodo.getIzq()));
        if(nodo.getDer()!=null)
            salida.addAll(getFrontera(nodo.getDer()));
        
        if(nodo.getDer()==null && nodo.getIzq()==null){
            salida.add(nodo.getValor());
        }
        return salida;
    }
    
    private void printPosOrder(TreeNode nodo){
        if(nodo==null){
            System.out.print("- ");
            return;
        }
        printPosOrder(nodo.getIzq());
        printPosOrder(nodo.getDer());
        System.out.print(nodo.getValor()+" ");
    }

    public void printInOrder(){
        printInOrder(this.raiz);
    }

    private void printInOrder(TreeNode nodo){
        if(nodo==null){
            System.out.print("- ");
            return;
        }
        printInOrder(nodo.getIzq());
        System.out.print(nodo.getValor()+" ");
        printInOrder(nodo.getDer());
    }

    public void printPreOrder(){
        printPreOrder(this.raiz);
    }

    public Integer getMaxElem(){
        return getMaxElem(this.raiz);
    }

    private Integer getMaxElem(TreeNode nodo){
        if(nodo.getDer()==null){
            return nodo.getInfo();
        }else{
            return getMaxElem(nodo.getDer());
        }
    }

    private TreeNode extractMaxElem(TreeNode nodo){
        if(nodo.getDer()==null){
            TreeNode extract=nodo;
            nodo=null;
            return extract;
        }else{
            return extractMaxElem(nodo.getDer());
        }
    }

    private TreeNode extractMinElem(TreeNode nodo){
        if(nodo.getIzq()==null){
            TreeNode extract=nodo;
            nodo=null;
            return extract;
        }else{
            return extractMinElem(nodo.getIzq());
        }
    }

    private void printPreOrder(TreeNode nodo){
        if(nodo==null){
            System.out.print("- ");
            return;
        }
        System.out.print(nodo.getValor()+" ");
        printPreOrder(nodo.getIzq());
        printPreOrder(nodo.getDer());
    }


    private boolean hasElem(TreeNode nodo, Integer valor){
        if(nodo.getValor()>valor){
            if(nodo.getIzq()!=null){
                return hasElem(nodo.getIzq(),valor);
            }else{
                return false;
            }
        }else if(nodo.getValor()<valor){
            if(nodo.getDer()!=null){
                return hasElem(nodo.getDer(),valor);
            }else{
                return false;
            }
        }else
            return true;
    }

    public List<Integer> getElemsAtLevel(int lvl){
        return getElemsAtLevel(this.raiz,lvl,0);
    }

    private List<Integer> getElemsAtLevel(TreeNode nodo, int lvl, int lvlactual){
        List<Integer> salida = new ArrayList<>();
        if(lvlactual<lvl){
        if(nodo.getIzq()!=null)
            salida.addAll(getElemsAtLevel(nodo.getIzq(), lvl, lvlactual+1));
        if(nodo.getDer()!=null)
            salida.addAll(getElemsAtLevel(nodo.getDer(), lvl, lvlactual+1));
        }else{
            salida.add(nodo.getInfo());
        }
        return salida;
    }

    public void Delete(Integer valor){
        Delete(this.raiz,valor,null);
    }

    private void Delete(TreeNode nodo, Integer valor, TreeNode nodoPadre){
        if(nodo.getInfo()==valor){
            if(nodoPadre==null){
                TreeNode tmp = extractMaxElem(nodo.getIzq());
                if(tmp.getInfo()!=nodo.getIzq().getInfo())
                    tmp.setIzq(nodo.getIzq());
                tmp.setDer(nodo.getDer());
                raiz=tmp;
                return;
            }
            if(nodo.getIzq()==null && nodo.getDer()==null){
                if(nodo.getInfo()<nodoPadre.getInfo()){
                    nodoPadre.setIzq(null);
                }else{
                    nodoPadre.setDer(null);
                }
            }else if(nodo.getDer()==null){
                if(nodo.getInfo()<nodoPadre.getInfo()){
                    nodoPadre.setIzq(nodo.getIzq());
                }else{
                    nodoPadre.setDer(nodo.getIzq());
                }
            }else if(nodo.getIzq()==null){
                if(nodo.getInfo()<nodoPadre.getInfo()){
                    nodoPadre.setIzq(nodo.getDer());
                }else{
                    nodoPadre.setDer(nodo.getDer());
                }
            }else{
                if(valor>nodoPadre.getInfo()){
                    TreeNode tmp = extractMaxElem(nodo.getIzq());
                    tmp.setDer(nodo.getDer());
                    if(nodo.getIzq().getValor()!=tmp.getValor())
                        tmp.setIzq(nodo.getIzq());
                    nodoPadre.setDer(tmp);
                }else{
                    TreeNode tmp = extractMinElem(nodo.getDer());
                    tmp.setIzq(nodo.getIzq());
                    if(nodo.getDer().getValor()!=tmp.getValor())
                        tmp.setDer(nodo.getDer());
                    nodoPadre.setIzq(tmp);
                }

            }
            return;
        }else{
            if(nodo.getIzq()!=null)
                Delete(nodo.getIzq(), valor, nodo);
            if(nodo.getDer()!=null)
                Delete(nodo.getDer(), valor, nodo);
        }
    }

    public int Sum(){
        return Sum(this.raiz);
    }

    private int Sum(TreeNode nodo){
        int salida=nodo.getInfo();
        if(nodo.getIzq()!=null){
            salida+=Sum(nodo.getIzq());
        }
        if(nodo.getDer()!=null){
            salida+=Sum(nodo.getDer());
        }
        return salida;
    }

    public List<Integer> getListOver(int num){
        return getListOver(this.raiz,num);
    }

    private List<Integer> getListOver(TreeNode nodo, int num){
        List<Integer> salida = new ArrayList<>();
        if(nodo.getIzq()!=null)
            salida.addAll(getListOver(nodo.getIzq(), num));
        if(nodo.getInfo()>num){
            salida.add(nodo.getInfo());
        }
        if(nodo.getDer()!=null)
            salida.addAll(getListOver(nodo.getDer(), num));
        return salida;
    }
}
