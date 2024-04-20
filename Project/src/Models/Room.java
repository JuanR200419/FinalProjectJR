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

    private int id_room;
    private int id_stade_room;
    // (individual, double, suite, etc.)
    private int numberGuests;
    private int id_type_room;
    private int id_hotel;
    private int number_rooom;
    private double priceNigth;
    private String amenitiesDetails;

    public Room(int id_room, int id_stade_room, int numberGuests, int id_type_room, int id_hotel, int number_rooom, double priceNigth, String amenitiesDetails) {
        this.id_room = id_room;
        this.id_stade_room = id_stade_room;
        this.numberGuests = numberGuests;
        this.id_type_room = id_type_room;
        this.id_hotel = id_hotel;
        this.number_rooom = number_rooom;
        this.priceNigth = priceNigth;
        this.amenitiesDetails = amenitiesDetails;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_stade_room() {
        return id_stade_room;
    }

    public void setId_stade_room(int id_stade_room) {
        this.id_stade_room = id_stade_room;
    }

    public int getNumberGuests() {
        return numberGuests;
    }

    public void setNumberGuests(int numberGuests) {
        this.numberGuests = numberGuests;
    }

    public int getId_type_room() {
        return id_type_room;
    }

    public void setId_type_room(int id_type_room) {
        this.id_type_room = id_type_room;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getNumber_rooom() {
        return number_rooom;
    }

    public void setNumber_rooom(int number_rooom) {
        this.number_rooom = number_rooom;
    }

    public double getPriceNigth() {
        return priceNigth;
    }

    public void setPriceNigth(double priceNigth) {
        this.priceNigth = priceNigth;
    }

    public String getAmenitiesDetails() {
        return amenitiesDetails;
    }

    public void setAmenitiesDetails(String amenitiesDetails) {
        this.amenitiesDetails = amenitiesDetails;
    }

}
