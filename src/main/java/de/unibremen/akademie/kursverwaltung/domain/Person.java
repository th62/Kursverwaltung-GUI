package de.unibremen.akademie.kursverwaltung.domain;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Person {

    private Anrede anrede;
    private String titel;
    private String name;
    private String vorname;
    private String strasse;
    private String plz;
    private String ort;
    private String email;
    private String telefon;
    private List<Kurs> kursInteressiert;
    private List<Kurs> kursTeilnahme;


    public Person() {
    }

    public Anrede getAnrede() {
        return anrede;
    }

    public void setAnrede(Anrede anrede) {
        this.anrede = anrede;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkIsEmpty(name)) {
            this.name = name;
        }
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        if (checkIsEmpty(vorname)) {
            this.vorname = vorname;
        }
    }

    public String getStrasse() {
        return strasse;
    }

    public static boolean checkIsEmpty(String wert) {
        return wert != null && wert.length() >= 2;
    }

    public String getPlz() {
        return plz;
    }

    public static boolean checkValidEmail(String email) {
        return Pattern.compile("\\w[a-z0-9]+@[a-z0-9.-]+\\.[a-z]{2,10}").matcher(email).matches();
        //return Pattern.compile("\\b[A-Z0-9._%]+@[A-Z0-9.-]+\\.[A-Z]{2,10}\\b").matcher(email).matches();

    }

    public String getOrt() {
        return ort;
    }

    static public String addPerson(Anrede anrede, String titel, String name, String vorname, String strasse, String plz, String ort, String email, String telefon) {
        if (checkIsEmpty(name) && checkIsEmpty(vorname) && checkValidEmail(email)) {
            Person neuePerson = new Person();
            neuePerson.setAnrede(anrede);
            neuePerson.setTitel(titel);
            neuePerson.setVorname(vorname);
            neuePerson.setName(name);
            neuePerson.setStrasse(strasse);
            neuePerson.setPlz(plz);
            neuePerson.setOrt(ort);
            neuePerson.setEmail(email);
            neuePerson.setTelefon(telefon);

            return "Alles OK!";
        }

        return "Fehler! Daten wurden nicht gespeichert!";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (checkValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Email ist falsch!");
        }
    }

    public String getTelefon() {
        return telefon;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public List<Kurs> getKursInteressiert() {
        return kursInteressiert;
    }

    public void setKursInteressiert(List<Kurs> kursInteressiert) {
        this.kursInteressiert = kursInteressiert;
    }

    public List<Kurs> getKursTeilnahme() {
        return kursTeilnahme;
    }

    public void setKursTeilnahme(List<Kurs> kursTeilnahme) {
        this.kursTeilnahme = kursTeilnahme;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(vorname, person.vorname) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vorname, email);
    }
}
