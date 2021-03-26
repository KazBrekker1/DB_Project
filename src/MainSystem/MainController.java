package MainSystem;

import BackEnd.Employee;
import BackEnd.Fetcher;
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
    private Tab removeEmpTAB;

    @FXML
    private Tab updateSalaryTAB;

    @FXML
    private Tab searchEmpTAB;

    @FXML
    private Tab viewReportsTAB;

    @FXML
    private TableView<Employee> viewsTBL;

    @FXML
    @SuppressWarnings("unchecked")
    public void initialize() {
//        Populate Table Column Names
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn<Employee, Integer> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        TableColumn<Employee, String> dobColumn = new TableColumn<>("DOB");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        viewsTBL.getColumns().addAll(nameColumn, phoneColumn, dobColumn);
    }

    @FXML
    private Button viewAllBTN;

    @FXML
    void addEmpHandler(Event event) {

    }

    @FXML
    void viewAllHandler(Event event) {
        viewsTBL.getItems().clear();
        ArrayList<Employee> empsList = Fetcher.getAllEmployees();
        for (Employee emp : empsList) {
            viewsTBL.getItems().add(emp);
        }
    }

}
