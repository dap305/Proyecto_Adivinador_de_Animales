
package proyecto_adivinador;

import java.io.*;

/**
 *
 * @author wilfredojose
 */
public class Archivos {
    
    /*EN ESTA CLASE SE ENCUENTRA TODO LO RELATIVO A METODOS Y VARIABLES QUE HAGAN POSIBLE EL GUARDAR Y ABRIR ARCHIVOS TXT*/
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    public Archivos() {
    }
    
    //metodo para abrir un archivo de texto
    public String abrirTexto(File archivo){
        String contenido = "";
        
        try{
            
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read())!= -1){
                char caracter = (char) ascci;
                contenido+=caracter;
            }
        }catch(Exception e){
        }
        
        return contenido;              
    }
    
    //metodo para guardar un archivo de texto
    public String guardarTexto(File archivo, String contenido){
        String respuesta = null;
        
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytes = contenido.getBytes();
            salida.write(bytes);
            respuesta = "El archivo se ha guardado correctamente";
      
        }catch(Exception e){
        }
        
        return respuesta;
    }
    
    //recibe un vector de string que será el txt, y mediante procesos llena un vector de objetos con una parte de ese txt(que sera la impresion en inorden)
    //y otro vector de objetos con la otra parte del txt; con estos dos vectores crearemos el arbol que se quiere cargar del txt
    public static void capturarTxt(String[] primerVec, Object[] vecInor,Object[] vecPre ){
        
        int j =0;
        int k = 0;
        boolean flag = false;
        
        while(!flag){            
            if (!primerVec[j].equals("*")) {
                vecInor[j]= primerVec[j];
                j+=1;
            }else{
                j+=1;
                flag=true;
            }
        }
        
        for (int i = j; i < primerVec.length; i++) {
            vecPre[k]=primerVec[i];
            k+=1;
        }
    }
    
}
