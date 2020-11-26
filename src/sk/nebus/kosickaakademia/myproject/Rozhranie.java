package sk.nebus.kosickaakademia.myproject;

public interface Rozhranie {
    default public void sayWelcome(){
        System.out.println("-------------------");
        System.out.println("---Hello players---");
        System.out.println();
    }
}
