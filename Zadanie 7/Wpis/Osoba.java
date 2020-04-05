package Wpis;

import NumerTelefoniczny.NrTelefoniczny;

public class Osoba extends Wpis {

    private String imie;
    private String nazwisko;
    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny nrTel){
        super(adres, nrTel);
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    @Override
    public void opis() {
        System.out.println("Nazywam się " + imie + " " + nazwisko + ". " + "Mój adres to " + getAdres() + ". Numer telefonu: " + getNrTel().toString());
    }
    public String getImie(){
        return imie;
    }
    public void setImie(String imie){
        this.imie = imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }
}
