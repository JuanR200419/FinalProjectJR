/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author jilssa
 */
public class City {
    private int id_city;
    private String nameCity;

    public City(int id_city, String nameCity) {
        this.id_city = id_city;
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
    return this.nameCity;
    }

    
    
    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
    
}
