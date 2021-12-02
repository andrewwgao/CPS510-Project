package db;

import javafx.beans.property.*;

public class Guest {
    private IntegerProperty guestID;
    private StringProperty fName;
    private StringProperty lName;
    private IntegerProperty stayCount;
    private StringProperty billAddress;
    private StringProperty creditCard;
    private StringProperty creditCardNum;
    private StringProperty postalCode;
    private StringProperty city;
    private StringProperty province;
    private StringProperty country;

    public Guest() {
        this.guestID = new SimpleIntegerProperty();
        this.fName = new SimpleStringProperty();
        this.lName = new SimpleStringProperty();
        this.stayCount = new SimpleIntegerProperty();
        this.billAddress = new SimpleStringProperty();
        this.creditCard = new SimpleStringProperty();
        this.creditCardNum = new SimpleStringProperty();
        this.postalCode = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.province = new SimpleStringProperty();
        this.country = new SimpleStringProperty();
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

    public int getStayCount() {
        return stayCount.get();
    }
    public void setStayCount(int stayCount){
        this.stayCount.set(stayCount);
    }
    public IntegerProperty stayCountProperty(){
        return stayCount;
    }

    public String getfName() {
        return fName.get();
    }
    public void setfName(String fName){
        this.fName.set(fName);
    }
    public StringProperty fNameProperty(){
        return fName;
    }

    public String getlName() {
        return lName.get();
    }
    public void setlName(String lName){
        this.lName.set(lName);
    }
    public StringProperty lNameProperty(){
        return lName;
    }

    public String getBillAddress() {
        return billAddress.get();
    }
    public void setBillAddress(String billAddress){
        this.billAddress.set(billAddress);
    }
    public StringProperty billAddressProperty(){
        return billAddress;
    }

    public String getCreditCard() {
        return creditCard.get();
    }
    public void setCreditCard(String creditCard){
        this.creditCard.set(creditCard);
    }
    public StringProperty creditCardProperty(){
        return creditCard;
    }

    public String getCreditCardNum() {
        return creditCardNum.get();
    }
    public void setCreditCardNum(String creditCardNum){
        this.creditCardNum.set(creditCardNum);
    }
    public StringProperty creditCardNumProperty(){
        return creditCardNum;
    }

    public String getPostalCode() {
        return postalCode.get();
    }
    public void setPostalCode(String postalCode){
        this.postalCode.set(postalCode);
    }
    public StringProperty postalCodeProperty(){
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }
    public void setCity(String city){
        this.city.set(city);
    }
    public StringProperty cityProperty(){
        return city;
    }

    public String getProvince() {
        return province.get();
    }
    public void setProvince(String province){
        this.province.set(province);
    }
    public StringProperty provinceProperty(){
        return province;
    }

    public String getCountry() {
        return country.get();
    }
    public void setCountry(String country){
        this.country.set(country);
    }
    public StringProperty countryProperty(){
        return country;
    }
}