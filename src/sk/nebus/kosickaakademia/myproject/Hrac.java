package sk.nebus.kosickaakademia.myproject;

public abstract class Hrac implements Rozhranie {
    String meno;

    public Hrac(){

    }

    public Hrac(String meno){
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }
}
