package thong.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Product {

	public static int insert(Connection con) {
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "product Name");
            stmt.setString(2, "product Description");
            stmt.setString(3, "product Thumbnail");
            stmt.setDouble(4, 100);
            stmt.setInt(5, 10);
            stmt.setInt(6, 1);

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            return generatedKey;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
	
	public static void update(Connection con) {
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "product Name");
		    stmt.setString(2, "product Description");
		    stmt.setString(3, "product Thumbnail");
		    stmt.setDouble(4, 100);
		    stmt.setInt(5, 10);
		    stmt.setInt(6, 1);

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
	public static void delete(int id, Connection con) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
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
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void findAll(Connection con) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void hot( int limit, Connection con) {
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
	
	public static void findByCategory(int categoryId, Connection con) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public static void filter(int categoryId, String propertyName, String order, Connection con) {
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY ? ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, propertyName);
            stmt.setString(3, order);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
