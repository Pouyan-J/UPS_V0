package ir.ac.shahreza.computer.pouyan_jaberi.seller.beans;

import ir.ac.shahreza.computer.pouyan_jaberi.general.beans.User;

public class Seller implements User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    //<editor-fold desc="Getters and Setters">
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //</editor-fold>


    public Seller(String username, String password, String firstName,
                  String lastName, String phone, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Seller(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Seller() {
    }
}
