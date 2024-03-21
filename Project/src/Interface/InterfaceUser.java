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
    public void insert(User user);
    public int selectLogin(String email,String password);
    public User searchAdmin(int id );
    public void delete(int id);
    public void update(User user);
}
