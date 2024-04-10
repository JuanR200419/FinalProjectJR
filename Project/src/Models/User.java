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
    private String address;

    public User(int id, String name, int age, String username, String password, String email, String countDetails, int typeUser, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.email = email;
        this.countDetails = countDetails;
        this.typeUser = typeUser;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

}
