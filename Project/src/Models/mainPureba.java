/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Services.ReportController;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;

/**
 *
 * @author juan
 */
public class mainPureba {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Hotel hotel = new Hotel(1,"nombre hotel", "direccion hotel", "****", "comodidades", "foticos", 45);
        User user = new User(1, "juan", 4847, "juanUser", "48587", "juan@correo", "detalles", 514, "direccion de usuario");
        Reservation reser = new  Reservation(1, 23, 435, "2024-12-19", "2024-12-30", 34343, 614863);
        ReportController control = new ReportController(hotel, user, reser);
        control.createRepor();
    }

}
