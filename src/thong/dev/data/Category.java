package thong.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
	public static void readAll(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				
				System.out.format("id:%d - name:%s - description:%s", id, name, description).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readOne(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 2);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				
				System.out.format("id:%d - name:%s - description:%s", id, name, description).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delete(Connection con) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update(Connection con) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORIES SET name = ?, description = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Ao Nam Han Quoc");
			stmt.setString(2, "Mo ta ao nam");
			stmt.setInt(3, 1);
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insert(Connection con) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CATEGORIES VALUES(NULL, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Ao Nam");
			stmt.setString(2, "Danh muc ao nam");
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
