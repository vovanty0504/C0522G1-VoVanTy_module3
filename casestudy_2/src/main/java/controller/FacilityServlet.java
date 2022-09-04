package controller;

import module.Facility;
import module.FacilityType;
import module.RentType;
import service.IFacilityService;
import service.IFacilityTypeService;
import service.IRentTypeService;
import service.impl.FacilityService;
import service.impl.FacilityTypeService;
import service.impl.RentTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();
    private IRentTypeService rentTypeService = new RentTypeService();
    private IFacilityTypeService facilityTypeService = new FacilityTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFacility(request, response);
                break;
            case "delete":
                deleteFacility(request, response);
                break;
            case "edit":
                ShowUpdateFacility(request, response);
                break;
            case "search":
                searchFacility(request, response);
                break;
            default:
                showListFacility(request, response);
        }
    }

    private void searchFacility(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("facility/list.jsp");
        String name = request.getParameter("nameSearch");
        String facilityType = request.getParameter("facilityTypeSearch");
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<Facility> facilityList = facilityService.search(name, facilityType);
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("facilityList", facilityList);
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateFacility(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facilityTypeList", facilityTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("facility/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowUpdateFacility(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Facility facilityList = facilityService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("facility/edit.jsp");
        request.setAttribute("facilityList", facilityList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facilityTypeList", facilityTypeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        facilityService.deleteFacility(id);
        showListFacility(request, response);

    }

    private void showListFacility(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("facility/list.jsp");
        request.setAttribute("facilityList", facilityList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("requestDispatcher", requestDispatcher);
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
                createFacility(request, response);
                break;
            case "delete":
                deleteFacility(request, response);
                break;
            case "edit":
                updateFacility(request, response);
                break;
            default:
                showListFacility(request, response);
        }
    }

    private void createFacility(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("facilityName");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int facilityType = Integer.parseInt(request.getParameter("facilityType"));
        Facility facility = new Facility(name, area, cost, maxPeople, standardRoom, description, poolArea, numberOfFloors, facilityFree
                , rentType, facilityType);
        boolean check = facilityService.create(facility);
        String mess = "Thêm mới thành công.";
        if (!check) {
            mess = "Thêm mới không thành công.";
        }

        request.setAttribute("mess", mess);
        request.setAttribute("check", check);

        showCreateFacility(request, response);
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));
        Facility facility = new Facility(id, name, area, cost, maxPeople, standardRoom, description, poolArea, numberOfFloors,
                facilityFree, rentTypeId, facilityTypeId);
        boolean check = facilityService.updateFacility(facility);
        String mess = "sửa thành công!";
        if (!check) {
            mess = "sửa không thành công!";
        }
        request.setAttribute("mess", mess);
        showListFacility(request, response);
    }
}
