package Controllers;

import DAO.UserDAO;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class UserController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Khởi tạo đối tượng kiểu UserDAO
        UserDAO userDao = new UserDAO();
        // Gọi hàm getUsers() để lấy danh sách các User
        List<User> users = userDao.getUsers();
        // Tạo đối tượng để trả về dữ liệu cho response
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        
        out.println("<table border='1'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Gender</th></tr>");
        // In ra
        for(User u : users){
            out.println("<tr>");
            out.println("<td>" + u.getId() + "</td>");
            out.println("<td>" + u.getUsername() + "</td>");
            out.println("<td>" + u.getGender()+ "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
