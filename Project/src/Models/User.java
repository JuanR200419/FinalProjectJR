/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author juan
 */
public class User {
    int id;
    String name;
    String username;
    String password;
    String countDetails;
    String typeUser;

    public User(int id, String name, String username, String password, String countDetails, String typeUser) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.countDetails = countDetails;
        this.typeUser = typeUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountDetails() {
        return countDetails;
    }

    public void setCountDetails(String countDetails) {
        this.countDetails = countDetails;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
    
}
