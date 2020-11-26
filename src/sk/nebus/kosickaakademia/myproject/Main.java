package sk.nebus.kosickaakademia.myproject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
Hra spociva v tom ze PC si mysli pismena od a do z ak hrac1 hada pismeno a uhadne
hra skonci s vypisom ze vyhral ak neuhadol PC si mysli pismeno ak uhadne vyhral
ak neuhadne tak hra pokracuje. Cele to ide az dovtedy ak niekto neuhadne pismenko
 */
public class Main {
    public static void main(String[] args) {
        //zavolanie metody na vytvorenie suboru s 10 nahodnymi pismunami
        //pouzitie try catch
        createFileWithLetters();

        //metoda na nacitanie pismen do Listu
        //pouzitie Listu a pretipovania
        ArrayList<Character> znakovePole = loadFIleToTheList();

        //metoda na slucku hry
        bodyOfGame(znakovePole);
    }


    //metoda na vytvorenie suboru a naplnenie 10 nahodnymi pismenami od a - z
    private static void createFileWithLetters(){
        Random random = new Random();
        int genCislo;
        try {
            File file = new File("output/" + "num.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);

            for(int i = 0; i < 10; i++){
                genCislo = random.nextInt(122-97+1)+97;
                fw.write((char)genCislo);
            }
            fw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    //metoda na nacitanie char do Array
    private static ArrayList loadFIleToTheList(){
        ArrayList<Character> znakovePole= new ArrayList<>();
        try {
            FileReader fr = new FileReader("output/num.txt");
            int i;
            while((i = fr.read()) != -1){
                znakovePole.add((char)i);
            }
            fr.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        /*
        for(Character ch:znakovePole){
            System.out.println(ch + " ");
        }
         */
        return znakovePole;
    }


    //metoda na PC meno
    private static String nameOfPC(){
        Random random = new Random();
        int cislo = random.nextInt(4);
        String[] pole = new String[]{"PC-mechanik", "PC-stroj", "PC-rychlik", "PC-bus"};
        return pole[cislo];
    }

    //telo hry
    private static void bodyOfGame(ArrayList<Character> znakovePole){
        System.out.println("Player 1 write your name: ");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        Hrac1 hrac1 = new Hrac1(name1);
        HracPC hracPC = new HracPC(nameOfPC());

        //uvitanie takto
        new Uvitaj().sayWelcome();

        //overide na hrac1 a PC
        hrac1.sayWelcome();
        hracPC.sayWelcome();

        Scanner sc = new Scanner(System.in);
        String retazec;
        char znak;
        while (true){
            //osetrenie pre hraca1
            System.out.println(hrac1.getMeno() + " zadaj pismenko: ");
            retazec = sc.nextLine();
            znak = retazec.charAt(0);
            if(znakovePole.contains(znak)){
                System.out.println(hrac1.getMeno() + " vyhral si!!");
                System.out.println();
                printArray(znakovePole);
                break;
            }else{
                System.out.println("Smola. Nemyslim si take pismeno!!!");
            }
            //osetrenie pre PC
            System.out.println(hracPC.getMeno() + " zadaj pismenko");
            char pismenko = hracPC.guessChar();
            System.out.println("Zadavam pismenko: " + pismenko);
            if(znakovePole.contains(pismenko)){
                System.out.println(hracPC.getMeno() + " vyhral si!!");
                System.out.println();
                printArray(znakovePole);
                break;
            }else{
                System.out.println("Smola. Nemyslim si take pismeno!!!");
            }

        }


    }

    //vytlacenie listu
    private static void printArray(ArrayList<Character> znakovePole){
        System.out.println("Vsetke pismena ktore som si myslel boli: ");
        for(Character ch:znakovePole){
            System.out.print(ch + " ");
        }
    }

}
