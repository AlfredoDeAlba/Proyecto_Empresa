/*
 * 177847 Alfredo De Alba Sánchez;
 * Programacion III;
 */

package proyecto_final;

import javax.swing.JOptionPane;

/**
 *
 * @author licbe
    Alfredo De Alba;
 */
public class Excepciones extends Exception{
    
    public Excepciones(int i){
        if(i==1){
            JOptionPane.showMessageDialog(null, "Celdas vacias corrigalo");
        }else if(i==2){
            JOptionPane.showMessageDialog(null, "Caracteres no validos");
        }else if(i==3){
            JOptionPane.showMessageDialog(null, "No se encontraron los datos");
        }
                    
                    
    }
    public String getLocalizeMessage(){
        return "Datos Erroenos vuevla a colocarlos";
    }
}
