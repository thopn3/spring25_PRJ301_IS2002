package Controllers;

import DAO.UserDAO;
import Models.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy tham số 'id' trên url
        int userId = Integer.parseInt(req.getParameter("id"));
        // Lấy User theo Id
        UserDAO dao = new UserDAO();
        User editUser = dao.getUserById(userId);
        req.setAttribute("user", editUser);
        req.getRequestDispatcher("EditUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String gender = req.getParameter("gender");
            String address = req.getParameter("address");
            String city = req.getParameter("city");
            String favorites[] = req.getParameterValues("fav");
            // Khai báo đối tượng kiểu User để cung cấp dữ liệu cho các thuộc tính
            User editUser = new User();
            editUser.setId(id);
            editUser.setUsername(username);
            editUser.setPassword(password);
            editUser.setGender(gender);
            editUser.setAddress(address);
            editUser.setCity(city);
            editUser.setFavorites(String.join(";", favorites));
            // Khởi tạo đối tượng kiểu UserDAO để gọi hàm xử lý lưu newUser -> DB
            UserDAO userDao = new UserDAO();
            int rowEffected = userDao.editUser(editUser);
            if(rowEffected>0)
                resp.sendRedirect("user");
            // Điều hướng về /user
            resp.sendRedirect("user");
        } catch (Exception e) {
        }
    }
    
    
}
