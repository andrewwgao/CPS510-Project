package controller;
import db.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import java.sql.SQLException;

public class RoomsController {
    @FXML
    private Label roomErrorText;
    @FXML
    private Label roomQueryText;

    @FXML
    private TableView availableRoomsTable;
    @FXML
    private TableColumn<Room, Integer> roomID;
    @FXML
    private TableColumn<Room, Integer> roomFloor;
    @FXML
    private TableColumn<Room, Integer> roomNum;
    @FXML
    private TableColumn<Room, String> roomView;
    @FXML
    private TableColumn<Room, String> roomSize;
    @FXML
    private TableColumn<Room, String> roomCheckedBy;

    @FXML
    private void searchRooms(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Room> roomData = RoomDB.searchRooms();
            populateRooms(roomData);
            roomErrorText.setTextFill(Color.web("#00A36C"));
            roomErrorText.setText("Query results");
            roomQueryText.setText("List of rooms that are not booked and face north");

        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("Error: Make sure data is inserted into tables first");
            throw e;
        }
    }

    @FXML
    private void viewRooms(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ObservableList<Room> roomData = RoomDB.viewRooms();
            populateRooms(roomData);
            roomQueryText.setText("");
        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("Error: No data in table");
            throw e;
        }
    }

    @FXML
    private void insertRoom(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            RoomDB.insertRoom();
            roomErrorText.setTextFill(Color.web("#00A36C"));
            roomErrorText.setText("Data inserted");
            roomQueryText.setText("");
            ObservableList<Room> roomData = RoomDB.viewRooms();
            populateRooms(roomData);
        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void deleteRoom(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.deleteTables();
            roomErrorText.setTextFill(Color.web("#00A36C"));
            roomErrorText.setText("Tables dropped");
            roomQueryText.setText("");
            availableRoomsTable.getItems().clear();
        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void createTable(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            BookingsDB.createTable();
            roomErrorText.setTextFill(Color.web("#00A36C"));
            roomErrorText.setText("Tables created");
            roomQueryText.setText("");
        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("Error: " + e);
            throw e;
        }
    }

    @FXML
    private void initialize() throws ClassNotFoundException {
        roomID.setCellValueFactory(cellData -> cellData.getValue().roomIDProperty().asObject());
        roomFloor.setCellValueFactory(cellData -> cellData.getValue().roomFloorProperty().asObject());
        roomNum.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty().asObject());
        roomView.setCellValueFactory(cellData -> cellData.getValue().roomViewProperty());
        roomSize.setCellValueFactory(cellData -> cellData.getValue().roomSizeProperty());
        roomCheckedBy.setCellValueFactory(cellData -> cellData.getValue().roomCheckedByProperty());
        try {
            ObservableList<Room> roomData = RoomDB.viewRooms();
            populateRooms(roomData);
        } catch (SQLException e){}
    }

    @FXML
    private void populateRooms (ObservableList<Room> roomData) throws ClassNotFoundException {
        availableRoomsTable.setItems(roomData);
    }
}
