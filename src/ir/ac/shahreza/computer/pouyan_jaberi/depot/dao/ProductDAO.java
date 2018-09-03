package ir.ac.shahreza.computer.pouyan_jaberi.depot.dao;

import ir.ac.shahreza.computer.pouyan_jaberi.depot.beans.Product;
import ir.ac.shahreza.computer.pouyan_jaberi.general.databases.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    private Connection connection;

    //<editor-fold desc="Getters, Setters and Constructors">

    //</editor-fold>

    public void addProduct(Product product) {
        try {
            connection = MyConnection.getConnection();
            /*String sql = "INSERT INTO product (id, name, caption, username_fk, count)" +
                    "VALUES ('"+ product.getId() +"','"+ product.getName()+"','"+ product.getCaption()+"','"+
                    product.getSeller().getUsername() + "'," + product.getCount() + ");";
            System.out.println(sql);*/
            String sql = "INSERT INTO product (id, name, caption, username_fk, count) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCaption());
            preparedStatement.setString(4, product.getSeller().getUsername());
            preparedStatement.setInt(5, product.getCount());

            preparedStatement.executeQuery();

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
    }

    public int updateProduct(Product product) {
        int i = 0;
        try {
            connection = MyConnection.getConnection();
            /*String sql = "UPDATE product " +
                    "SET name = ?, caption = ?, username_fk = ?, count = ? " +
                    "WHERE id = ?";*/
            String sql = "UPDATE product " +
                    "SET name = ?, caption = ?, count = ? " +
                    "WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCaption());
            preparedStatement.setInt(3, product.getCount());
            //preparedStatement.setString(3, product.getSeller().getUsername());

            preparedStatement.setString(4, product.getId());
            i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("[DAO Error] " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                return i;
            } catch (SQLException e) {
                System.out.println("[DAO Error] " + e.getMessage());
                e.printStackTrace();
            }
        }

        return i;
    }

    public Product getProductInfo(Product product) {
        Product p = new Product();
        Connection connection = MyConnection.getConnection();
        try {
            String sql = "SELECT id pid, name n, caption cap, username_fk s, count c" +
                    " FROM product WHERE id = ?";
            /*String sql = "SELECT id pid, name n, caption cap, username_fk s, count c" +
                    " FROM product WHERE id = '" + product.getId() + "'";*/
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                p.setId(resultSet.getString("pid"));
                p.setName(resultSet.getString("n"));
                p.setCaption(resultSet.getString("cap"));
                p.setCount(resultSet.getInt("c"));
            }

            resultSet.close();

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

        return p;
    }

    public boolean buyProduct(Product product, int number) {
        Product rp = getProductInfo(product);
        int count = rp.getCount();
        if (count < number) {
            return false;
        } else {
            rp.setCount(count - number);
            updateProduct(rp);
            return true;
        }
    }
}
