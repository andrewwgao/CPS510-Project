package controller;
import db.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import java.sql.SQLException;

public class GuestsController {
    @FXML
    private Label guestErrorText;
    @FXML
    private Label guestQueryText;

    @FXML
    private TableView guestsTable;
    @FXML
    private TableView guestsTable2;
    @FXML
    private TableView guestsTable3;
    @FXML
    private TableColumn<Guest, Integer> guestID;
    @FXML
    private TableColumn<Guest, String> Fname;
    @FXML
    private TableColumn<Guest, String> Lname;
    @FXML
    private TableColumn<Guest, Integer> stayCount;
    @FXML
    private TableColumn<Guest, String> billAddress;
    @FXML
    private TableColumn<Credit, String> creditCard;
    @FXML
    private TableColumn<Credit, String> creditCardNum;
    @FXML
    private TableColumn<Zip, String> postalCode;
    @FXML
    private TableColumn<Zip, String> city;
    @FXML
    private TableColumn<Zip, String> province;
    @FXML
    private TableColumn<Zip, String> country;

    @FXML
    private void searchGuests(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Guest> guestData = GuestDB.searchGuests();
            populateGuests(guestData);
            guestErrorText.setTextFill(Color.web("#00A36C"));
            guestErrorText.setText("Query results");
            guestQueryText.setText("List for each room, the number of guests registered for the room with no duplicates");

        } catch (SQLException e){
            guestErrorText.setTextFill(Color.web("#dd0000"));
            guestErrorText.setText("Error: Make sure data is inserted into tables first");
            throw e;
        }
    }

    @FXML
    private void viewGuests(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Guest> guestData = GuestDB.viewGuests();
            populateGuests(guestData);
            guestQueryText.setText("");
        } catch (SQLException e){
            guestErrorText.setTextFill(Color.web("#dd0000"));
            guestErrorText.setText("Error: No data in table");
            throw e;
        }
    }

    @FXML
    private void insertGuests(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            GuestDB.insertGuests();
            guestErrorText.setTextFill(Color.web("#00A36C"));
            guestErrorText.setText("Data inserted");
            guestQueryText.setText("");
            ObservableList<Guest> guestData = GuestDB.viewGuests();
            populateGuests(guestData);
        } catch (SQLException e){
            guestErrorText.setTextFill(Color.web("#dd0000"));
            guestErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void deleteGuests(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.deleteTables();
            guestErrorText.setTextFill(Color.web("#00A36C"));
            guestErrorText.setText("Tables dropped");
            guestQueryText.setText("");
            guestsTable.getItems().clear();
            guestsTable2.getItems().clear();
            guestsTable3.getItems().clear();
        } catch (SQLException e){
            guestErrorText.setTextFill(Color.web("#dd0000"));
            guestErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void createTable(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.createTable();
            guestErrorText.setTextFill(Color.web("#00A36C"));
            guestErrorText.setText("Tables created");
            guestQueryText.setText("");
        } catch (SQLException e){
            guestErrorText.setTextFill(Color.web("#dd0000"));
            guestErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void initialize() throws ClassNotFoundException {

        guestID.setCellValueFactory(cellData -> cellData.getValue().guestIDProperty().asObject());
        Fname.setCellValueFactory(cellData -> cellData.getValue().fNameProperty());
        Lname.setCellValueFactory(cellData -> cellData.getValue().lNameProperty());
        stayCount.setCellValueFactory(cellData -> cellData.getValue().stayCountProperty().asObject());
        billAddress.setCellValueFactory(cellData -> cellData.getValue().billAddressProperty());
        creditCard.setCellValueFactory(cellData -> cellData.getValue().creditCardProperty());
        creditCardNum.setCellValueFactory(cellData -> cellData.getValue().creditCardNumProperty());
        postalCode.setCellValueFactory(cellData -> cellData.getValue().postalCodeProperty());
        city.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        province.setCellValueFactory(cellData -> cellData.getValue().provinceProperty());
        country.setCellValueFactory(cellData -> cellData.getValue().countryProperty());

        try {
            ObservableList<Guest> guestData = GuestDB.viewGuests();
            populateGuests(guestData);
        } catch (SQLException e){}
    }


    @FXML
    private void populateGuests (ObservableList<Guest> guestData) throws ClassNotFoundException {
        guestsTable.setItems(guestData);
        guestsTable2.setItems(guestData);
        guestsTable3.setItems(guestData);
    }
}
