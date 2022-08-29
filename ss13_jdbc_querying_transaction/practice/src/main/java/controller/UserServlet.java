package controller;

import module.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = {"", "/user"})
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormAdd(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "view":
                viewUser(request, response);
                break;
            case "search":
                searchByCountry(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
                showListUser(request, response);
        }

    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        request.setAttribute("user", userService.sortByName());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
        String countrySearch = request.getParameter("countrySearch");
        List<User> users = userService.findByCountry(countrySearch);
        request.setAttribute("user", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            default:
                showListUser(request, response);

        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        request.setAttribute("user", userService.findByAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error_404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        List<User> userList = userService.findByAll();
        request.setAttribute("user", userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("mess", user);
        requestDispatcher.forward(request, response);
    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userService.update(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        boolean check = userService.add(user);
        String mess = "thêm mới thành công";
        if (!check) {
            mess = "thêm mới thành công";
        }
        request.setAttribute("mess", mess);
        showFormAdd(request, response);
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        RequestDispatcher requestDispatcher;
        if (user == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("user", user);
            requestDispatcher = request.getRequestDispatcher("user/view.jsp");
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}