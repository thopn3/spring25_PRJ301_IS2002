// Class này mô tả các chức năng (CRUD) làm việc với 
// dữ liệu kiểu User
package DAO;

import DAL.DBConnection;
import Models.User;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DBConnection{
    public UserDAO(){
        super();
    }
    
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
                // ...
                users.add(user);
            }
        } catch (Exception e) {
        }
        
        return users;
    }
}
