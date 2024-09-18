package thong.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItem {
    
    private int quantity;
    private double price;
    private int orderId;
    private int productId;

    // Constructor and getters/setters
    public OrderItem(int quantity, double price, int orderId, int productId) {
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.productId = productId;
    }

    public boolean insert(Connection con) {
        String sql = "INSERT INTO ORDER_ITEMS(ID, QUANTITY, PRICE, ORDER_ID, PRODUCT_ID) VALUES(NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.quantity);       // Correct type
            stmt.setDouble(2, this.price);       // Correct type
            stmt.setInt(3, this.orderId);        // Correct type
            stmt.setInt(4, this.productId);      // Correct type
            
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Connection con) {
        String sql = "UPDATE ORDER_ITEMS SET quantity = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.quantity);      // Correct type
            stmt.setDouble(2, this.price);      // Correct type
            stmt.setInt(3, this.orderId);       // Correct type
            stmt.setInt(4, this.productId);     // Correct type
            return stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id, Connection con) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDER-ITEMS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public void find(int id, Connection con) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDER-ITEMS" ;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void findAll(Connection con) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES" ;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
