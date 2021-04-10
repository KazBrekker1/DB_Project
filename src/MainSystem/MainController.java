package MainSystem;

import BackEnd.Employee;
import BackEnd.Fetcher;
import BackEnd.Project;
import BackEnd.Vehicle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MainController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab addEmpTAB;

    @FXML
    private Button addBTN;

    @FXML
    private Button clearBTN;

    @FXML
    private TextField eNameTXT;

    @FXML
    private TextField ePhoneTXT;

    @FXML
    private TextField hireTXT;

    @FXML
    private TextField dobTXT;

    @FXML
    private TextField genderTXT;

    @FXML
    private TextField salaryTXT;

    @FXML
    private TextField commissionTXT;

    @FXML
    private TextField deptTXT;

    @FXML
    private TextField positionTXT;

    @FXML
    private Tab removeEmpTAB;

    @FXML
    private Button deleteBTN;

    @FXML
    private TextField empIDTXT;

    @FXML
    private Tab updateSalaryTAB;

    @FXML
    private Button updateBTN;

    @FXML
    private TextField employeeIDTXT;

    @FXML
    private TextField newSalaryTXT;

    @FXML
    private Tab searchEmpTAB;

    @FXML
    private Button searchBTN;

    @FXML
    private TextField empIdTXT;

    @FXML
    private Label empNameLBL;

    @FXML
    private Label phoneLBL;

    @FXML
    private Label dobLBL;

    @FXML
    private Label hireLBL;

    @FXML
    private Label salLBL;

    @FXML
    private Label comLBL;

    @FXML
    private Label deptLBL;

    @FXML
    private Label positionLBL;


    @FXML
    private Button commitBTN;
    @FXML
    private Button commitBTN1;
    @FXML
    private Button commitBTN2;

    @FXML
    private Tab viewReportsTAB;

    @FXML
    private TableView viewsTBL;

    @FXML
    private Button viewAllBTN;

    @FXML
    private Button viewVehiclesBTN;

    @FXML
    private Button viewProjectsBTN;


    @FXML
    @SuppressWarnings("unchecked")
    public void initialize() {
//        Populate Table Column Names
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn<Employee, Integer> deptColumn = new TableColumn<>("Department");
        deptColumn.setCellValueFactory(new PropertyValueFactory<>("DeptName"));
        TableColumn<Employee, String> hireColumn = new TableColumn<>("HireDate");
        hireColumn.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
        viewsTBL.getColumns().addAll(nameColumn, deptColumn, hireColumn);
    }


    @FXML
    void addEmpHandler(Event event) {

    }

    @FXML
    void viewAllHandler(Event event) {
        viewsTBL.getItems().clear();
        viewsTBL.getColumns().clear();
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn<Employee, Integer> deptColumn = new TableColumn<>("Department");
        deptColumn.setCellValueFactory(new PropertyValueFactory<>("DeptName"));
        TableColumn<Employee, String> hireColumn = new TableColumn<>("HireDate");
        hireColumn.setCellValueFactory(new PropertyValueFactory<>("HireDate"));
        viewsTBL.getColumns().addAll(nameColumn, deptColumn, hireColumn);
        ArrayList<Employee> empsList = Fetcher.getAllEmployees();
        for (Employee emp : empsList) {
            viewsTBL.getItems().add(emp);
        }
    }

    @FXML
    @SuppressWarnings("unchecked")
    void viewProjectsHandler(Event event) {
        viewsTBL.getItems().clear();
        viewsTBL.getColumns().clear();
        TableColumn<Project, String> pNameColumn = new TableColumn<>("Project_Name");
        pNameColumn.setCellValueFactory(new PropertyValueFactory<>("PName"));
        TableColumn<Project, String> descColumn = new TableColumn<>("Project_Description");
        descColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        TableColumn<Project, String> dName = new TableColumn<>("Dept_Name");
        dName.setCellValueFactory(new PropertyValueFactory<>("DName"));
        viewsTBL.getColumns().addAll(pNameColumn, descColumn, dName);
        ArrayList<Project> prjList = Fetcher.getAllProjects();
        for (Project prj : prjList) {
            viewsTBL.getItems().add(prj);
        }
    }

    @FXML
    void viewVehiclesHandler(Event event) {
        viewsTBL.getItems().clear();
        viewsTBL.getColumns().clear();
        TableColumn<Vehicle, String> eName = new TableColumn<>("Owner");
        eName.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        TableColumn<Vehicle, String> vModel = new TableColumn<>("Model");
        vModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        TableColumn<Vehicle, String> nextMaint = new TableColumn<>("Next Maintenance");
        nextMaint.setCellValueFactory(new PropertyValueFactory<>("NextMaint"));
        viewsTBL.getColumns().addAll(eName, vModel, nextMaint);
        ArrayList<Vehicle> vehicleList = Fetcher.getAllVehicles();
        for (Vehicle veh : vehicleList) {
            viewsTBL.getItems().add(veh);
        }
    }

    @FXML
    void searchHandler(Event event) {
        String empID = empIdTXT.getText();
        if (!empID.equals("")) {
            String[] empInfo = Fetcher.searchEmployee(empID);
            empNameLBL.setText(empInfo[0]);
            phoneLBL.setText(empInfo[1]);
            dobLBL.setText(empInfo[2]);
            hireLBL.setText(empInfo[3]);
            salLBL.setText(empInfo[4]);
            comLBL.setText(empInfo[5]);
            deptLBL.setText(empInfo[6]);
            positionLBL.setText(empInfo[7]);
        }

    }


    @FXML
    void handleDelete(Event event) {
        String empID = empIDTXT.getText();
        String result = Fetcher.removeEmployee(Integer.parseInt(empID));
        if (result.equals("Success")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Successfully Deleted the Employee");
            alert.showAndWait();
            empIDTXT.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You Entered Smth Wrong");
            alert.showAndWait();
        }
    }

    @FXML
    void handleAdd(Event event) {
        String name = eNameTXT.getText();
        String phone = ePhoneTXT.getText();
        String hire = hireTXT.getText();
        String dob = dobTXT.getText();
        String gender = genderTXT.getText();
        String salary = salaryTXT.getText();
        String commission = commissionTXT.getText();
        String dept = deptTXT.getText();
        String position = positionTXT.getText();
        String result = Fetcher.addEmployee(name, Integer.parseInt(phone), hire, dob, gender, Integer.parseInt(salary), Double.parseDouble(commission), dept, position);
        if (result.equals("Success")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Successfully Added the Employee");
            alert.showAndWait();
            eNameTXT.setText("");
            ePhoneTXT.setText("");
            hireTXT.setText("");
            dobTXT.setText("");
            genderTXT.setText("");
            salaryTXT.setText("");
            commissionTXT.setText("");
            deptTXT.setText("");
            positionTXT.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You Entered Smth Wrong");
            alert.showAndWait();
        }
    }

    @FXML
    void handleUpdate(Event event) {
        String empID = employeeIDTXT.getText();
        String newSalary = newSalaryTXT.getText();
        String result = Fetcher.updateEmployee(empID, Integer.parseInt(newSalary));
        if (result.equals("Success")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Successfully Updated Salary the Employee");
            alert.showAndWait();
            employeeIDTXT.setText("");
            newSalaryTXT.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You Entered Smth Wrong");
            alert.showAndWait();
        }
    }

    @FXML
    void handleCommit(Event event) {
        Fetcher.commitAll();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Successfully Committed Changes");
        alert.showAndWait();
    }


}
