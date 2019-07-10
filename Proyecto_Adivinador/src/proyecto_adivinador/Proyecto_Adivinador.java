/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_adivinador;

import java.io.File;


/**
 *
 * @author Daniel
 */
public class Proyecto_Adivinador {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        Arbol_Binario tree = null;
        File archivo = new File(currentDir+"\\src\\proyecto_adivinador\\Principal.txt");
        Archivos gestion = new Archivos();
        Object[] vecIn; 
        Object[] vecPre;
        String[] primerVec;
        
        String contenido = gestion.abrirTexto(archivo);
        primerVec = contenido.split(",");
        vecIn = new Object[(primerVec.length-1)/2];
        vecPre = new Object[(primerVec.length-1)/2];
        Archivos.capturarTxt(primerVec, vecIn, vecPre);
        tree= Metodos.CrearArbol_Inorden_Preorden(tree, vecIn, vecPre);
       
        Menu menu = new Menu(tree);
        menu.setVisible(true);
        
    }
    
}
