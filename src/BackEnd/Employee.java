package BackEnd;

public class Employee {
    private String name;
    private Integer phone;
    private String DOB;
    private String hireDate;
    private String deptName;

    public Employee(String name, Integer phone, String DOB) {
        this.name = name;
        this.phone = phone;
        this.DOB = DOB;
    }

    public Employee(String name, String deptName, String hireDate) {
        this.name = name;
        this.deptName = deptName;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
