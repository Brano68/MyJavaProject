package sk.nebus.kosickaakademia.myproject;

import java.util.Random;

public class HracPC extends Hrac {

    public HracPC(String meno) {
        super(meno);
    }

    @Override
    public void sayWelcome(){
        System.out.println("I am a player2 my name is: " + getMeno());
        System.out.println();
    }

    public char guessChar(){
        Random random = new Random();
        int cislo;
        cislo = random.nextInt(122-97+1)+97;
        char znak;
        znak = (char)cislo;
        return znak;
    }
}
