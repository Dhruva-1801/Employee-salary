package servlet;

import dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        double salary = Double.parseDouble(request.getParameter("salary"));

        EmployeeDAO.updateEmployee(id, salary);
        response.sendRedirect("viewEmployee");
    }
}
