<html>
<body>
<h2>Update Employee Salary</h2>

<form action="updateEmployee" method="post">
    <input type="hidden" name="id"
           value="<%= request.getParameter("id") %>">

    New Salary:
    <input type="number" step="0.01" name="salary" required><br><br>

    <input type="submit" value="Update Salary">
</form>

</body>
</html>
