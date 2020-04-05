package main;

import NumerTelefoniczny.*;
import Wpis.*;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        NrTelefoniczny[] nrTelefonicznie = new NrTelefoniczny[]{
                new NrTelefoniczny(44, 1234567),
                new NrTelefoniczny(23, 2345678),
                new NrTelefoniczny(44, 3456789),
                new NrTelefoniczny(23, 4567890),
        };
        Wpis[] wpisy = new Wpis[]{
                new Osoba("Dundee", "Crocodilish", "Austria (nie Australia)", nrTelefonicznie[0]),
                new Osoba("Biedronka", "Tesco", "Sulejów", nrTelefonicznie[1]),
                new Firma("GastroAstroTurboFaza123", "zobacz na mapach Google", nrTelefonicznie[2]),
                new Firma("Traktor123", "Eciwodaw", nrTelefonicznie[3])
        };
        TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna = new TreeMap<NrTelefoniczny, Wpis>(NrTelefoniczny::compareTo);
        for(int i = 0; i < 4; i++){
            ksiazkaTelefoniczna.put(wpisy[i].getNrTel(), wpisy[i]);
        }
        Iterator it = ksiazkaTelefoniczna.values().iterator();
        while(it.hasNext()){
            ((Wpis)(it.next())).opis();
        }
        //Druga możliwość wypisania
        /*for(Map.Entry<NrTelefoniczny, Wpis> entry : ksiazkaTelefoniczna.entrySet()){
            (entry.getValue()).opis();
        }*/
    }
}
