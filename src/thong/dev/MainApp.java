package thong.dev;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import thong.dev.data.*;

public class MainApp {

    static final String DB_URL = "jdbc:mysql://localhost/shop";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    public static void main(String[] args) {
        Connection con = null;
        try {
            con = getConnection();
            if (con != null) {
                /**
                 * Danh mục (Category)
                 */
                Category.insert(con);
                Category.update(con);
                Category.delete(con);
                Category.readOne(con);
                Category.readAll(con);

                /**
                 * Người dùng (User)
                 */
                User.insert(con);
                User.update(con);
                User.find(1, con);
                User.delete(con);
                User.find("user2 email", "password", con);
                User.findAll(con);
                
                /**
                 * Sản phẩm (Product)
                 */
                Product.insert(con);
                Product.update(con);
                Product.delete(1, con);
                Product.insert(con);
                Product.find(1, con);
                Product.findAll(con);
                Product.hot(1, con);
                Product.findByCategory(1, con);
                
                /**
                 * Đặt hàng  (Order)
                 */
                Order.insert(con);
                Order.update(con);
                Order.delete(1, con);
                Order.insert(con);
                Order.find(1, con);
                Order.findByUser(1, con);
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối trong khối finally để đảm bảo kết nối được đóng
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Kết nối thành công.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
