package Controllers;

import DAO.UserDAO;
import Models.User;
import java.io.IOException;
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
        
        // Tạo 1 attribute để chứa kết quả trả về
        request.setAttribute("result", users);
        // Chuyển tiếp kết quả ra JSP để trình bày
        request.getRequestDispatcher("ListUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Tiếp nhận dữ liệu từ CreateUser.html
        try {
            int id = Integer.parseInt(req.getParameter("txtId"));
            String username = req.getParameter("txtUser");
            String password = req.getParameter("txtPass");
            // Khai báo đối tượng kiểu User để cung cấp dữ liệu cho các thuộc tính
            User newUser = new User();
            newUser.setId(id);
            newUser.setUsername(username);
            newUser.setPassword(password);
            // Khởi tạo đối tượng kiểu UserDAO để gọi hàm xử lý lưu newUser -> DB
            UserDAO userDao = new UserDAO();
            userDao.addNewUser(newUser);
            // Điều hướng về /user
            resp.sendRedirect("user");
        } catch (Exception e) {
        }
    }
}
