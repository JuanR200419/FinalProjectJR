/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author juan
 */
public class ReportAdmin {
    int numberReser;
    String userName;
    int idUser;
    int numberRoom;
    String entryDate;
    String exitDate;
    String estado;
    Double price;

    public ReportAdmin(int numberReser, String userName, int idUser, int numberRoom, String entryDate, String exitDate, String estado, Double price) {
        this.numberReser = numberReser;
        this.userName = userName;
        this.idUser = idUser;
        this.numberRoom = numberRoom;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.estado = estado;
        this.price = price;
    }

    public int getNumberReser() {
        return numberReser;
    }

    public void setNumberReser(int numberReser) {
        this.numberReser = numberReser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    
    
}
