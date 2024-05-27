/*
 * Universidad Politecnica de San Luis Potosi
 * Programacion III Java
 *  Programacion Orientada a objetos
 */

package proyecto_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

/**
 *
 * @author 177847
 * @author 177847De Alba Sánchez@upslp.edu.mx
 * @version 1.0
 */
public class ExcepcionPropia extends Exception {

    private final String Nombre;
    private final String NumEmp;
    private final int i;

    public ExcepcionPropia(String Nombre,String NumEmp,int i)throws FileNotFoundException{
        this.Nombre=Nombre;
        this.NumEmp=NumEmp;
        this.i=i;
        agregarArchivo(i);
    }
    
    
    public void crearArchivo()throws FileNotFoundException{
        PrintStream alumnoFile=new PrintStream("src/archivos/"+"Registro de Entrada"+".xls");
        alumnoFile.println("Registro de entrada");
    }
    public void crearArchivo1()throws FileNotFoundException{
        PrintStream alumnoFile=new PrintStream("src/archivos/"+"Registro de Entrada"+".xls");
        alumnoFile.println("Registro de entrada Fallidos");
    }
    public void agregarArchivo(int i)throws FileNotFoundException{
        if(i==1){
            
        
        try{
            File archivo=new File("src/archivos/"+"Registro de Entrada"+".xls");
            if(!archivo.exists()){//verifica si exsiste
                crearArchivo();
            }
            try(
                BufferedWriter bw=new BufferedWriter(new FileWriter(archivo.getAbsoluteFile(),true));//manter informacion previa
              
                    
               )
            {
                bw.write("\n"+Nombre+" "+NumEmp+" "+new SimpleDateFormat("EEEE dd 'de' MMM 'de' YYYY HH:MM:ss").format(new java.util.Date()));
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
        }else if(i==0){
            try{
            File archivo=new File("src/archivos/"+"Registro de entrada Fallidos"+".xls");
            if(!archivo.exists()){//verifica si exsiste
                crearArchivo1();
            }
            try(
                BufferedWriter bw=new BufferedWriter(new FileWriter(archivo.getAbsoluteFile(),true));//manter informacion previa
              
                    
               )
            {
                bw.write("\n"+Nombre+" "+NumEmp+" "+new SimpleDateFormat("EEEE dd 'de' MMM 'de' YYYY HH:MM:ss").format(new java.util.Date()));
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
        }
        
    }
    
}
