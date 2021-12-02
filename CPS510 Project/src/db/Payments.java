package db;

import javafx.beans.property.*;

public class Payments {
    private IntegerProperty bookingID;
    private IntegerProperty paymentID;
    private StringProperty discountCode;
    private StringProperty total;

    public Payments() {
        this.bookingID = new SimpleIntegerProperty();
        this.paymentID = new SimpleIntegerProperty();
        this.discountCode = new SimpleStringProperty();
        this.total = new SimpleStringProperty();

    }
    public int getBookingID() {
        return bookingID.get();
    }
    public void setBookingID(int bookingID){
        this.bookingID.set(bookingID);
    }
    public IntegerProperty bookingIDProperty(){
        return bookingID;
    }

    public int getPaymentID() {
        return paymentID.get();
    }
    public void setPaymentID(int paymentID){
        this.paymentID.set(paymentID);
    }
    public IntegerProperty paymentIDProperty(){
        return paymentID;
    }

    public String getDiscountCode() {
        return discountCode.get();
    }
    public void setDiscountCode(String discountCode){
        this.discountCode.set(discountCode);
    }
    public StringProperty discountCodeProperty(){
        return discountCode;
    }

    public String getTotal() {
        return total.get();
    }
    public void setTotal(String total){
        this.total.set(total);
    }
    public StringProperty totalProperty(){
        return total;
    }

}