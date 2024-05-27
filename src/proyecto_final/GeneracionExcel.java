/*
 * 177847 Alfredo De Alba Sánchez;
 * Programacion III;
 */

package proyecto_final;

import com.lowagie.text.Paragraph;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author licbe
    Alfredo De Alba;
 */
public class GeneracionExcel implements Runnable {

    int i = 1;
    int pag = 1;
    private final Connection con;
    private final Personal trabajador;
    private final PaqueteMod1 paq;
    private ArrayList <ArrayList<Object>> lista = new ArrayList<>();
    String datos[]=new String[6];
    String datos1[]=new String[2];
    private final Thread h1;
    private final Thread h2;
    
    public GeneracionExcel(Connection con) {
        this.con=con;
        h1=new Thread(this,"Generales");
        h2=new Thread(this,"Especificos");
        trabajador=new Personal(this.con);
        paq=new PaqueteMod1(this.con); 
        
    }
    public void run(){
       
        try{
            if(Thread.currentThread().getName().equals("Generales")){
                    generales();
            }else if(Thread.currentThread().getName().equals("Especificos")){
                Especificos();
                Thread.sleep(4000);
            }
        }catch(InterruptedException err){
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeneracionExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Arranque(){
        h1.start();
        h2.start();
    }
    
    
    public void generales() throws FileNotFoundException{
        CrearGeneral();
    }
    public void Especificos() throws FileNotFoundException{
        CrearEspecifico();
    }
    
    
    public void crearArchivo()throws FileNotFoundException{
        PrintStream alumnoFile=new PrintStream("src/archivos/"+"Excel General"+".xls");
        alumnoFile.println("Registro General"+"\n"+"           ID                Nombre del Empleado                Estado del Paquete");
        
    }
    public void crearArchivo1(String NumEmp)throws FileNotFoundException{
    
        
    }
    
    
    
    
    
    public void CrearGeneral() throws FileNotFoundException{
        int x=0;
        PrintStream alumnoFile=new PrintStream("src/archivos/"+"Excel General"+".xls");
        File archivo=new File("src/archivos/"+"Excel General"+".xls");
        alumnoFile.println("Registro General"+"\n"+"ID            Nombre del Empleado                Estado del Paquete");
        paq.ConsultaPersonalYP();
            if(!archivo.exists()){//verifica si exsiste
                crearArchivo();
            }
            try(
                BufferedWriter bw=new BufferedWriter(new FileWriter(archivo.getAbsoluteFile(),true));
                    ){
                
                 for(int j=0;j<paq.getLista().size();j++){
                    datos=trabajador.ConsultaEmpleado(paq.getLista().get(j).get(1)+"");
                    datos1=paq.ConsultaPaquete1(paq.getLista().get(j).get(0)+"");
                    //alumnoFile.println(paq.getLista().get(j).get(0)+"                               \t       \t "+datos[1]+"   \t    \t                                 "+datos1[0]);
                    bw.newLine();
                    bw.write(paq.getLista().get(j).get(0)+"                               \t       \t "+datos[1]+"   \t    \t                                 "+datos1[0]);
                    //JOptionPane.showInputDialog("En proceso ");
                    x++;
                    
                }
            }catch(IOException e){
            System.out.println(e);
            }
            
            
        
            
    }
    
    
    
    public void CrearEspecifico() throws FileNotFoundException{
        
        trabajador.ConsultaPersonal();
        String NumEmp;
        String datoses[]=new String[6];
        String datoses1[]=new String[2];
        PrintStream alumnoFile;
        int y=0;
        for(int e=0;trabajador.getLista().size()>e;e++){
            
            
            NumEmp=trabajador.getLista().get(e).get(0)+"";
            File archivo=new File("src/archivos/"+"Excel"+NumEmp+".xls");
            if(!archivo.exists()){//verifica si exsiste
                crearArchivo1(NumEmp);
            }
            
            datoses=trabajador.ConsultaEmpleado(NumEmp);
           
            try(
                BufferedWriter bw=new BufferedWriter(new FileWriter(archivo.getAbsoluteFile(),true));
                    ){
                
                bw.write("Nombre:"+datoses[1]+"       ID empleado: "+datoses[0]+"     Telefono: "+datoses[3]+" Correo: "+datoses[4]+" Rol:   "+datoses[5]);
                bw.newLine();
                for(int t=0;t<paq.getLista().size();t++){
                    if(datoses[0].equals(paq.getLista().get(t).get(1))){
                    
                    //     (paq.getLista().get(e).get(0)+"\t       "+datos1[1]+"\t             "+datos1[0], 25, y);
                    bw.write("ID de paquete:"+paq.getLista().get(t).get(0));
                    bw.newLine();
                    y++;
                }
                }
                if(y==0){
                   bw.newLine(); 
                   bw.write("No tiene Paquetes asignados ");
                }
                 
            }catch(IOException q){
            System.out.println(q);
            }
            
            
        }
            
        
        
    }
}
