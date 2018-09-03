package ir.ac.shahreza.computer.pouyan_jaberi.general.databases;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;

public class MyConnection {
    private static MyConnection myConnection = new MyConnection();
    private static DataSource dataSource;
    private MyConnection(){
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mydatasource");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static java.sql.Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[Connection Pool Error]" + e.getMessage());
            return null;
        }
    }


}
