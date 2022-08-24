package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("firstOperand"));
        float secondOperand = Integer.parseInt(request.getParameter("secondOperand"));
        char operator = request.getParameter("operator").charAt(0);
        String result;
        switch (operator) {
            case '+':
                result = String.valueOf(firstOperand + secondOperand);
                break;
            case '-':
                result = String.valueOf(firstOperand - secondOperand);
                break;
            case '*':
                result = String.valueOf(firstOperand * secondOperand);
                break;
            case '/':
            default:
                if (secondOperand == 0) {
                    result="lỗi chia cho 0";
                } else
                    result = String.valueOf(firstOperand / secondOperand);
        }

        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/result.jsp");
        request.setAttribute("result",result);
        requestDispatcher.forward(request,response);
    }
}
