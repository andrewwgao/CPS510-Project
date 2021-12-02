package db;

import javafx.beans.property.*;

public class Credit {
    private StringProperty creditCard;
    private StringProperty creditCardNum;

    public Credit(String creditCardNum, String creditCard) {
        this.creditCard = new SimpleStringProperty(creditCard);
        this.creditCardNum = new SimpleStringProperty(creditCardNum);
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

}