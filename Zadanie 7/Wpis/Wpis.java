package Wpis;

import NumerTelefoniczny.NrTelefoniczny;

public abstract class Wpis {
    private String adres;
    private NrTelefoniczny nrTel;
    public Wpis(String adres, NrTelefoniczny nrTel){
        this.adres = adres;
        this.nrTel = nrTel;
    }
    public abstract void opis();
    public String getAdres(){
        return adres;
    }
    public void setAdres(String adres){
        this.adres = adres;
    }
    public NrTelefoniczny getNrTel(){
        return nrTel;
    }
    public void setNrTel(NrTelefoniczny nrTel){
        this.nrTel = nrTel;
    }
}
