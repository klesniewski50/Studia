package NumerTelefoniczny;

public class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    private int nrkierunkowy;
    private int nrTelefonu;

    public NrTelefoniczny(){

    }
    public NrTelefoniczny(int nrkierunkowy, int nrTelefonu){
        this.nrkierunkowy = nrkierunkowy;
        this.nrTelefonu = nrTelefonu;
    }
    @Override
    public int compareTo(NrTelefoniczny o) {
        if(o == null)
            return -1;
        if(equals(o))
            return 0;
        if(nrkierunkowy == o.nrkierunkowy){
            return nrTelefonu - o.nrTelefonu;
        }
        return nrkierunkowy - o.nrkierunkowy;
    }
    public boolean equals(NrTelefoniczny o){
        return (nrkierunkowy == o.nrkierunkowy && nrTelefonu == o.nrTelefonu);
    }
    public String toString(){
        return "" + nrkierunkowy + nrTelefonu;
    }
}
