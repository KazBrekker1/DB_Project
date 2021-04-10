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
            ResultSet rs = stmt.executeQuery("select prj_emp.name ,username, pass from prj_login, prj_emp where prj_emp.id = enum");
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

    public static String addEmployee(String eName, int phone, String hireDate, String dob, String gender, int salary, double commission, String dept, String position) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(String.format("insert into prj_emp values (default, '%s', %d, '%s', '%s', '%s', %d, %f, '%s', '%s')", eName, phone, hireDate, dob, gender, salary, commission, dept, position));
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Smth is Wrong !";
        }
        return "Success";
    }

    public static String updateEmployee(String EID, int salary) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(String.format("update prj_emp set salary = %d where id = %s", salary, EID));
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Smth is Wrong !";
        }
        return "Success";
    }

    public static String removeEmployee(int Enumber) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
//            green
            stmt.executeUpdate(String.format("delete from prj_emp where ID = %d", Enumber));
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Smth is Wrong !";
        }
        return "Success";
    }

    public static String[] searchEmployee(String empNumber) {
        String[] empInfo = new String[8];
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select name, phone, dob, hiredate, salary, commission, dept, position from prj_emp where id = " + empNumber);
            while (rs.next()) {
                String empname = rs.getString(1);
                String empPhone = rs.getString(2);
                String dob = rs.getDate(3).toString();
                String hireDate = rs.getDate(4).toString();
                int salary = rs.getInt(5);
                int commission = rs.getInt(6);
                String dept = rs.getString(7);
                String position = rs.getString(8);
                if (empname != null) {
                    empInfo[0] = empname;
                    empInfo[1] = empPhone;
                    empInfo[2] = dob;
                    empInfo[3] = hireDate;
                    empInfo[4] = Integer.toString(salary);
                    empInfo[5] = Integer.toString(commission);
                    empInfo[6] = dept;
                    empInfo[7] = position;
                    return empInfo;
                }
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empInfo;
    }

    public static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> empsList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
//            Here It Should be the required Info
            String sql = "select emps.Name, depts.Dname, emps.HIREDATE from prj_emp emps, prj_dept depts where emps.Dept = depts.Dname";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(1);
                String deptName = rs.getString(2);
                String hireDate = rs.getDate(3).toString();
                empsList.add(new Employee(name, deptName, hireDate));
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empsList;
    }

    public static ArrayList<Project> getAllProjects() {
        ArrayList<Project> projectsList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
//            Here It Should be the required Info
            String sql = "select prj.prjName, prj.project_description, prj_dept.Dname from prj_project prj, prj_and_dept prj_dept where prj.prjCode = prj_dept.prjCode";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(1);
                String description = rs.getString(2);
                String dname = rs.getString(3);
                projectsList.add(new Project(name, description, dname));
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return projectsList;
    }

    public static ArrayList<Vehicle> getAllVehicles() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            Statement stmt = conn.createStatement();
//            Here It Should be the required Info
            String sql = "select emp.Name, veh.Model, maint.next_maintenance from prj_vehicle veh, prj_emp emp, prj_vehicle_maint maint where veh.ENum = emp.ID and veh.license = maint.license";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String eName = rs.getString(1);
                String model = rs.getString(2);
                String nextMaint = rs.getDate(3).toString();
                vehicleList.add(new Vehicle(eName, model, nextMaint));
            }
            rs.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vehicleList;
    }

    public static void commitAll() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa"
                    , "ye1800846", "ye1800846");
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
