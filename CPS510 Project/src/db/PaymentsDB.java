package db;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentsDB {
    public static ObservableList<Payments> searchPayments() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT payment_id, total, booking_id, discount_code\n" +
                "    FROM hotel_payments\n" +
                "    WHERE discount_code = 'NONE'\n" +
                "    ORDER BY total";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Payments> paymentsList = getPaymentsList(rsSet);
            return paymentsList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // get bookings data
    public static ObservableList<Payments> getPaymentsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Payments> paymentList = FXCollections.observableArrayList();

        while (rs.next()){
            Payments payment = new Payments();
            payment.setBookingID(rs.getInt("BOOKING_ID"));
            payment.setPaymentID(rs.getInt("PAYMENT_ID"));
            payment.setDiscountCode(rs.getString("DISCOUNT_CODE"));
            payment.setTotal(rs.getString("TOTAL"));

            paymentList.add(payment);
        }
        return paymentList;
    }

    // show all bookings in table
    public static ObservableList<Payments> viewPayments() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM hotel_payments";

        try {
            ResultSet rsSet = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Payments> paymentList = getPaymentsList(rsSet);
            return paymentList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    // insert data into table
    public static void insertPayments() throws SQLException, ClassNotFoundException {
        String selectStmt1 = "INSERT INTO hotel_payments(payment_id , booking_id , discount_code, total)VALUES(0001, 987654, 'FREE4TWO', '80.99')";
        String selectStmt2 = "INSERT INTO hotel_payments(payment_id , booking_id , discount_code, total)VALUES(1588, 654321, 'NONE', '97.99')";
        String selectStmt3 = "INSERT INTO hotel_payments(payment_id , booking_id , discount_code, total)VALUES(8496, 456789, 'NONE', '105.99')";
        String selectStmt4 = "INSERT INTO hotel_payments(payment_id , booking_id , discount_code, total)VALUES(9782, 123456, 'FREESTAY', '0.00')";
        String selectStmt5 = "INSERT INTO hotel_payments(payment_id , booking_id , discount_code, total)VALUES(4568, 123457, 'NONE', '97.99')";

        try {
            DBUtil.dbExecuteUpdate(selectStmt1);
            DBUtil.dbExecuteUpdate(selectStmt2);
            DBUtil.dbExecuteUpdate(selectStmt3);
            DBUtil.dbExecuteUpdate(selectStmt4);
            DBUtil.dbExecuteUpdate(selectStmt5);

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}
