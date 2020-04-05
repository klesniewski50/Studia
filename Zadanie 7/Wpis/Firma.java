package Wpis;

import NumerTelefoniczny.NrTelefoniczny;

public class Firma extends Wpis {

    private String nazwa;
    @Override
    public void opis() {
        System.out.println("Firma nazywa się " + nazwa + ". Adres: " + getAdres() + ". Kontakt: " + getNrTel().toString());
    }
    public Firma(String nazwa, String adres, NrTelefoniczny nrTel){
        super(adres, nrTel);
        this.nazwa = nazwa;
    }
    public String getNazwa(){
        return nazwa;
    }
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
}
