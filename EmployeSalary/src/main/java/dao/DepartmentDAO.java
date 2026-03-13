package dao;

import model.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public static List<Department> getDepartments() {

        List<Department> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM department");

            while(rs.next()) {
                Department d = new Department(
                        rs.getInt("dept_id"),
                        rs.getString("dept_name")
                );
                list.add(d);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}