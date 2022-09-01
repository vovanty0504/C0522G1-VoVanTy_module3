package controller;

import module.Division;
import module.EducationDegree;
import module.Employee;
import module.Position;
import repository.IEducationDegreeRepository;
import repository.impl.EducationDegreeRepository;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionService;
import service.impl.EducationDegreeService;
import service.impl.EmployeeService;
import service.impl.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IDivisionService divisionService = new DivisionService();
    private IPositionService positionService = new PositionService();
    private IEducationDegreeService iEducationDegreeService = new EducationDegreeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                showUpdateEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                showListEmployee(request, response);
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        String addressSearch = request.getParameter("addressSearch");
        String phoneSearch = request.getParameter("phoneSearch");
        List<Employee> employeeList = employeeService.find(nameSearch,addressSearch,phoneSearch);
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        request.setAttribute("employeesList",employeeList);
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showUpdateEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/edit.jsp");

        request.setAttribute("employeeList", employee);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        showListEmployee(request, response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = iEducationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("positionList", positions);
        request.setAttribute("educationDegreesList", educationDegrees);
        request.setAttribute("divisionList", divisions);
        request.setAttribute("employeesList", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            default:
                showListEmployee(request, response);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreesId = Integer.parseInt(request.getParameter("educationDegreesId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(id, name, dayOfBirth, idCard, salary, phone, email, address, positionId, educationDegreesId, divisionId);
        boolean check = employeeService.updateEmployee(employee);
        String mess = "Sửa thành công";
        if (!check) {
            mess = " Sửa Không Thành Công";
        }
        request.setAttribute("mess", mess);
        showUpdateEmployee(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreesId = Integer.parseInt(request.getParameter("educationDegreesId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(name, dayOfBirth, idCard, salary, phone, email, address, positionId, educationDegreesId, divisionId);
        boolean check = employeeService.create(employee);
        String mess = "Add new Employee successfully!";
        if (!check) {
            mess = "Add new Customer successfully failed!";
        }
        request.setAttribute("mess", mess);
        request.setAttribute("check", check);
        showListEmployee(request, response);
    }
}
