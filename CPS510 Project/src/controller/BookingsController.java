package controller;
import db.Bookings;
import db.BookingsDB;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.SQLException;
import java.sql.Date;

public class BookingsController {
    @FXML
    private Label bookingsErrorText;
    @FXML
    private Label bookingsQueryText;

    @FXML
    private TableView bookingsTable;
    @FXML
    private TableColumn<Bookings, Integer> bookingID;
    @FXML
    private TableColumn<Bookings, Integer> guestID;
    @FXML
    private TableColumn<Bookings, Integer> roomID;
    @FXML
    private TableColumn<Bookings, String> payRec;
    @FXML
    private TableColumn<Bookings, String> bookedBy;
    @FXML
    private TableColumn<Bookings, Date> dateFrom;
    @FXML
    private TableColumn<Bookings, Date> dateTo;

    @FXML
    private void searchBookings(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Bookings> bookingsData = BookingsDB.searchBookings();
            populateBookings(bookingsData);
            bookingsErrorText.setTextFill(Color.web("#00A36C"));
            bookingsErrorText.setText("Query results");
            bookingsQueryText.setText("List of bookings with 'YES' as Pay Record");

        } catch (SQLException e){
            bookingsErrorText.setTextFill(Color.web("#dd0000"));
            bookingsErrorText.setText("Error: Make sure data is inserted into tables first");
            throw e;
        }
    }

    @FXML
    private void viewBookings(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Bookings> bookingsData = BookingsDB.viewBookings();
            populateBookings(bookingsData);
            bookingsQueryText.setText("");
        } catch (SQLException e){
            bookingsErrorText.setTextFill(Color.web("#dd0000"));
            bookingsErrorText.setText("Error: No data in table");
            throw e;
        }
    }

    @FXML
    private void insertBookings(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.insertBookings();
            bookingsErrorText.setTextFill(Color.web("#00A36C"));
            bookingsErrorText.setText("Data inserted");
            bookingsQueryText.setText("");
            ObservableList<Bookings> bookingsData = BookingsDB.viewBookings();
            populateBookings(bookingsData);
        } catch (SQLException e){
            bookingsErrorText.setTextFill(Color.web("#dd0000"));
            bookingsErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void deleteBookings(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.deleteTables();
            bookingsErrorText.setTextFill(Color.web("#00A36C"));
            bookingsErrorText.setText("Tables dropped");
            bookingsQueryText.setText("");
            bookingsTable.getItems().clear();
        } catch (SQLException e){
            bookingsErrorText.setTextFill(Color.web("#dd0000"));
            bookingsErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void createTable(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.createTable();
            bookingsErrorText.setTextFill(Color.web("#00A36C"));
            bookingsErrorText.setText("Tables created");
            bookingsQueryText.setText("");
        } catch (SQLException e){
            bookingsErrorText.setTextFill(Color.web("#dd0000"));
            bookingsErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void initialize() throws ClassNotFoundException {
        bookingID.setCellValueFactory(cellData -> cellData.getValue().bookingIDProperty().asObject());
        guestID.setCellValueFactory(cellData -> cellData.getValue().bookingIDProperty().asObject());
        roomID.setCellValueFactory(cellData -> cellData.getValue().bookingIDProperty().asObject());
        payRec.setCellValueFactory(cellData -> cellData.getValue().payRecProperty());
        bookedBy.setCellValueFactory(cellData -> cellData.getValue().bookedByProperty());
        dateFrom.setCellValueFactory(cellData -> cellData.getValue().dateFromProperty());
        dateTo.setCellValueFactory(cellData -> cellData.getValue().dateToProperty());
        try {
            ObservableList<Bookings> bookingsData = BookingsDB.viewBookings();
            populateBookings(bookingsData);
        } catch (SQLException e){}
    }

    @FXML
    private void populateBookings (ObservableList<Bookings> bookingsData) throws ClassNotFoundException {
        bookingsTable.setItems(bookingsData);
    }
}
