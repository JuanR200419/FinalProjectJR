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
    private int id;
    private String name;
    private int age;
    private String username;
    private String password;
    private String email;
    private String countDetails;
    private int typeUser;
    private String adress;

    public User(int id, String name, String username, String password, String email, String countDetails, int typeUser, String adress) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.countDetails = countDetails;
        this.typeUser = typeUser;
        this.adress = adress;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountDetails() {
        return countDetails;
    }

    public void setCountDetails(String countDetails) {
        this.countDetails = countDetails;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
}
