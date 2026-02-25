// Class này mô tả các chức năng (CRUD) làm việc với 
// dữ liệu kiểu User
package DAO;

import DAL.DBConnection;
import Models.User;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DBConnection{
    public UserDAO(){
        super();
    }
    
    /***
     * Get all users
     * @return List<User>
     */
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setCity(rs.getString("city"));
                user.setAddress(rs.getString("address"));
                user.setFavorites(rs.getString("favorites"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return users;
    }
}
