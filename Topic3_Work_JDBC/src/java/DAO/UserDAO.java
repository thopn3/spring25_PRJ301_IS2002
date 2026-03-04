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

    public void addNewUser(User newUser) {
        try {
            String sql = "INSERT INTO users(id,username,password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            // Truyền dữ liệu cho tham số của câu truy vấn
            ps.setInt(1, newUser.getId());
            ps.setString(2, newUser.getUsername());
            ps.setString(3, newUser.getPassword());
            // Thực thi truy vấn
            ps.executeUpdate(); // Insert, Update, Delete
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public User getUserById(int userId) {
        User user = new User();
        try {
            String sql = "SELECT * FROM users WHERE id = "+ userId;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setFavorites(rs.getString("favorites"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return user;
    }

    public int editUser(User editUser) {
        int rows = 0;
        try {
            String sql = "UPDATE users SET username=?,password=?,gender=?,address=?,city=?,favorites=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, editUser.getUsername());
            ps.setString(2, editUser.getPassword());
            ps.setString(3, editUser.getGender());
            ps.setString(4, editUser.getAddress());
            ps.setString(5, editUser.getCity());
            ps.setString(6, editUser.getFavorites());
            ps.setInt(7, editUser.getId());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rows;
    }

    public int deleteUser(int id) {
        int rows = 0;
        try {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rows;
    }
}
