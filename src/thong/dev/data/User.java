package thong.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

	public static void insert(Connection con) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO USERS(ID, EMAIL, PASSWORD, ROLE) VALUES(null, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "user email");
            stmt.setString(2, "password");
            stmt.setString(3, "role");
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void update(Connection con) {
        // TODO Auto-generated method stub
        String sql = "UPDATE USERS SET email = ? ,password = ?, role = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "user2 email");
            stmt.setString(2, "password");
            stmt.setString(3, "role");
            stmt.setInt(4, 1); //1 la id user can cap nhat
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	public static void delete(Connection con) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM USERS WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, 1);
             stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public static void find(int id, Connection con) {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void findAll(Connection con) {
        String sql = "SELECT * FROM Users WHERE ID > ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void find(String email, String password, Connection con) {
        String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
