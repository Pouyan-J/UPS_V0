package ir.ac.shahreza.computer.pouyan_jaberi.seller.dao;

import ir.ac.shahreza.computer.pouyan_jaberi.general.databases.MyConnection;
import ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO {
    private static Connection connection;
    private Seller seller;

    //<editor-fold desc="Getters, Setters and Constructors">
    public SellerDAO() {
    }

    public SellerDAO(Seller seller) {
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    //</editor-fold>

    public boolean authenticate() {
        try {
            connection = MyConnection.getConnection();

            String sql = "SELECT * FROM SELLER" +
                    " WHERE username = ? AND password = ?";
            //System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, this.seller.getUsername());
            preparedStatement.setString(2, this.seller.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean empty = true;
            while (resultSet.next()) {
                empty = false;
                break;
            }

            resultSet.close();

            if (!empty) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("[DAO Error] " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("[DAO Error] " + e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    public Seller getInfo() {
        if (/*authenticate()*/ true) {
            try {
                connection = MyConnection.getConnection();
                String sql = "SELECT firstname f, lastname l, address a, phone p" +
                        " FROM SELLER" +
                        " WHERE username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, this.seller.getUsername());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    this.seller.setFirstName(resultSet.getString("f"));
                    this.seller.setLastName(resultSet.getString("l"));
                    this.seller.setAddress(resultSet.getString("a"));
                    this.seller.setPhone(resultSet.getString("p"));
                }
            } catch (SQLException e) {
                System.out.println("[DAO Error] " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("[DAO Error] " + e.getMessage());
                    e.printStackTrace();
                }

                return this.seller;
            }
        }
        return null;
    }

    public static List<Seller> searchSellers
            (String username, String firstName, String lastName) {
        connection = MyConnection.getConnection();
        List<Seller> list = new ArrayList<>();
        try {
            username = username
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![")
                    .trim();

            firstName = firstName
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");

            lastName = lastName
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            /*String sql = "SELECT * FROM seller WHERE " +
                    "username like '%?%' and " +
                    "firstname like '%?%' and " +
                    "lastname like '%?%'";*/
            String sql = "SELECT * FROM seller WHERE " +
                    "username like '%" + username +"%' and " +
                    "firstname like '%" + firstName + "%' and " +
                    "lastname like '%" + lastName + "%'";

            System.out.println(sql);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            /*preparedStatement.setString(1, username);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);*/
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Seller seller = new Seller();
                seller.setUsername(resultSet.getString("username"));
                seller.setFirstName(resultSet.getString("firstname"));
                seller.setLastName(resultSet.getString("lastname"));
                seller.setPhone(resultSet.getString("phone"));
                seller.setAddress(resultSet.getString("address"));
                list.add(seller);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("[DAO Error] " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Error");
            return null;
        }
    }

}
