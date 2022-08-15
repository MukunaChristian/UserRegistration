/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.userregis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class UserRegistration {

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/Hackathon2022";
    private final String dbUsername = "Administrator";
    private final String dbpassword = "password";

    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;

    public UserRegistration(String title, String firstName, String lastName, String gender, String email, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public void save() {
        Connection connection = null;
        PreparedStatement statement = null;
        int ok;
        String sql = "INSERT INTO UserRegistration VALUES(?,?,?,?,?,?)";

        try {
            connection = DriverManager.getConnection(DATABASE_URL, dbUsername, dbpassword);
            statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, gender);
            statement.setString(5, email);
            statement.setString(6, password);

            ok = statement.executeUpdate();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Success user added");
            } else {
                JOptionPane.showMessageDialog(null, "error could not add user");
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error: " + sqlException.getMessage());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "wanning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "warnning", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//    public ArrayList<String> LoadCaregiver() {
//
//        ArrayList<String> values = new ArrayList();
//
//        Connection co = null;
//        Statement statement = null;
//        ResultSet result = null;
//
//        try {
//            co = DriverManager.getConnection(DATABASE_URL, dbUsername, dbpassword);
//            statement = co.createStatement();
//            result = statement.executeQuery("SELECT CaregiverTypeName FROM CaregiverTypes");
//
//            while (result.next()) {
//                values.add(result.getObject(1).toString());
//
//            }
//        } catch (Exception e) {
//
//        }
//
//         
//
//    }

}