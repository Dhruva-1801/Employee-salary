package servlet;

import dao.EmployeeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int total = EmployeeDAO.getTotalEmployees();

        request.setAttribute("totalEmp", total);

        RequestDispatcher rd =
        request.getRequestDispatcher("dashboard.jsp");

        rd.forward(request,response);
    }
}