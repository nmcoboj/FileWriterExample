package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {
    
    static private FileWriter archivo;
    static Scanner datos = new Scanner(System.in);
    String nombre_archivo;
    BufferedReader entrada = null;
    
    public void CrearArchivo(){
        
        try {
            System.out.print("Ingrese nombre del archivo:");
            nombre_archivo=datos.nextLine();
            nombre_archivo=nombre_archivo+".txt";
            archivo = new FileWriter(nombre_archivo);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void LeerArchivo(){
        String cadena;
        
        try {
            FileReader archivo_1 = new FileReader(nombre_archivo);
            entrada = new BufferedReader(archivo_1);
            System.out.println("Contenido del archivo:");
            cadena = entrada.readLine();
            while(cadena !=null){
                System.out.println(cadena);
                cadena = entrada.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void CerrarArchivo(){
        try {
            entrada.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
