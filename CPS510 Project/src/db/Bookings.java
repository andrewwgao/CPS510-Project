package db;

import javafx.beans.property.*;
import java.sql.Date;

public class Bookings {
    private IntegerProperty bookingID;
    private IntegerProperty guestID;
    private IntegerProperty roomID;
    private StringProperty payRec;
    private StringProperty bookedBy;
    private SimpleObjectProperty<Date> dateFrom;
    private SimpleObjectProperty<Date> dateTo;

    public Bookings() {
        this.bookingID = new SimpleIntegerProperty();
        this.guestID = new SimpleIntegerProperty();
        this.roomID = new SimpleIntegerProperty();
        this.payRec = new SimpleStringProperty();
        this.bookedBy = new SimpleStringProperty();
        this.dateFrom = new SimpleObjectProperty<>();
        this.dateTo = new SimpleObjectProperty<>();

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

    public int getGuestID() {
        return guestID.get();
    }
    public void setGuestID(int guestID){
        this.guestID.set(guestID);
    }
    public IntegerProperty guestIDProperty(){
        return guestID;
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

    public String getPayRec() {
        return payRec.get();
    }
    public void setPayRec(String payRec){
        this.payRec.set(payRec);
    }
    public StringProperty payRecProperty(){
        return payRec;
    }

    public String getBookedBy() {
        return bookedBy.get();
    }
    public void setBookedBy(String bookedBy){
        this.bookedBy.set(bookedBy);
    }
    public StringProperty bookedByProperty(){
        return bookedBy;
    }

    public Object getDateFrom() {
        return dateFrom.get();
    }
    public void setDateFrom(Date dateFrom){
        this.dateFrom.set(dateFrom);
    }
    public SimpleObjectProperty<Date> dateFromProperty(){
        return dateFrom;
    }

    public Object getDateTo() {
        return dateTo.get();
    }
    public void setDateTo(Date dateTo){
        this.dateTo.set(dateTo);
    }
    public SimpleObjectProperty<Date> dateToProperty(){
        return dateTo;
    }
}