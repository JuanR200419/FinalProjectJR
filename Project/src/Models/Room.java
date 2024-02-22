/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author juan
 */
public class Room {
    int id;
    int numberRoom;
    String typeRoom;
    double priceNigth;
    boolean availability;
    String amenitiesDetails;

    public Room(int id, int numberRoom, String typeRoom, double priceNigth, boolean availability, String amenitiesDetails) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.priceNigth = priceNigth;
        this.availability = availability;
        this.amenitiesDetails = amenitiesDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public double getPriceNigth() {
        return priceNigth;
    }

    public void setPriceNigth(double priceNigth) {
        this.priceNigth = priceNigth;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getAmenitiesDetails() {
        return amenitiesDetails;
    }

    public void setAmenitiesDetails(String amenitiesDetails) {
        this.amenitiesDetails = amenitiesDetails;
    }
    
}
