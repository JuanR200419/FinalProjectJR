/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author juan
 */
public class Reservation {

    private int id;
    private int user_id;
    //hotelroom
    private int room_id;
    private String entryDate;
    private String exitDate;
    //It have 3 states (confirm,ed canceled, pending)
    private int state;
    private double totalPrice;

    public Reservation(int id, int user_id, int room_id, String entryDate, String exitDate, int state, double totalPrice) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.state = state;
        this.totalPrice = totalPrice;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
