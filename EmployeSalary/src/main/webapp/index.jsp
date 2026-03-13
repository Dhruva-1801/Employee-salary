<html>
<body>
<h2>Employee Salary Record System</h2>

<form action="addEmployee" method="post">
    Employee ID: <input type="number" name="empId" required><br><br>
    Name: <input type="text" name="empName" required><br><br>
    Salary: <input type="number" step="0.01" name="salary" required><br><br>

    <input type="submit" value="Add Employee">
</form>

<br>
<a href="viewEmployee">View Employees</a>
</body>
</html>
