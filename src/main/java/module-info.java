module com.example.rogerwidmermaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.gibb.iet.application to javafx.fxml;
    exports ch.gibb.iet.application;
}