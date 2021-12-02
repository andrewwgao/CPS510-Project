package db;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDB {
    public static ObservableList<Employee> searchEmployees() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT e.emp_id, e.emp_f_name, e.emp_l_name, e.phone, e.email, e.dob, e.position_title, e.status, e.salary\n" +
                "    FROM hotel_employee e\n" +
                "    WHERE e.position_title= 'Cleaning Staff'\n" +
                "    AND NOT EXISTS\n" +
                "    (SELECT *\n" +
                "    FROM  hotel_rooms r\n" +
                "    WHERE e.emp_id= r.checked_by)";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Employee> empList = getEmployeeList(rsSet);
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // get employee data
    public static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Employee> empList = FXCollections.observableArrayList();

        while (rs.next()){
            Employee emp = new Employee();
            emp.setEmpID(rs.getInt("EMP_ID"));
            emp.setfName(rs.getString("EMP_F_NAME"));
            emp.setlName(rs.getString("EMP_L_NAME"));
            emp.setPhone(rs.getInt("PHONE"));
            emp.setEmail(rs.getString("EMAIL"));
            emp.setDOB(rs.getDate("DOB"));
            emp.setPosition(rs.getString("POSITION_TITLE"));
            emp.setStatus(rs.getString("STATUS"));
            emp.setSalary(rs.getInt("SALARY"));

            empList.add(emp);
        }
        return empList;
    }

    // show all emps in table
    public static ObservableList<Employee> viewEmployees() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM HOTEL_EMPLOYEE";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Employee> empList = getEmployeeList(rsSet);
            return empList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // insert data into table
    public static void insertEmployees() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('15/05/1982', 'DD/MM/YYYY'), 'michaelscott@dundermifflinpaperco.com', 'Scott', 'Michael', 10243, 1234567891, 'Manager', 35000, 'full-time')";
        String selectStmt2 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('20/01/1983', 'DD/MM/YYYY'), 'dwightschrute@dundermifflinpaperco.com', 'Schrute', 'Dwight', 11587, 1234567891, 'Booking Agent', 29000, 'full-time')";
        String selectStmt3 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('01/10/1985', 'DD/MM/YYYY'), 'jameshalpert@dundermifflinpaperco.com', 'Halpert', 'James', 21702, 1234567891, 'Booking Agent', 29000, 'full-time')";
        String selectStmt4 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('12/07/1981', 'DD/MM/YYYY'), 'pamelabesley@dundermifflinpaperco.com', 'Besley', 'Pamela', 10981, 1234567891, 'Reception', 25000, 'full-time')";
        String selectStmt5 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('30/01/1999', 'DD/MM/YYYY'), 'ryanhoward@dundermifflinpaperco.com', 'Howard', 'Ryan', 20943, 1234567891, 'Cleaning Staff', 17000, 'part-time')";
        String selectStmt6 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('25/04/1982', 'DD/MM/YYYY'), 'kevinmalone@dundermifflinpaperco.com', 'Malone', 'Kevin', 20503, 1234567891, 'Cleaning Staff', 26000, 'terminated')";
        String selectStmt7 = "INSERT INTO hotel_employee(dob , email , emp_l_name , emp_f_name , emp_id , phone , position_title , salary , status)VALUES(TO_DATE('21/10/1955', 'DD/MM/YYYY'), 'kellykapoor@dundermifflinpaperco.com', 'Kapoor', 'Kelly', 19945, 1234567891, 'Cleaning Staff', 26000, 'full-time')";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt2);
            DBUtil.dbExecuteUpdate(selectStmt3);
            DBUtil.dbExecuteUpdate(selectStmt4);
            DBUtil.dbExecuteUpdate(selectStmt5);
            DBUtil.dbExecuteUpdate(selectStmt6);
            DBUtil.dbExecuteUpdate(selectStmt7);

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}
