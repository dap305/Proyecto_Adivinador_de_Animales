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
public class Arbol_Binario{
    //Atributos
    private static final int COUNT = 30; 
    private String nombre;
    private Nodo root;
    public static String cadenaInor="";
    public static String cadenaPreor="";
    public String s = "";
    
            
    
    //Constructor
    public Arbol_Binario(String nombre) {
        this.nombre = nombre;
    }
    
    public Arbol_Binario(){
        this.root = null;
    }
    
    public boolean esVacio(){
        return this.getRoot() == null;
    }
    
    public boolean nodoVacio( Nodo nodo){
        return nodo == null;
    }
    
    public void insertarRoot(String data) {
		root = new Nodo(data);
    }
    
    public boolean Hoja(Nodo nodo) {
	return this.izquierdoVacio(nodo) && this.derechoVacio(nodo);
    }
    
    public boolean izquierdoVacio(Nodo nodo){
        return nodo.getLeft() == null;
    }
    
    public boolean derechoVacio(Nodo nodo){
        return nodo.getRight() == null;
    }
    
    public Nodo encontrar( String valor, Nodo nodo){ //Si no existe devolvera nulo
        
        Nodo encontrar = null;
        
        if ( nodo == null) {
            return null;
        } 
        if( nodo.getData().equals(valor)){
            return nodo;
        } 
        if( nodo.getLeft() != null){
            encontrar = this.encontrar(valor, nodo.getLeft());
        } 
        if( encontrar == null){
            
            encontrar = this.encontrar(valor, nodo.getRight());
        }
        
        return encontrar;
    }
    
    public Nodo encontrarPadre( String valor, Nodo nodo){ //Si no existe devolvera nulo
        
        Nodo encontrar = null;
        
        if ( this.nodoVacio(nodo)) {
            return null;
        } 
        
        if( !this.nodoVacio(nodo.getLeft())){
            
            if (nodo.getLeft().getData().equals(valor)){
                encontrar = nodo;
                return encontrar;
            } 
            
            else {
                encontrar = this.encontrarPadre(valor, nodo.getLeft());
                
            } 
        } 
        
        if( encontrar == null ){
                 
                if (nodo.getRight().getData().equals(valor)){
                    encontrar = nodo;
                    return encontrar;
                } 
                else {
                    encontrar = this.encontrarPadre(valor, nodo.getRight());
                }
            }
        return encontrar;
    }
    
    public void insertartLeft(String parent, String valor) { //Inserta un nodo a la izquierda de su padre
		Nodo nodo = encontrar(parent, this.root);
		Nodo hijo = new Nodo(valor);
		nodo.setLeft(hijo);
	}

    public void insertartRight(String parent, String valor) { //Inserta un nodo a la derecha de su padre
	Nodo nodo = encontrar(parent, this.root);
	Nodo hijo = new Nodo(valor);
	nodo.setRight(hijo);
    }
    //Imprime una lista de los nodos en los ordenes indicados
    public void PreOrder(Nodo nodo ){ 
		
	if (nodo == null)
            return;
	nodo.imprimirNodo(nodo);
	PreOrder(nodo.getLeft());
	PreOrder(nodo.getRight());
    }
    
    public void PreOrder2(Nodo nodo ){ //crea una cadena de String, separada por comas, con todos los nodos en forma de preorden
		
	if (nodo == null)
            return;
        cadenaPreor=cadenaPreor+nodo.getData()+",";
	PreOrder2(nodo.getLeft());
	PreOrder2(nodo.getRight());
    }
    
	
    public void InOrder(Nodo nodo ){
		
	if (nodo == null)
            return;
	InOrder(nodo.getLeft());
	nodo.imprimirNodo(nodo);
	InOrder(nodo.getRight());
    }
    
    public void InOrder2(Nodo nodo ){//crea una cadena de String, separada por comas, con todos los nodos en forma de inorden
		
	if (nodo == null)
            return;
	InOrder2(nodo.getLeft());
	cadenaInor=cadenaInor+nodo.getData()+",";
	InOrder2(nodo.getRight());
    }
	
    public void PostOrder(Nodo nodo ){
		
	if (nodo == null)
            return;
	PostOrder(nodo.getLeft());
	PostOrder(nodo.getRight());
	nodo.imprimirNodo(nodo);
    }
        
    public int getAltura(Nodo root) {
	if (root == null)
            return 0;
	return Math.max(getAltura(root.getLeft()), getAltura(root.getRight())) + 1;
    }
    
    public void print2DUtil(Nodo root, int space){  
   
        if (root == null)  
            return;  
  
        space += COUNT;  
  
        print2DUtil(root.getRight(), space);  

        s += "\n";  
        for (int i = COUNT; i < space; i++)  
            s += " ";  
        s += root.getData() + "\n";  
   
        print2DUtil(root.getLeft(), space);  
    }  
  
    public void print2D(Nodo root){  
        print2DUtil(root, 0);  
    }
    
    public void agregarAnimal( String animalN, String caracteristica, Nodo nodo){ //no se adivino el animal y es hoja
        String animalV = nodo.getData();
        nodo.setData(caracteristica);
        this.insertartRight(caracteristica, animalN);
        this.insertartLeft(caracteristica, animalV);
    }
    
    public Nodo Min(Nodo nodo) { //Devuelve el nodo mas a la izquierda
            if (nodo.getLeft()== null) {
                return nodo;
            } else {
                return Min(nodo.getLeft());
            }
    }
    
    public Nodo Max(Nodo nodo) { //Devuelve el nodo mas a la derecha
            if (nodo.getRight()== null) {
                return nodo;
            } else {
                return Min(nodo.getRight());
            }
    }
    
    /*METODOS PARA HACER EL ARBOL CON UNA IMPRESION DE INORDEN Y UNA DE PREORDEN*/
    public int height(Nodo root){
        
        if(root == null) return 0;
        else{
            
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());
            
            if(lheight>rheight)
                return (lheight+1);
            else return(rheight+1);    
        }   
    }
    
    public int height (){ 
        return height(root);
    }
    
    void printGivenLevel(Nodo root, int level){
        
        if(root == null) return;
        if(level == 1){
            System.out.print(root.getData()+ " ");
        
        } else if(level>1){
           
            printGivenLevel(root.getLeft(), level-1);
            printGivenLevel(root.getRight(), level-1);
        }   
    }
    
    void printLevelOrder(){
        for (int i = 1; i <= height(); i++) {
            printGivenLevel(root,i);
        }   
    }
    
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
}
