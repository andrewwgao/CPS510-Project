package controller;
import javafx.event.ActionEvent;

public class RootLayoutController {

    // create reference so application can call itself
    private Main main;

    public void setMain (Main main) {
       this.main = main;
    }
    public void showGuestsView() {
        main.showGuestsView();
    }
    public void showPaymentsView() {
        main.showPaymentsView();
    }
    public void showEmployeesView() {
        main.showEmployeesView();
    }
    public void showRoomsView() {
        main.showRoomsView();
    }
    public void showBookingsView() {
        main.showBookingsView();
    }
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
