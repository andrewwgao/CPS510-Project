package db;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDB {
    public static ObservableList<Room> searchRooms() throws SQLException, ClassNotFoundException {
        String selectStmt = "(SELECT *\n" +
                "    FROM hotel_rooms)\n" +
                "    MINUS\n" +
                "    (SELECT r.*\n" +
                "    FROM hotel_rooms r, hotel_bookings b\n" +
                "    WHERE r.room_id = b.room_id\n" +
                "        AND room_view = 'north')";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Room> roomList = getRoomList(rsSet);
            return roomList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // get room data
    public static ObservableList<Room> getRoomList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Room> roomList = FXCollections.observableArrayList();

        while (rs.next()){
            Room room = new Room();
            room.setRoomID(rs.getInt("ROOM_ID"));
            room.setRoomFloor(rs.getInt("FLOOR"));
            room.setRoomNum(rs.getInt("ROOM_NUMBER"));
            room.setRoomSize(rs.getString("ROOM_SIZE"));
            room.setRoomView(rs.getString("ROOM_VIEW"));
            room.setRoomCheckedBy(rs.getString("CHECKED_BY"));

            roomList.add(room);
        }
        return roomList;
    }

    // show all rooms in table
    public static ObservableList<Room> viewRooms() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM HOTEL_ROOMS";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Room> roomList = getRoomList(rsSet);
            return roomList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // insert data into table
    public static void insertRoom() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "INSERT INTO hotel_rooms(checked_by , floor , room_id , room_number , room_size , room_view )VALUES(19945, 2, 2002, 02, 'twin', 'north')";
        String selectStmt3 = "INSERT INTO hotel_rooms(checked_by , floor , room_id , room_number , room_size , room_view )VALUES(19945, 5, 5012, 12, 'double', 'east')";
        String selectStmt4 = "INSERT INTO hotel_rooms(checked_by , floor , room_id , room_number , room_size , room_view )VALUES(20943, 6, 6007, 07, 'twodoubles', 'south')";
        String selectStmt5 = "INSERT INTO hotel_rooms(checked_by , floor , room_id , room_number , room_size , room_view )VALUES(19945, 9, 9001, 09, 'twodoubles', 'north')";
        String selectStmt6 = "INSERT INTO hotel_rooms(checked_by , floor , room_id , room_number , room_size , room_view )VALUES(20943, 12, 12004, 12, 'king', 'east')";
        String selectStmt7 = "INSERT INTO hotel_rooms(checked_by , floor , room_id , room_number , room_size , room_view )VALUES(19945, 10, 10010, 10, 'king', 'west')";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt3);
            DBUtil.dbExecuteUpdate(selectStmt4);
            DBUtil.dbExecuteUpdate(selectStmt5);
            DBUtil.dbExecuteUpdate(selectStmt6);
            DBUtil.dbExecuteUpdate(selectStmt7);

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}
