package BackEnd;

import java.sql.*;
import java.util.ArrayList;

public class Fetcher {
    private static String empName;
    private static String userName;
    private static String password;

    public Fetcher() {

    }

    public static boolean loginUser(String user, String pass) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select emp_name ,username, pass from prj_login");
            while (rs.next()) {
                String empname = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                if (username.equals(user) && password.equals(pass)) {
                    setPassword(pass);
                    setUserName(user);
                    setEmpName(empname);
                    System.out.println("User Logged In !");
                    return true;
                }
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> empsList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
//            Here It Should be the required Info
            ResultSet rs = stmt.executeQuery("select name, phone, dob from prj_emp");
            while (rs.next()) {
                String name = rs.getString(1);
                int phone = rs.getInt(2);
                String dob = rs.getDate(3).toString();
                empsList.add(new Employee(name, phone, dob));
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empsList;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Fetcher.userName = userName;
    }

    public static String getEmpName() {
        return empName;
    }

    public static void setEmpName(String empName) {
        Fetcher.empName = empName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Fetcher.password = password;
    }

}
