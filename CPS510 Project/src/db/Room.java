package db;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {
    private IntegerProperty roomID;
    private IntegerProperty roomFloor;
    private IntegerProperty roomNum;
    private StringProperty roomView;
    private StringProperty roomSize;
    private StringProperty roomCheckedBy;

    public Room() {
        this.roomID = new SimpleIntegerProperty();
        this.roomFloor = new SimpleIntegerProperty();
        this.roomNum = new SimpleIntegerProperty();
        this.roomView = new SimpleStringProperty();
        this.roomSize = new SimpleStringProperty();
        this.roomCheckedBy = new SimpleStringProperty();
    }

    public int getRoomID() {
        return roomID.get();
    }
    public void setRoomID(int roomID){
        this.roomID.set(roomID);
    }
    public IntegerProperty roomIDProperty(){
        return roomID;
    }

    public int getRoomFloor() {
        return roomFloor.get();
    }
    public void setRoomFloor(int roomFloor){
        this.roomFloor.set(roomFloor);
    }
    public IntegerProperty roomFloorProperty(){
        return roomFloor;
    }

    public int getRoomNum() {
        return roomNum.get();
    }
    public void setRoomNum(int roomNum){
        this.roomNum.set(roomNum);
    }
    public IntegerProperty roomNumProperty(){
        return roomNum;
    }

    public String getRoomView() {
        return roomView.get();
    }
    public void setRoomView(String roomView){
        this.roomView.set(roomView);
    }
    public StringProperty roomViewProperty(){
        return roomView;
    }

    public String getRoomSize() {
        return roomSize.get();
    }
    public void setRoomSize(String roomSize){
        this.roomSize.set(roomSize);
    }
    public StringProperty roomSizeProperty(){
        return roomSize;
    }

    public String getRoomCheckedBy() {
        return roomCheckedBy.get();
    }
    public void setRoomCheckedBy(String roomCheckedBy){
        this.roomCheckedBy.set(roomCheckedBy);
    }
    public StringProperty roomCheckedByProperty(){
        return roomCheckedBy;
    }
}