package dao;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	public static int getTotalEmployees(){

	    int count = 0;

	    try{
	        Connection con = DBConnection.getConnection();
	        Statement st = con.createStatement();

	        ResultSet rs =
	        st.executeQuery("SELECT COUNT(*) FROM employee");

	        if(rs.next()){
	            count = rs.getInt(1);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return count;
	}

	public static List<Employee> searchEmployee(String keyword){

	    List<Employee> list = new ArrayList<>();

	    try{
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps =
	        con.prepareStatement("SELECT * FROM employee WHERE emp_name LIKE ? OR emp_id=?");

	        ps.setString(1,"%"+keyword+"%");
	        ps.setInt(2,Integer.parseInt(keyword));

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()){
	            Employee e = new Employee(
	                rs.getInt("emp_id"),
	                rs.getString("emp_name"),
	                rs.getDouble("salary")
	            );

	            list.add(e);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}
    public static void insertEmployee(Employee emp) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)");

            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getEmpName());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void updateEmployee(int id, double salary) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(
                            "UPDATE employee SET salary=? WHERE emp_id=?");

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(
                            "DELETE FROM employee WHERE emp_id=?");

            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
