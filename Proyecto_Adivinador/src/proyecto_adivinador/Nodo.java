/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_adivinador;

/**
 *
 * @author Daniel
 */
public class Nodo{
    
    private String data;
    private Nodo left;
    private Nodo right;
    
    
    Nodo(Object info){        
        this.data = (String) info;
        this.left = this.right = null;        
    }

    public Nodo(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public void imprimirNodo(Nodo n) {
		System.out.print(n.data + " ");
	}
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

//    public Object getInfo() {
//        return info;
//    }
//
//    public void setInfo(Object info) {
//        this.info = info;
//    }
    
    
    
    
    
}
