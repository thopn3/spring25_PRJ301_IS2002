package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Khai báo đối tượng connection
    protected Connection conn = null;
    
    public DBConnection(){
        try {
            // Khai báo các thông số làm việc với RDBMS
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=IS2002DB;TrustServerCertificate=true";
            String userDb = "sa";
            String passDb = "123";
            // Tiến hành kết nối tới CSDL
            Class.forName(driverName); // Nạp driver JDBC từ thư viện đã import
            conn = DriverManager.getConnection(dbUrl, userDb, passDb);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
//    public static void main(String[] args) {
//        DBConnection db = new DBConnection();
//        if(db.conn != null)
//            System.out.println("Kết nối thành công");
//        else
//            System.out.println("Kết nối thất bại");
//    }
}
