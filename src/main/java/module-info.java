module de.unibremen.akademie.kursverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens de.unibremen.akademie.kursverwaltung to javafx.fxml;
    exports de.unibremen.akademie.kursverwaltung;
    exports de.unibremen.akademie.kursverwaltung.controller;
    opens de.unibremen.akademie.kursverwaltung.controller to javafx.fxml;
    exports de.unibremen.akademie.kursverwaltung.domain;
    opens de.unibremen.akademie.kursverwaltung.domain to javafx.fxml;
}