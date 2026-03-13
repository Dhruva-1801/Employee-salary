<%@ page import="java.util.*, model.Employee" %>
<html>
<body>
<h2>Employee List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Salary</th>
    <th>Update</th>
    <th>Delete</th>
</tr>

<%
List<Employee> list = (List<Employee>) request.getAttribute("empList");
for (Employee e : list) {
%>
<tr>
    <td><%= e.getEmpId() %></td>
    <td><%= e.getEmpName() %></td>
    <td><%= e.getSalary() %></td>

    <td>
        <form action="updateEmployee.jsp">
            <input type="hidden" name="id" value="<%= e.getEmpId() %>">
            <input type="submit" value="Update">
        </form>
    </td>

    <td>
        <form action="deleteEmployee" method="post">
            <input type="hidden" name="id" value="<%= e.getEmpId() %>">
            <input type="submit" value="Delete">
        </form>
    </td>
</tr>
<% } %>
</table>

<br>
<a href="index.jsp">Add Employee</a>
</body>
</html>
