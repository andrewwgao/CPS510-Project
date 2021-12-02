package controller;
import db.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class PaymentsController {
    @FXML
    private Label paymentsErrorText;
    @FXML
    private Label paymentsQueryText;

    @FXML
    private TableView paymentsTable;
    @FXML
    private TableColumn<Payments, Integer> bookingID;
    @FXML
    private TableColumn<Payments, Integer> paymentID;
    @FXML
    private TableColumn<Payments, String> discountCode;
    @FXML
    private TableColumn<Payments, String> total;

    @FXML
    private void searchPayments(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Payments> paymentsData = PaymentsDB.searchPayments();
            populatePayments(paymentsData);
            paymentsErrorText.setTextFill(Color.web("#00A36C"));
            paymentsErrorText.setText("Query results");
            paymentsQueryText.setText("List of payments with discount code of 'NONE'");

        } catch (SQLException e){
            paymentsErrorText.setTextFill(Color.web("#dd0000"));
            paymentsErrorText.setText("Error: Make sure data is inserted into tables first");
            throw e;
        }
    }

    @FXML
    private void viewPayments(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Payments> paymentsData = PaymentsDB.viewPayments();
            populatePayments(paymentsData);
            paymentsQueryText.setText("");
        } catch (SQLException e){
            paymentsErrorText.setTextFill(Color.web("#dd0000"));
            paymentsErrorText.setText("Error: No data in table");
            throw e;
        }
    }

    @FXML
    private void insertPayments(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            PaymentsDB.insertPayments();
            paymentsErrorText.setTextFill(Color.web("#00A36C"));
            paymentsErrorText.setText("Data inserted");
            paymentsQueryText.setText("");
            ObservableList<Payments> paymentsData = PaymentsDB.viewPayments();
            populatePayments(paymentsData);
        } catch (SQLException e){
            paymentsErrorText.setTextFill(Color.web("#dd0000"));
            paymentsErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void deletePayments(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.deleteTables();
            paymentsErrorText.setTextFill(Color.web("#00A36C"));
            paymentsErrorText.setText("Tables dropped");
            paymentsQueryText.setText("");
            paymentsTable.getItems().clear();
        } catch (SQLException e){
            paymentsErrorText.setTextFill(Color.web("#dd0000"));
            paymentsErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void createTable(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.createTable();
            paymentsErrorText.setTextFill(Color.web("#00A36C"));
            paymentsErrorText.setText("Tables created");
            paymentsQueryText.setText("");
        } catch (SQLException e){
            paymentsErrorText.setTextFill(Color.web("#dd0000"));
            paymentsErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void initialize() throws ClassNotFoundException {
        bookingID.setCellValueFactory(cellData -> cellData.getValue().bookingIDProperty().asObject());
        paymentID.setCellValueFactory(cellData -> cellData.getValue().paymentIDProperty().asObject());
        discountCode.setCellValueFactory(cellData -> cellData.getValue().discountCodeProperty());
        total.setCellValueFactory(cellData -> cellData.getValue().totalProperty());
        try {
            ObservableList<Payments> paymentsData = PaymentsDB.viewPayments();
            populatePayments(paymentsData);
        } catch (SQLException e){}
    }

    @FXML
    private void populatePayments (ObservableList<Payments> paymentsData) throws ClassNotFoundException {
        paymentsTable.setItems(paymentsData);
    }
}
