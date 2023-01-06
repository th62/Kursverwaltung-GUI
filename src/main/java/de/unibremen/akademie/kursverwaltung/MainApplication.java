package de.unibremen.akademie.kursverwaltung;

import de.unibremen.akademie.kursverwaltung.domain.KvModel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    //KvModel model;
    @Override
    public void start(Stage stage) throws IOException {
        // Alert-Window beim Schliessen der Anwendung
        class CloseHandler implements EventHandler<WindowEvent> {
            @Override
            public void handle(WindowEvent event) {
                if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                    Alert dialog = new Alert(Alert.AlertType.CONFIRMATION, "Alle Daten gesichert und Anwendung schliessen?");
                    dialog.setTitle("Beenden");
                    dialog.setHeaderText("Kursverwaltung beenden");
                    Optional<ButtonType> result = dialog.showAndWait();
                    boolean okToClose = result.isPresent() &&
                            result.get() == ButtonType.OK;
                    if (!okToClose) {
                        event.consume();
                    }
                }
            }
        }
        stage.setOnCloseRequest(new CloseHandler());
        // GUI laden/starten
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.setTitle("Kursverwaltung v 1.0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //model aus Datei laden
        //KvModel.model.load("src/main/resources/de/unibremen/akademie/kursverwaltung/backupsaveddata/1672994331854");
        KvModel.model.load();
        //Application (GUI) starten
        launch();
        //model beim Beenden in Datei speichern
        KvModel.model.save();
        KvModel.model.save("src/main/resources/de/unibremen/akademie/kursverwaltung/backupsaveddata/" + System.currentTimeMillis());
    }
}