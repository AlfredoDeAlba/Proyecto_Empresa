/*
 * Universidad Politecnica de San Luis Potosi
 * Programacion III Java
 *  Programacion Orientada a objetos
 */
package proyecto_final;
import java.sql.Connection;
/**
 *
 * @author 177847
 */
public class Proyecto_Final {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionP obj=new ConexionP();
        Connection con =obj.Conexion();
        new LogIn(con).setVisible(true);
        //new Principal(con).setVisible(true);
    }
    
}
