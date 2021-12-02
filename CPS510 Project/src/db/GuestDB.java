package db;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDB {
    public static ObservableList<Guest> searchGuests() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT room_id, COUNT(DISTINCT guest_id) AS Guest_Count_per_Room\n" +
                "    FROM hotel_bookings\n" +
                "    GROUP BY room_id";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Guest> guestList = getGuestList(rsSet);
            return guestList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // get guest data
    public static ObservableList<Guest> getGuestList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Guest> guestList = FXCollections.observableArrayList();

        while (rs.next()){
            Guest guest = new Guest();
            guest.setGuestID(rs.getInt("GUEST_ID"));
            guest.setfName(rs.getString("F_NAME"));
            guest.setlName(rs.getString("L_NAME"));
            guest.setStayCount(rs.getInt("STAY_COUNT"));
            guest.setBillAddress(rs.getString("BILL_ADDRESS"));
//            guest.setCreditCard(rs.getString("CREDIT_CARD"));
//            guest.setCreditCardNum(rs.getString("CREDIT_NUMBER"));
//            guest.setCity(rs.getString("CITY"));
//            guest.setProvince(rs.getString("PROVINCE"));
//            guest.setPostalCode(rs.getString("POSTAL_CODE"));
//            guest.setCountry(rs.getString("COUNTRY"));

            guestList.add(guest);
        }
        return guestList;
    }

    // show all guests in table
    public static ObservableList<Guest> viewGuests() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM HOTEL_GUESTS";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Guest> guestList = getGuestList(rsSet);
            return guestList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // insert data into table
    public static void insertGuests() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "INSERT INTO hotel_guests(guest_id, f_name, l_name, stay_count, bill_address)VALUES(05843, 'Dion', 'Moody', 1, '2 Seattle Slew Drive')";
        String selectStmt2 = "INSERT INTO hotel_guests(guest_id, f_name, l_name, stay_count, bill_address)VALUES(14567, 'Carolina', 'Zhang', 4, '3 Citation Road')";
        String selectStmt3 = "INSERT INTO hotel_guests(guest_id, f_name, l_name, stay_count, bill_address)VALUES(05467, 'Ebrahim', 'Story', 6, '4 Seabiscuit Parkway')";
        String selectStmt4 = "INSERT INTO hotel_guests(guest_id, f_name, l_name, stay_count, bill_address)VALUES(25876, 'Christiana', 'Rice', 5, '5 Kelso Avenue')";
        String selectStmt5 = "INSERT INTO hotel_guests(guest_id, f_name, l_name, stay_count, bill_address)VALUES(02789, 'Timur', 'Burke', 21, '6 Northern Dancer Crescent')";

        String selectStmt6 = "INSERT INTO hotel_guests_credit(credit_number, credit_card)VALUES('*9874', 'Mastercard')";
        String selectStmt7 = "INSERT INTO hotel_guests_credit(credit_number, credit_card)VALUES('*4563', 'VISA')";
        String selectStmt8 = "INSERT INTO hotel_guests_credit(credit_number, credit_card)VALUES('*7418', 'AMEX')";
        String selectStmt9 = "INSERT INTO hotel_guests_credit(credit_number, credit_card)VALUES('*5963', 'AMEX')";
        String selectStmt10 = "INSERT INTO hotel_guests_credit(credit_number, credit_card)VALUES('*1234', 'VISA')";

        String selectStmt11 = "INSERT INTO hotel_guests_zip(postal_code, city, province, country)VALUES('20876','Germantown','MD','United States')";
        String selectStmt12 = "INSERT INTO hotel_guests_zip(postal_code, city, province, country)VALUES('E1W 1BA','Southwark','London','United Kingdom')";
        String selectStmt13 = "INSERT INTO hotel_guests_zip(postal_code, city, province, country)VALUES('T4E 1L9','Calgary','Alberta','United States')";
        String selectStmt14 = "INSERT INTO hotel_guests_zip(postal_code, city, province, country)VALUES('W3P 7Y6','Whitehorse','YT','Canada')";
        String selectStmt15 = "INSERT INTO hotel_guests_zip(postal_code, city, province, country)VALUES('0695471','Singapore','','Canada')";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt2);
            DBUtil.dbExecuteUpdate(selectStmt3);
            DBUtil.dbExecuteUpdate(selectStmt4);
            DBUtil.dbExecuteUpdate(selectStmt5);
//            DBUtil.dbExecuteUpdate(selectStmt6);
//            DBUtil.dbExecuteUpdate(selectStmt7);
//            DBUtil.dbExecuteUpdate(selectStmt8);
//            DBUtil.dbExecuteUpdate(selectStmt9);
//            DBUtil.dbExecuteUpdate(selectStmt10);
//            DBUtil.dbExecuteUpdate(selectStmt11);
//            DBUtil.dbExecuteUpdate(selectStmt12);
//            DBUtil.dbExecuteUpdate(selectStmt13);
//            DBUtil.dbExecuteUpdate(selectStmt14);
//            DBUtil.dbExecuteUpdate(selectStmt15);

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}
