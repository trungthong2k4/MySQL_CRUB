package thong.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Order {

	public static void insert(Connection con) {
        String sql = "INSERT INTO ORDERS(ID, CODE, STATUS, USER_ID) VALUES(NULL, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
    }
	
	public static void update(Connection con) {
        String sql = "UPDATE ORDERS SET code = ?, status = ?, user_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user
            stmt.setInt(4, 2); //2 là id của order cần cập nhật
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
	public static void delete(int id, Connection con) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDERS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
	public static void find(int id, Connection con) {
        String sql = "SELECT * FROM ORDERS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, created_at).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public static void findByUser(int userId, Connection con) {
        String sql = "SELECT * FROM ORDERS WHERE user_id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
//	public int countOrderByDay(String date ,Connection con) {
//        int count = 0;
//        String sql = "SELECT COUNT(*) AS count FROM orders where date(created_at)=?";
//        try {
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, date);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                count = rs.getInt("count");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return count;
//    }
}
