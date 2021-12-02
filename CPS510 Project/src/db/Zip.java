package db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Zip {
    private StringProperty postalCode;
    private StringProperty city;
    private StringProperty province;
    private StringProperty country;

    public Zip(String postalCode, String city, String province, String country) {
        this.postalCode = new SimpleStringProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.province = new SimpleStringProperty(province);
        this.country = new SimpleStringProperty(country);
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
