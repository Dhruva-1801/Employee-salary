package servlet;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewEmployee")
public class ViewEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> list = EmployeeDAO.getAllEmployees();
        request.setAttribute("empList", list);

        RequestDispatcher rd =
                request.getRequestDispatcher("viewEmployee.jsp");
        rd.forward(request, response);
    }
}
