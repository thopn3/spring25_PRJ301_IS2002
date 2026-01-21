
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
    // Được gọi khi gửi yêu cầu thông qua: Liên kết hoặc Form data với phương thức là Get
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            // Tạo ra luồng ghi dữ liệu từ đối tượng response
            PrintWriter out = response.getWriter();
            // Lấy thông tin từ đối tượng request
            out.println("Method: " + request.getMethod());
            out.println("Context path: " + request.getContextPath());
            out.println("Servlet path: " + request.getServletPath());
            out.println("URI: " + request.getRequestURI());
            out.println("URL: " + request.getRequestURL());
            out.println("User-Agent: " + request.getHeader("User-Agent"));
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    } 

    // Được gọi khi yêu cầu từ client gửi từ Form theo phương thức Post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("text/html;charset=UTF-8");
            // Lấy dữ liệu từ Form
            String fName = request.getParameter("txtFName");
            String lName = request.getParameter("txtLName");
            
            // Tạo đối tượng để ghi dữ liệu trả về cho client
            PrintWriter out = response.getWriter();
            out.println("<div>");
            out.println("<h3> Welcome: " + fName + " " + lName + "</h3>");
            out.println("</div>");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
