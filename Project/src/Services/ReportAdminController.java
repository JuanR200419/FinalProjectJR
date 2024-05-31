/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Dao.DaoReportCreate;
import Models.Hotel;
import Models.ReportAdmin;
import Models.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ReportAdminController {

    DaoReportCreate dao;

    public ReportAdminController() {
        this.dao = new DaoReportCreate();

    }

    private static Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private static Font regularFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

      public ArrayList<ReportAdmin> searchHotelWithReservations(int id) {
        return dao.searchHotelWithReservations(id);

    }

    public ArrayList<Hotel> searchHotel() {
        return dao.searchHotel();
    }

   public void createRepor(ArrayList<ReportAdmin> listReport) throws FileNotFoundException, DocumentException, IOException {
    Document documento = new Document();
    String ruta = System.getProperty("user.home") + "/documents/";
    File directorio = new File(ruta);
    if (!directorio.exists()) {
        System.out.println("Entró a crear el directorio");
        directorio.mkdirs(); // Crear los directorios necesarios
    }

    String filePath = ruta + "FACTURA.pdf";
    PdfWriter.getInstance(documento, new FileOutputStream(filePath));
    documento.open();

    // Agregar título al documento
    Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    Paragraph titulo = new Paragraph("REPORTE", boldFont);
    titulo.setAlignment(Element.ALIGN_CENTER);
    documento.add(titulo);
    documento.add(new Paragraph(" ")); // Agregar espacio en blanco

    PdfPTable tabla = new PdfPTable(2); // Dos columnas para etiquetas y valores
    tabla.setWidthPercentage(100); // Ancho de la tabla
    tabla.setSpacingBefore(10f); // Espacio antes de la tabla
    tabla.setSpacingAfter(10f); // Espacio después de la tabla

    Font regularFont = new Font(Font.FontFamily.HELVETICA, 12);

    for (int i = 0; i < listReport.size(); i++) {
        addTableHeader(tabla, "Número de reserva ", String.valueOf(listReport.get(i).getNumberReser()), boldFont, regularFont);
        addTableHeader(tabla, "Nombre del Usuario", String.valueOf(listReport.get(i).getUserName()), boldFont, regularFont);
        addTableHeader(tabla, "User id", String.valueOf(listReport.get(i).getIdUser()), boldFont, regularFont);
        addTableHeader(tabla, "Numero de habitacion ", String.valueOf(listReport.get(i).getNumberRoom()), boldFont, regularFont);
        addTableHeader(tabla, "Entrada ", String.valueOf(listReport.get(i).getEntryDate()), boldFont, regularFont);
        addTableHeader(tabla, "Salida", listReport.get(i).getExitDate(), boldFont, regularFont);
        addTableHeader(tabla, "Estado", String.valueOf(listReport.get(i).getEstado()), boldFont, regularFont);
        addTableHeader(tabla, "Precio Total", String.valueOf(listReport.get(i).getPrice()), boldFont, regularFont);
        createBlankSpace(tabla); // Añadir espacio en blanco después de "Precio Total"
    }

    documento.add(tabla);
    documento.close();
    JOptionPane.showMessageDialog(null, "Reporte creado.");

    // Abrir el documento PDF
    File pdfFile = new File(filePath);
    if (pdfFile.exists()) {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);
        } else {
            System.out.println("El escritorio no es compatible. No se puede abrir el PDF.");
        }
    } else {
        System.out.println("El archivo PDF no existe.");
    }
}

private void addTableHeader(PdfPTable table, String header, String value, Font boldFont, Font regularFont) {
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

private void createBlankSpace(PdfPTable table) {
    PdfPCell blankCell = new PdfPCell(new Phrase(" "));
    blankCell.setBorder(PdfPCell.NO_BORDER);
    table.addCell(blankCell);
    table.addCell(blankCell);
    table.addCell(blankCell);
    table.addCell(blankCell);
}

}
