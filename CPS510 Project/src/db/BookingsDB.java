package db;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingsDB {
    public static ObservableList<Bookings> searchBookings() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT booking_id, guest_id, room_id, pay_rec, date_from, date_to, booked_by\n" +
                "    FROM hotel_bookings\n" +
                "    WHERE pay_rec = 'YES'\n" +
                "    ORDER BY booking_id";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Bookings> bookingsList = getBookingsList(rsSet);
            return bookingsList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // get bookings data
    public static ObservableList<Bookings> getBookingsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Bookings> bookingList = FXCollections.observableArrayList();

        while (rs.next()){
            Bookings booking = new Bookings();
            booking.setBookingID(rs.getInt("BOOKING_ID"));
            booking.setGuestID(rs.getInt("GUEST_ID"));
            booking.setRoomID(rs.getInt("ROOM_ID"));
            booking.setPayRec(rs.getString("PAY_REC"));
            booking.setBookedBy(rs.getString("BOOKED_BY"));
            booking.setDateFrom(rs.getDate("DATE_FROM"));
            booking.setDateTo(rs.getDate("DATE_TO"));

            bookingList.add(booking);
        }
        return bookingList;
    }

    // show all bookings in table
    public static ObservableList<Bookings> viewBookings() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM hotel_bookings";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Bookings> bookingList = getBookingsList(rsSet);
            return bookingList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // create tables
    public static void createTable() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "CREATE TABLE hotel_employee (\n" +
                "emp_id INTEGER PRIMARY KEY,\n" +
                "emp_f_name VARCHAR2( 30 ) NOT NULL,\n" +
                "emp_l_name VARCHAR2( 30 ) NOT NULL,\n" +
                "phone INTEGER NOT NULL CHECK(phone between 0 and 99999999999),\n" +
                "email VARCHAR2( 50 ),\n" +
                "dob DATE NOT NULL,\n" +
                "position_title VARCHAR2( 20 ),\n" +
                "status VARCHAR2( 20 ),\n" +
                "salary INTEGER NOT NULL)";

        String selectStmt2 = "CREATE TABLE hotel_guests (\n" +
                "guest_id INTEGER PRIMARY KEY,\n" +
                "f_name VARCHAR2( 30 ) NOT NULL,\n" +
                "l_name VARCHAR2( 30 ) NOT NULL,\n" +
                "stay_count INTEGER,\n" +
                "bill_address VARCHAR( 70 ))";

        String selectStmt2_2 = "CREATE TABLE hotel_guests_credit\n" +
                "(credit_number VARCHAR2(20) PRIMARY KEY,\n" +
                "credit_card VARCHAR2(10))";

        String selectStmt2_3 = "CREATE TABLE hotel_guests_zip (\n" +
                "city VARCHAR2( 20 ),\n" +
                "province VARCHAR2( 20 ),\n" +
                "postal_code VARCHAR2( 20 ) PRIMARY KEY,\n" +
                "country VARCHAR2( 20 ))";

        String selectStmt3 = "CREATE TABLE hotel_rooms (\n" +
                "room_id INTEGER PRIMARY KEY,\n" +
                "floor INTEGER,\n" +
                "room_number INTEGER,\n" +
                "room_view VARCHAR2( 20 )\n" +
                "CONSTRAINT chk_room_view CHECK(room_view IN ('north', 'south', 'east', 'west')),\n" +
                "room_size VARCHAR2( 20 )\n" +
                "CONSTRAINT chk_room_size CHECK(room_size IN ('twin', 'double', 'twodoubles', 'king')))";

        String selectStmt4 = "CREATE TABLE hotel_bookings (\n" +
                "booking_id INTEGER PRIMARY KEY,\n" +
                "guest_id INTEGER REFERENCES hotel_guests(guest_id),\n" +
                "room_id INTEGER REFERENCES hotel_rooms(room_id),\n" +
                "pay_rec VARCHAR2( 10 ) DEFAULT 'no',\n" +
                "date_from DATE,\n" +
                "date_to DATE,\n" +
                "constraint check_dates check (date_to > date_from))";

        String selectStmt5 = "CREATE TABLE hotel_payments (\n" +
                "payment_id INTEGER PRIMARY KEY,\n" +
                "booking_id INTEGER REFERENCES hotel_bookings(booking_id),\n" +
                "discount_code VARCHAR2( 10 ),\n" +
                "total VARCHAR2(6) NOT NULL)";

        String altStmt1 = "ALTER TABLE hotel_bookings\n" +
                "ADD (\n" +
                "booked_by INTEGER)";

        String altStmt2 = "ALTER TABLE hotel_bookings\n" +
                "ADD FOREIGN KEY (booked_by) REFERENCES hotel_employee(emp_id)";

        String altStmt3 = "ALTER TABLE hotel_rooms\n" +
                "ADD (\n" +
                "checked_by INTEGER)";

        String altStmt4 = "ALTER TABLE hotel_rooms\n" +
                "ADD FOREIGN KEY (checked_by) REFERENCES hotel_employee(emp_id)";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt2);
            DBUtil.dbExecuteUpdate(selectStmt2_2);
            DBUtil.dbExecuteUpdate(selectStmt2_3);
            DBUtil.dbExecuteUpdate(selectStmt3);
            DBUtil.dbExecuteUpdate(selectStmt4);
            DBUtil.dbExecuteUpdate(selectStmt5);
            DBUtil.dbExecuteUpdate(altStmt1);
            DBUtil.dbExecuteUpdate(altStmt2);
            DBUtil.dbExecuteUpdate(altStmt3);
            DBUtil.dbExecuteUpdate(altStmt4);

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // delete tables from database
    public static void deleteTables() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "DROP TABLE hotel_payments CASCADE CONSTRAINTS";
        String selectStmt2 = "DROP TABLE hotel_bookings CASCADE CONSTRAINTS";
        String selectStmt3 = "DROP TABLE hotel_rooms CASCADE CONSTRAINTS";
        String selectStmt4 = "DROP TABLE hotel_guests CASCADE CONSTRAINTS";
        String selectStmt5 = "DROP TABLE hotel_employee CASCADE CONSTRAINTS";
        String selectStmt6 = "DROP TABLE hotel_guests_credit CASCADE CONSTRAINTS";
        String selectStmt7 = "DROP TABLE hotel_guests_zip CASCADE CONSTRAINTS";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt2);
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

    // insert data into table
    public static void insertBookings() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "INSERT INTO hotel_bookings(booked_by , booking_id , date_from , date_to , guest_id , room_id)VALUES(11587, 987654, TO_DATE('20/11/2021', 'DD/MM/YYYY'), TO_DATE('30/11/2021', 'DD/MM/YYYY'), 02789, 12004)";
        String selectStmt2 = "INSERT INTO hotel_bookings(booked_by , booking_id , date_from , date_to , guest_id , pay_rec, room_id)VALUES(21702, 654321,TO_DATE('22/12/2021', 'DD/MM/YYYY'), TO_DATE('05/01/2022', 'DD/MM/YYYY'), 14567,'YES', 10010)";
        String selectStmt3 = "INSERT INTO hotel_bookings(booked_by , booking_id , date_from , date_to , guest_id , room_id)VALUES(11587, 456789,TO_DATE('10/02/2022', 'DD/MM/YYYY'), TO_DATE('25/02/2022', 'DD/MM/YYYY'), 14567, 12004)";
        String selectStmt4 = "INSERT INTO hotel_bookings(booked_by , booking_id , date_from , date_to , guest_id , room_id)VALUES(11587, 456790,TO_DATE('15/05/2022', 'DD/MM/YYYY'), TO_DATE('30/05/2022', 'DD/MM/YYYY'), 14567, 12004)";
        String selectStmt5 = "INSERT INTO hotel_bookings(booked_by , booking_id , date_from , date_to , guest_id , room_id)VALUES(21702, 123456,TO_DATE('02/01/2022', 'DD/MM/YYYY'), TO_DATE('09/01/2022', 'DD/MM/YYYY'), 05843, 2002)";
        String selectStmt6 = "INSERT INTO hotel_bookings(booked_by , booking_id , date_from , date_to , guest_id , room_id)VALUES(21702, 123457,TO_DATE('10/08/2022', 'DD/MM/YYYY'), TO_DATE('31/08/2022', 'DD/MM/YYYY'), 05467, 6007)";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt2);
            DBUtil.dbExecuteUpdate(selectStmt3);
            DBUtil.dbExecuteUpdate(selectStmt4);
            DBUtil.dbExecuteUpdate(selectStmt5);
            DBUtil.dbExecuteUpdate(selectStmt6);

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}
