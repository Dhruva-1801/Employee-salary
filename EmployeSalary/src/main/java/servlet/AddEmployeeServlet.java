package servlet;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("empId"));
        String name = request.getParameter("empName");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee(id, name, salary);
        EmployeeDAO.insertEmployee(emp);

        response.sendRedirect("success.jsp");
    }
}
