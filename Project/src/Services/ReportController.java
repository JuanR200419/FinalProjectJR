/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.Hotel;
import Models.Reservation;
import Models.User;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReportController {

    Hotel hotel;
    User user;
    Reservation reser;
    private static Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private static Font regularFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

    public ReportController(Hotel hotel, User user, Reservation reser) {
        this.hotel = hotel;
        this.user = user;
        this.reser = reser;

    }

    public void createRepor() throws FileNotFoundException, DocumentException {

        Document documento = new Document();

        String ruta = System.getProperty("user.home") + "/documents";
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            System.out.println("entro");
            directorio.mkdirs(); // Crear los directorios necesarios
        }

        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "FACTURA.pdf"));

        documento.open();

        // Agregar título al documento
        Paragraph titulo = new Paragraph("FACTURA", boldFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
        documento.add(new Paragraph(" ")); // Agregar espacio en blanco

        PdfPTable tabla = new PdfPTable(2); // Dos columnas para etiquetas y valores
        tabla.setWidthPercentage(100); // Ancho de la tabla
        tabla.setSpacingBefore(10f); // Espacio antes de la tabla
        tabla.setSpacingAfter(10f); // Espacio después de la tabla

        // Agregar celdas a la tabla
        addTableHeader(tabla, "USUARIO", String.valueOf(user.getId()));
        addTableHeader(tabla, "Nombre del Usuario", user.getName());
        addTableHeader(tabla, "EMAIL", user.getEmail());
        addTableHeader(tabla, "DETALLES", user.getCountDetails());
        addTableHeader(tabla, "EDAD", String.valueOf(user.getAge()));
        addTableHeader(tabla, "HOTEL", hotel.getNameHotel());
        addTableHeader(tabla, "CLASIFICACIÓN", hotel.getClassification());
        addTableHeader(tabla, "MODALIDAD DE CONSTRUCCIÓN", hotel.getModCons());
        addTableHeader(tabla, "DÍA DE ENTRADA", reser.getEntryDate());
        addTableHeader(tabla, "DÍA DE SALIDA", reser.getExitDate());
        addTableHeader(tabla, "PRECIO A PAGAR", String.valueOf(reser.getTotalPrice()));

        documento.add(tabla);
        documento.close();
        JOptionPane.showMessageDialog(null, "Reporte creado.");

        documento.close();
        JOptionPane.showMessageDialog(null, "Reporte creado.");

    }

    private void addTableHeader(PdfPTable table, String header, String value) {
        PdfPCell cell;

       cell = new PdfPCell(new Phrase(header, boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(PdfPCell.BOX); // Agregar borde a la celda
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(value, regularFont));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(PdfPCell.BOX); // Agregar borde a la celda
        table.addCell(cell);
    }

}

