package sk.nebus.kosickaakademia.myproject;

public class Hrac1 extends Hrac {

    int vek;

    public Hrac1(String meno) {
        super(meno);
    }

    public Hrac1(int vek){
        //volam konstruktor s menom cez this ale v kode ho nevyuzivam
        this("Kamil");
        System.out.println("Som konstruktor 2");
        this.vek = vek;
    }

    @Override
    public void sayWelcome(){
        //super.sayWelcome();
        System.out.println("I am a player1 my name is: " + getMeno());
        System.out.println();
    }
}
