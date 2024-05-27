/*
 * Universidad Politecnica de San Luis Potosi
 * Programacion III Java
 *  Programacion Orientada a objetos
 */

package proyecto_final;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *generamos la concexion de la base de datos al programa
 * @author 177847
 * @author 177847De Alba Sánchez@upslp.edu.mx
 * @version 1.0
 */
public class ConexionP {
    private Connection con;
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_final","root","");
            System.out.println("    se conecto");
                 
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("error"+e);
        }
        return con;
    }

}
