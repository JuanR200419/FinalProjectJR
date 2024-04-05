/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Models.User;

/**
 *
 * @author jilssa
 */
public interface InterfaceUser {
    public void insertUser(User user);
    public int selectLogin(String email,String password);
    public User searchUser(int id );
    public void deleteUser(int id);
    public void updateUser(User user);
}
