/*
 * 177847 Alfredo De Alba Sánchez;
 * Programacion III;
 */

package proyecto_final;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author licbe
    Alfredo De Alba;
 */
public class Personal {
    private final Connection con;
    private ArrayList<ArrayList<Object>>lista=new ArrayList<>();
    String datos[]=new String[6];
    
    
    public Personal(Connection con){
     this.con=con;   
    }

    public void AltaEmpleado(String nombre,String Dirrecion,String Telefono,String Correo,String Rol){
        String matricula;
        //matricula="";
        int i=0;
        //Personal per=new Personal();
        //per.Numero();
        i=Numero();
        matricula=i+"";
        try{
            Statement sts=con.createStatement();
            sts.addBatch("INSERT INTO empleado (NumeroEmp,NombreEmp,DireccionEmp,TelefonoEmp,CorreoEmp,RolEmp)"+" VALUES ('"+matricula+"','"+nombre+"','"+Dirrecion+"','"+Telefono+"','"+Correo+"','"+Rol+"');");
            sts.executeBatch();
            JOptionPane.showMessageDialog(null,"se guardo correctamente");
        }catch(SQLException ex){
            System.out.println("Error"+ex);
            
        }
        
       
    }
    public void BajaEmpleado(String matricula){
       int i;
       datos=ConsultaEmpleado(matricula);
        try{
            Statement sts=con.createStatement();
            
            i=JOptionPane.showConfirmDialog(null, "Esta seguro que desea borrar a: "+datos[1]+"\n numero de empleado:"+datos[0]+
                    "\nRol:"+datos[5]);
            if(i==0){
              String eliminar="DELETE FROM empleado WHERE NumeroEmp="+matricula+"";  
            
            sts.executeUpdate(eliminar);
            JOptionPane.showMessageDialog(null, "se elimino correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "no se borro el registro");
            }
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    public void ModificaEmpleado(String nombreEmpleado,String numeroEmpleado,String Dirrecion,String Telefono,String Rol,String Correo){
        try{
            Statement sts=con.createStatement();
            sts.executeUpdate("UPDATE empleado set NombreEmp ='"+nombreEmpleado+"', DireccionEmp='"+Dirrecion+"',RolEmp='"+Rol+"',CorreoEmp='"+Correo+"',TelefonoEmp='"+Telefono+"' where NumeroEmp='"+numeroEmpleado+"'");
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    
    }
    
    public void ConsultaPersonal(){
        int reg=0;
        try{
            getLista().clear();
            Statement sts=con.createStatement();
            sts.execute("SELECT *FROM empleado");
            ResultSet rs=sts.getResultSet();
            while(rs.next()){
                getLista().add(new ArrayList<>());
                getLista().get(reg).add(rs.getString("NumeroEmp"));
                getLista().get(reg).add(rs.getString("NombreEmp"));
                getLista().get(reg).add(rs.getString("DireccionEmp"));
                getLista().get(reg).add(rs.getString("TelefonoEmp"));
                getLista().get(reg).add(rs.getString("CorreoEmp"));
                getLista().get(reg).add(rs.getString("RolEmp"));
                
                reg++;
                
            }
            Iterator miIterator=getLista().iterator();
            while(miIterator.hasNext()){
                System.out.println(miIterator.next()+"\t");
            }
        }catch(SQLException ex){
                    System.out.println(ex.getNextException());
        }
        
    }   
    public final DefaultTableModel actualizaTabla(){
        DefaultTableModel modelo=new DefaultTableModel();
        Object datos[]=new Object[6];
        modelo.addColumn("Numero de Empleado");
        modelo.addColumn("Nombre de Empleado");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Rol");
        
        
        ConsultaPersonal();
        for(int j=0;j<getLista().size();j++){
            datos[0]=getLista().get(j).get(0);
            datos[1]=getLista().get(j).get(1);
            datos[2]=getLista().get(j).get(2);
            datos[3]=getLista().get(j).get(3);
            datos[4]=getLista().get(j).get(4);
            datos[5]=getLista().get(j).get(5);
            modelo.addRow(datos);
        }
        return modelo;
    }
    public final DefaultTableModel AgregarPac(){
        DefaultTableModel modelo=new DefaultTableModel();
        Object datos[]=new Object[2];
        modelo.addColumn("Numero de Empleado");
        modelo.addColumn("Nombre de Empleado");
        ConsultaPersonal();
        for(int j=0;j<getLista().size();j++){
            datos[0]=getLista().get(j).get(0);
            datos[1]=getLista().get(j).get(1);
            
            modelo.addRow(datos);
        }
        return modelo;
    }
    public String[] ConsultaEmpleado(String NumeroEmp){
        String resul[]=new String[6];
        try{
            Statement sts=con.createStatement();
            sts.execute("SELECT *FROM empleado WHERE NumeroEmp='"+NumeroEmp+"'");
            ResultSet rs=sts.getResultSet();
            while(rs.next()){
                resul[0]=rs.getString("NumeroEmp");
                resul[1]=rs.getString("NombreEmp");
                resul[2]=rs.getString("DireccionEmp");
                resul[3]=rs.getString("TelefonoEmp");
                resul[4]=rs.getString("CorreoEmp");
                resul[5]=rs.getString("RolEmp");
                
            }
        
        }catch(SQLException err){
            System.out.println(err.getNextException());
        }catch(NumberFormatException err1){
            System.out.println(err1);
        }
        return resul;
    }
    
    public int Numero(){
        int i=0;
        boolean bandera=true;
        try{
            do{
                i=(int)Math.round(Math.random()*8999+1000);
                Statement sts=con.createStatement();
                sts.execute("Select * from Alumno where matricula ="+i+"");
                ResultSet rs=sts.getResultSet();
                while(rs.next()){
                    bandera=false;
                }
            }while(!bandera);
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
        return i;
    }
    public ArrayList <ArrayList<Object> >  getLista(){
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<ArrayList<Object>> lista) {
        this.lista = lista;
    }
    
            
}
