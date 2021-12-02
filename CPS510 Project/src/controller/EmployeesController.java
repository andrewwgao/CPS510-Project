package controller;
import db.BookingsDB;
import db.Employee;
import db.EmployeeDB;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.SQLException;
import java.sql.Date;

public class EmployeesController {
    @FXML
    private Label empErrorText;
    @FXML
    private Label empQueryText;

    @FXML
    private TableView EmpTable;
    @FXML
    private TableColumn<Employee, Integer> empID;
    @FXML
    private TableColumn<Employee, String> Fname;
    @FXML
    private TableColumn<Employee, String> Lname;
    @FXML
    private TableColumn<Employee, Integer> phone;
    @FXML
    private TableColumn<Employee, String> email;
    @FXML
    private TableColumn<Employee, Date> dob;
    @FXML
    private TableColumn<Employee, String> pos;
    @FXML
    private TableColumn<Employee, String> status;
    @FXML
    private TableColumn<Employee, Integer> salary;

    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Employee> empData = EmployeeDB.searchEmployees();
            populateEmployees(empData);
            empErrorText.setTextFill(Color.web("#00A36C"));
            empErrorText.setText("Query results");
            empQueryText.setText("List of Cleaning Staff who have not checked any room");

        } catch (SQLException e){
            empErrorText.setTextFill(Color.web("#dd0000"));
            empErrorText.setText("Error: Make sure data is inserted into tables first");
            throw e;
        }
    }

    @FXML
    private void viewEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Employee> empData = EmployeeDB.viewEmployees();
            populateEmployees(empData);
            empQueryText.setText("");
        } catch (SQLException e){
            empErrorText.setTextFill(Color.web("#dd0000"));
            empErrorText.setText("Error: No data in table");
            throw e;
        }
    }

    @FXML
    private void insertEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDB.insertEmployees();
            empErrorText.setTextFill(Color.web("#00A36C"));
            empErrorText.setText("Data inserted");
            empQueryText.setText("");
            ObservableList<Employee> empData = EmployeeDB.viewEmployees();
            populateEmployees(empData);
        } catch (SQLException e){
            empErrorText.setTextFill(Color.web("#dd0000"));
            empErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void deleteEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.deleteTables();
            empErrorText.setTextFill(Color.web("#00A36C"));
            empErrorText.setText("Tables dropped");
            empQueryText.setText("");
            EmpTable.getItems().clear();
        } catch (SQLException e){
            empErrorText.setTextFill(Color.web("#dd0000"));
            empErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void createTable(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.createTable();
            empErrorText.setTextFill(Color.web("#00A36C"));
            empErrorText.setText("Tables created");
            empQueryText.setText("");
        } catch (SQLException e){
            empErrorText.setTextFill(Color.web("#dd0000"));
            empErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void initialize() throws ClassNotFoundException {
        empID.setCellValueFactory(cellData -> cellData.getValue().empIDProperty().asObject());
        Fname.setCellValueFactory(cellData -> cellData.getValue().fNameProperty());
        Lname.setCellValueFactory(cellData -> cellData.getValue().lNameProperty());
        phone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty().asObject());
        email.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        dob.setCellValueFactory(cellData -> cellData.getValue().dobProperty());
        pos.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        salary.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());
        try {
            ObservableList<Employee> empData = EmployeeDB.viewEmployees();
            populateEmployees(empData);
        } catch (SQLException e){}
    }

    @FXML
    private void populateEmployees (ObservableList<Employee> empData) throws ClassNotFoundException {
        EmpTable.setItems(empData);
    }
}
