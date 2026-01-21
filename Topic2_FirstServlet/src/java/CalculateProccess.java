/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns={"/CalculateProccess"})
public class CalculateProccess extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Lấy dữ liệu từ Form: txtM, txtN, rbO -> Gán cho các biến cục bộ
        
        // Kiểm tra kểu dữ liệu của M và N. Nếu sai định dạng (number character)
        // -> Hiển thị: "Yêu cầu nhập đúng định dạng là chữ số"
        
        // Xử lý tính toán và in ra kết quả của response thông qua PrintWriter
        // Theo format: Kết quả M +|-|*|/ N = ?
        // Nếu chia 1 số cho 0 (N=0) thì in ra: "Chia một số cho 0. Nhập lại N"
    }
    
}
