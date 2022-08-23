import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "product_discount_calculator_servlet", value = "/display-discount")
public class product_discount_calculator_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String product = request.getParameter("product");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        request.setAttribute("product" , product);
        request.setAttribute("discountAmount" , discountAmount);
        request.setAttribute("discountPrice" , discountPrice);
        requestDispatcher.forward(request,response);
    }
}
