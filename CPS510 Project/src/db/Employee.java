package db;

import javafx.beans.property.*;
import java.sql.Date;

public class Employee {
    private IntegerProperty empID;
    private StringProperty fName;
    private StringProperty lName;
    private IntegerProperty phone;
    private StringProperty email;
    private SimpleObjectProperty<Date> dob;
    private StringProperty position;
    private StringProperty status;
    private IntegerProperty salary;

    public Employee() {
        this.empID = new SimpleIntegerProperty();
        this.fName = new SimpleStringProperty();
        this.lName = new SimpleStringProperty();
        this.phone = new SimpleIntegerProperty();
        this.email = new SimpleStringProperty();
        this.dob = new SimpleObjectProperty<>();
        this.position = new SimpleStringProperty();
        this.status = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();
    }

    public int getEmpID() {
        return empID.get();
    }
    public void setEmpID(int empID){
        this.empID.set(empID);
    }
    public IntegerProperty empIDProperty(){
        return empID;
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

    public int getPhone() {
        return phone.get();
    }
    public void setPhone(int phone){
        this.phone.set(phone);
    }
    public IntegerProperty phoneProperty(){
        return phone;
    }

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email){
        this.email.set(email);
    }
    public StringProperty emailProperty(){
        return email;
    }

    public Object getDOB() {
        return dob.get();
    }
    public void setDOB(Date dob){
        this.dob.set(dob);
    }
    public SimpleObjectProperty<Date> dobProperty(){
        return dob;
    }

    public String getPosition() {
        return position.get();
    }
    public void setPosition(String position){
        this.position.set(position);
    }
    public StringProperty positionProperty(){
        return position;
    }

    public String getStatus() {
        return status.get();
    }
    public void setStatus(String status){
        this.status.set(status);
    }
    public StringProperty statusProperty(){
        return status;
    }

    public int getSalary() {
        return salary.get();
    }
    public void setSalary(int salary){
        this.salary.set(salary);
    }
    public IntegerProperty salaryProperty(){
        return salary;
    }
}