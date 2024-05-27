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


public class PaqueteMod1 {
    private Connection con; 
    private ArrayList <ArrayList<Object>> lista = new ArrayList<>();
    String datos[]=new String[2];
    
    private ArrayList<Object> ID = new ArrayList();
    private String id[];
    
    public PaqueteMod1(Connection con) {
        this.con = con;
    }
    
   
    
      
    
    public void obtenerID()
    {
        try
        {
            int cont = 0;
            
            Statement sts = getCon().createStatement();
            sts.execute("Select * from paquete");
            ResultSet rs = sts.getResultSet();
            
            while(rs.next())
            {
                    getID().add(rs.getString("IDpaq"));
                    cont++;
                
                
            }
            setId(new String[cont]);
            for (int mat = 0; mat < cont; mat++)
            {
                
                getId()[mat] = getID().get(mat).toString();
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getNextException());
        }
    }
    public void obtenerIDPac()
    {
        try
        {
            int cont = 0;
            
            Statement sts = getCon().createStatement();
            sts.execute("Select * from mensajero");
            ResultSet rs = sts.getResultSet();
            
            while(rs.next())
            {
                    getID().add(rs.getString("ID"));
                    cont++;
                
                
            }
            setId(new String[cont]);
            for (int mat = 0; mat < cont; mat++)
            {
                
                getId()[mat] = getID().get(mat).toString();
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getNextException());
        }
    }
    public void AsignarPersonal(String NumeroEmpleado,String IDempleado){
        
        try{
            Statement sts=con.createStatement();
            sts.addBatch("INSERT INTO mensajero (NumEmp,ID)"+" VALUES ('"+NumeroEmpleado+"','"+IDempleado+"');");
            sts.executeBatch();
            JOptionPane.showMessageDialog(null,"se guardo correctamente");
        }catch(SQLException ex){
            System.out.println("Error"+ex);
            
        }
    }
    
    
    public void Edita(String NumeroEmpleado,String IDPaquetes){
        try{
            Statement sts=con.createStatement();
            sts.executeUpdate("UPDATE mensajero set NumEmp ='"+NumeroEmpleado+"' WHERE ID='"+IDPaquetes+"'");
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    public void EliminaPac(String identificadorPac){
        
      int i;
       datos=ConsultaPaquete(identificadorPac);
        try{
            Statement sts=con.createStatement();
            
            i=JOptionPane.showConfirmDialog(null,"esta seguro que desea eliminar a "+datos[0]+" del paquete "+datos[1]);
            if(i==0){
              String eliminar="DELETE FROM mensajero WHERE ID='"+identificadorPac+"'";  
            
            sts.executeUpdate(eliminar);
            JOptionPane.showMessageDialog(null, "se elimino correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "no se borro el registro");
            }
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    
        
    }
    public String[] ConsultaPaquete(String identificadoPac){
        String resul[]=new String[2];
        try{
            Statement sts=con.createStatement();
            sts.execute("SELECT *FROM mensajero WHERE ID='"+identificadoPac+"'");
            ResultSet rs=sts.getResultSet();
        
            while(rs.next()){
                resul[0]=rs.getString("NumEmp");
                resul[1]=rs.getString("ID");
                
            }
        
        }catch(SQLException err){
            System.out.println(err.getNextException());
        }catch(NumberFormatException err1){
            System.out.println(err1);
        }
        return resul;
    }
    public String[] ConsultaPaquete1(String identificadoPac){
        String resul[]=new String[3];
        try{
            Statement sts=con.createStatement();
            sts.execute("SELECT *FROM paquete WHERE IDpaq='"+identificadoPac+"'");
            ResultSet rs=sts.getResultSet();
        
            while(rs.next()){
                resul[0]=rs.getString("estadoPaq");
                resul[1]=rs.getString("direcEntrega");
                
            }
        
        }catch(SQLException err){
            System.out.println(err.getNextException());
        }catch(NumberFormatException err1){
            System.out.println(err1);
        }
        return resul;
    }
    public final DefaultTableModel actualizaTabla(){
        DefaultTableModel modelo=new DefaultTableModel();
        Object datos[]=new Object[2];
        modelo.addColumn("ID empleado");
        modelo.addColumn("ID paquete");
        
        
        
        ConsultaPaquete();
        for(int j=0;j<getLista().size();j++){
            datos[0]=getLista().get(j).get(0);
            datos[1]=getLista().get(j).get(1);
            
            modelo.addRow(datos);
        }
        return modelo;
    }
    public void ConsultaPaquete(){
        int reg=0;
        try{
            getLista().clear();
            Statement sts=con.createStatement();
            sts.execute("SELECT *FROM mensajero");
            ResultSet rs=sts.getResultSet();
            while(rs.next()){
                getLista().add(new ArrayList<>());
                getLista().get(reg).add(rs.getString("NumEmp"));
                getLista().get(reg).add(rs.getString("ID"));
                
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

    
    
    public void ConsultaPersonalYP(){
        int reg=0;
        try{
            getLista().clear();
            Statement sts=con.createStatement();
            sts.execute("SELECT *FROM mensajero");
            ResultSet rs=sts.getResultSet();
            while(rs.next()){
                getLista().add(new ArrayList<>());
                getLista().get(reg).add(rs.getString("ID"));
                getLista().get(reg).add(rs.getString("NumEmp"));
                
                
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
    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the lista
     */
    public ArrayList <ArrayList<Object>> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList <ArrayList<Object>> lista) {
        this.lista = lista;
    }

    /**
     * @return the ID
     */
    public ArrayList<Object> getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(ArrayList<Object> ID) {
        this.ID = ID;
    }

    /**
     * @return the id
     */
    public String[] getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String[] id) {
        this.id = id;
    }
    


    
}
