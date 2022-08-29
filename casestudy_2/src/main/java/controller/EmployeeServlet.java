package controller;

import module.Division;
import module.EducationDegree;
import module.Employee;
import module.Position;
import repository.IEducationDegreeRepository;
import repository.impl.EducationDegreeRepository;
import service.IDivisionService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionService;
import service.impl.EmployeeService;
import service.impl.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/Employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IDivisionService divisionService = new DivisionService();
    private IPositionService positionService = new PositionService();
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:
                showEmployeeForm(request,response);
        }
    }

    private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeRepository.findAll();
        List<Division> divisions = divisionService.findAll();
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("positionList",positions);
        request.setAttribute("educationDegreesList",educationDegrees);
        request.setAttribute("divisionList",divisions);
        request.setAttribute("employeesList",employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
