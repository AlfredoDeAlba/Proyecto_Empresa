/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package proyecto_final;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.text.SimpleDateFormat;

import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CreaPDF {
    
    int i = 1;
    int pag = 1;
    private final Connection con;
    private final Personal trabajador;
    private final PaqueteMod1 paq;
    private ArrayList <ArrayList<Object>> lista = new ArrayList<>();
    String datos[]=new String[6];
    String datos1[]=new String[2];
    
    
    //PaquetesPersonal Paquetes;
    public CreaPDF(Connection con) {
        this.con=con;
        trabajador=new Personal(this.con);
        paq=new PaqueteMod1(this.con); 
    }
    
    
    public void crearPDFGenerales() {
        Document doc = new Document();     //Variable que usaremos para agregar datos al pdf
        try {                                   //variable doc                           lugar y nombre de donde se va a crear el pdf  
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("src/archivos/"+i+".pdf"));
            doc.open();                 //Documento abierto, hay que empezar a llenar datos
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            g.drawRect(20, 10, 160, 160);
            ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/logo.jpg"));
            g.drawImage(img1.getImage(), -80, 0, 400, 200, null);    
//            g.drawImage(img1.getImage(), 20, 20, null);
           // g.drawImage(img1.getImage(), 1, 1, 400, 1, 1, 300, 400, 300, null);
          //  g.drawRect(350, 4, 250, 50);
            Font font1 = new Font("perpetua titling mt ", Font.BOLD, 24);
            g.setFont(font1);
            g.setColor(Color.BLACK);
            g.drawString("ADEG", 230, 170);
            g.drawString("Mas rapidos que la carrera", 140, 200);
            Font font2 = new Font("perpetua titling mt ", Font.PLAIN, 14);
            g.setFont(font2);
            g.drawString("" + new SimpleDateFormat("EEE dd 'de' MMM 'de' YYY HH:mm:ss").format(new java.util.Date()), 351, 30);
            PdfPTable tabla = new PdfPTable(9);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("ID del Paquete                  "+"                \t Nombre del Empleado"+"                \t Estado"));
            doc.add(new Paragraph("\n"));
            paq.ConsultaPersonalYP();
            for(int j=0;j<paq.getLista().size();j++){
            datos=trabajador.ConsultaEmpleado(paq.getLista().get(j).get(1)+"");
            datos1=paq.ConsultaPaquete1(paq.getLista().get(j).get(0)+"");
            doc.add(new Paragraph(paq.getLista().get(j).get(0)+"                               \t       \t "+datos[1]+"   \t    \t                                 "+datos1[0]));
            doc.add(new Paragraph("\n"));
            }
            
            
            
            
            g.drawString("Pagina" + pag, 500, 800);
            i++;
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        doc.close();
        JOptionPane.showMessageDialog(null, "Se creo el archivo " + "Reporte" + "i");
        
    }
    public void PDFindividuales(String NumeroEmp){
        Document doc = new Document();
        int y=340;
        try{
            datos=trabajador.ConsultaEmpleado(NumeroEmp);
            if(datos[0]==null){
                JOptionPane.showMessageDialog(null, "este empleado no exsite por favor corroborar sus datos");
            }else{
                PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("src/archivos/"+NumeroEmp+".pdf"));
                doc.open();
                PdfContentByte cb = writer.getDirectContent();
                Graphics g = cb.createGraphicsShapes(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                Font font1 = new Font("perpetua titling mt ", Font.BOLD, 24);
                g.drawRect(20, 10, 160, 160);
                ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/logo.jpg"));
                g.drawImage(img1.getImage(), -80, 0, 400, 200, null); 
                g.setFont(font1);
                
                g.setColor(Color.BLACK);
                g.drawString("ADEG", 230, 170);
                g.drawString("Mas rapidos que la carrera", 140, 200);
                Font font2 = new Font("perpetua titling mt ", Font.PLAIN, 14);
                g.setFont(font2);
                g.drawString("" + new SimpleDateFormat("EEE dd 'de' MMM 'de' YYY HH:mm:ss").format(new java.util.Date()), 351, 30);
                PdfPTable tabla = new PdfPTable(9);
                
                
                g.draw3DRect(20, 230, 150, 40, true);
                g.drawString("Numero:", 22, 245);
                g.drawString(datos[0], 30, 265);
                
                
                
                g.draw3DRect(170, 230, 200, 40, true);
                g.drawString("Nombre:", 172, 245);
                g.drawString(datos[1], 180, 265);
                
                g.draw3DRect(370, 230, 200, 40, true);
                g.drawString("Rol:", 372, 245);
                g.drawString(datos[5], 380, 265);
                
                g.draw3DRect(370, 230, 200,400 , true);
                g.drawString("Medios de Contacto:", 380, 290);
                g.drawString("Telefono:", 400, 310);
                g.drawString(datos[3], 410, 330);
                g.drawString("Correo:", 400, 350);
                g.drawString(datos[4], 410, 370);
                
                g.draw3DRect(20, 230, 350, 400, true);
                paq.ConsultaPersonalYP();
                g.drawString("ID del Paquete"+"\t         "+"Dirrecion:"+"\t             "+"Estado:", 25, 300);
                for(int j=0;j<paq.getLista().size();j++){
                    
                datos=trabajador.ConsultaEmpleado(paq.getLista().get(j).get(1)+"");
                datos1=paq.ConsultaPaquete1(paq.getLista().get(j).get(0)+"");
                
                
                if(datos[0].equals(NumeroEmp)){
                    
                    g.drawString(paq.getLista().get(j).get(0)+"\t       "+datos1[1]+"\t             "+datos1[0], 25, y);
                    
                    y=y+20;
                }
                }
                if(y==340){
                    g.drawString("Este empleado no tiene encargos pendientes", 25, 350);
                }
                doc.close();
                JOptionPane.showMessageDialog(null, "Se creo el archivo " + "Reporte" + "i");
                
            }
            
        }catch(DocumentException de){
            System.err.println(de.getMessage());
        }catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
}
