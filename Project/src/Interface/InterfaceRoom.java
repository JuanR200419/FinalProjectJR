/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Models.Room;

/**
 *
 * @author juan
 */
public interface InterfaceRoom {
            public void insertRoom(Room room);
    public Room searchRoom(int id );
    public void deleteRoom(int id);
    public void updateRoom(Room room);

}
