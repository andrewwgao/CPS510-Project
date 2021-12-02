package controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hotel Management Database A9");

        initRootLayout(); // show initial screen
        showEmployeesView(); // show employee table on load
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMain(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBookingsView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/BookingsView.fxml"));
            AnchorPane bookingsOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(bookingsOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGuestsView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/GuestsView.fxml"));
            AnchorPane GuestsOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(GuestsOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRoomsView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/RoomsView.fxml"));
            AnchorPane RoomsOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(RoomsOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPaymentsView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/PaymentsView.fxml"));
            AnchorPane PaymentsOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(PaymentsOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showEmployeesView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/EmployeesView.fxml"));
            AnchorPane EmployeesOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(EmployeesOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
