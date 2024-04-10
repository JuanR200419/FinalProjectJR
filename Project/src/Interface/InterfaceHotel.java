/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Models.Hotel;

/**
 *
 * @author juan
 */
public interface InterfaceHotel {

    public void insertHotel(Hotel hotel);

    public Hotel searchHotel(int id);
    
    public Hotel searchHotelbyName(String name);
    
    public void deleteHotel(int id);

    public void updateHotel(Hotel hotel);
}
