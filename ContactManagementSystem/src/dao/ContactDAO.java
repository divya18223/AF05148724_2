package dao;

import java.sql.*;
import util.DBConnection;
import model.Contact;

public class ContactDAO {

    public void addContact(Contact c) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO contacts(name, phone) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());

            ps.executeUpdate();
            System.out.println("Contact added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewContacts() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM contacts");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM contacts WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}