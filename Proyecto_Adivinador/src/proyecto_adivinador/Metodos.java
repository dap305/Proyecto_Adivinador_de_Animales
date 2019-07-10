/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_adivinador;

/**
 *
 * @author wilfredojose
 */
public class Metodos {
    
    static int UtilPosition(Object [] array, Nodo x){ 
        
        int p = 0;       
        for (int i = 0; i < array.length; i++) {            
            if(array[i].equals(x.getData())){                
                p = i;   
                break;
            }else{ 
                p++;
            }           
        }
        return p;
    }
    
     static boolean UtilIsInArray(Object[] array, Object x){
        
        boolean is = false;       
        for (int i = 0; i < array.length; i++) {
           if(array[i].equals(x)) {
               is = true;
           }
        }
       return is; 
    }
        
    static Arbol_Binario trix = new Arbol_Binario();
    
    
    static Nodo UtilCrearArbol_Inorden_Preorden(Object [] inorden, Object [] preorden, Nodo root){
         
         //MOSCAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        Object [] inorden2, inorden3, preorden1, preorden2;      
        
        if((inorden.length>0 && preorden.length>0)){

            //se coloca la nueva raiz
            root = new Nodo(preorden[0]);
            int p = UtilPosition(inorden, root);

            //se hace un nuevo arreglo de secuencia inorden (para subárbol izquierdo)inorden del tamaño de inorden
            //Object [] inorden2 = new Object[p];
            inorden2 = new Object[p];
            for (int i = 0; i < inorden2.length; i++) {
                inorden2[i] = inorden[i];
            }

            //se hace un nuevo arreglo de secuencia inorden (para subárbol derecho) del tamaño de inorden
            //Object [] inorden3 = new Object[inorden.length -p-1];
            inorden3 = new Object[inorden.length -p-1];
            for (int i = 0; i < inorden3.length; i++) {
                p++;
                inorden3 [i] = inorden[p]; 
            }

            //se crea un nuevo arreglo de secuencia preorden (para el subárbol izquierdo)
            //Object [] preorden1 = new Object[inorden2.length];
            preorden1 = new Object[inorden2.length];
            for (int i = 0; i < preorden1.length; i++) {                  
                if(UtilIsInArray(inorden2,preorden[i+1])){
                    preorden1[i] = preorden[i+1];     
              }   
            }

            //se crea un nuevo arreglo de secuencia preorden (para el subárbol derecho)
            //Object [] preorden2 = new Object[inorden3.length];
            preorden2 = new Object[inorden3.length];

            for (int i = 0; i < preorden2.length; i++) {  
                if(UtilIsInArray(inorden3, preorden[preorden1.length+1+i])){  
                    preorden2[i] = preorden[preorden1.length+1+i];   
                }
            }

            root.setLeft(UtilCrearArbol_Inorden_Preorden (inorden2, preorden1,root.getLeft()));
            root.setRight(UtilCrearArbol_Inorden_Preorden (inorden3,preorden2,root.getRight()));          
        }  
        
        return root;
    }
    

    static Arbol_Binario CrearArbol_Inorden_Preorden(Arbol_Binario tree, Object[]inorden, Object[]preorden){
        
        trix.setRoot(UtilCrearArbol_Inorden_Preorden(inorden, preorden,trix.getRoot()));       
        return tree = trix;
    }
}
