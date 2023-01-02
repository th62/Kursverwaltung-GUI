package de.unibremen.akademie.kursverwaltung.controller;

import de.unibremen.akademie.kursverwaltung.domain.Kursverwaltung;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PersonenDetailsController {
    @FXML
    //public TextField anrede;
    public TextField titel;
    public TextField name;
    public TextField vorname;
    public TextField strasse;
    public TextField plz;
    public TextField email;
    public TextField telefon;
    public TextField ort;
    public ChoiceBox Anrede;
    public Button save;
    public String nameS;

    public void initialize() {
        Anrede.setItems(FXCollections.observableArrayList(de.unibremen.akademie.kursverwaltung.domain.Anrede.values()));

    }

    @FXML
    public void onsaveclick() {

        Kursverwaltung.addPerson(name.getText(), vorname.getText(), strasse.getText(), plz.getText(), ort.getText(), email.getText(), telefon.getText());
        name.clear();
        vorname.clear();
        strasse.clear();
        plz.clear();
        ort.clear();
        email.clear();
        System.out.println(Kursverwaltung.personList);


    }


}
