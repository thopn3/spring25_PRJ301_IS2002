import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class RegisterProcess extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Note: Lấy dữ liệu từ các field dạng single value. 
        // Vd: type=text|password|radio|textarea|select -> getParameter()
        // TH lấy từ field multiple value. Vd: type=checkbox -> getParameterValues()
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        String gender = request.getParameter("rbGender");
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("ddlCity");
        String fav[] = request.getParameterValues("chkFavorite");
        
        String fGender;
        switch (gender) {
            case "1":
                fGender = "Male";
                break;
            case "2":
                fGender = "Female";
                break;
            default:
                fGender = "Other";
        }
        
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        out.println("<div>Username: "+ user +"</div>");
        out.println("<div>Password: "+ pass +"</div>");
        out.println("<div>Gender: "+ fGender +"</div>");
        out.println("<div>Address: "+ address +"</div>");
        out.println("<div>City: "+ city +"</div>");
        out.println("<div>Favorites: "+ String.join("; ", fav) +"</div>");
    }

}
