import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/CalculateProccess"})
public class CalculateProccess extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            // Kiểm tra dữ liệu m, n có rỗng không
            String txtM = request.getParameter("txtM");
            String txtN = request.getParameter("txtN");
            /*
            if( txtM == null || txtM.trim().isEmpty()){
                out.println("Biến M không được phép để trống!");
                return;
            }
            if( txtN == null || txtN.trim().isEmpty()){
                out.println("Biến N không được phép để trống!");
                return;
            }
            */
            if( txtM == null || txtM.trim().isEmpty() || txtN == null || txtN.trim().isEmpty()){
                out.println("M, N không được phép để trống!");
                return; // Kết thúc thực thi của hàm
            }
            
            // Lấy dữ liệu từ Form: txtM, txtN, rbO -> Gán cho các biến cục bộ
            double m = Double.parseDouble(txtM);
            double n = Double.parseDouble(txtN);
            String op = request.getParameter("rbO");
            
            // Xử lý tính toán và in ra kết quả của response thông qua PrintWriter
            // Theo format: Kết quả M +|-|*|/ N = ?
            // Nếu chia 1 số cho 0 (N=0) thì in ra: "Chia một số cho 0. Nhập lại N"
            switch (op) {
                case "+":
                    out.println("Tổng của M + N = " + (m+n));
                    break;
                case "-":
                    out.println("Hiệu của M - N = " + (m-n));
                    break;
                case "*":
                    out.println("Tích của M * N = " + (m*n));
                    break;
                case "/":
                    if(n==0){
                        out.println("Chia 1 số cho 0. Nhập lại N!");
                    }else{
                        double result = m/n;
                        String stringFormatted = String.format("%.2f", result);
                        out.println("Thương cua m/n = " + stringFormatted);
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            out.println("Nhập sai định dạng số của m hoặc n!");
        }
    }
    
}
