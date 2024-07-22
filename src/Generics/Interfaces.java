package Generics;

interface IAthlete{
    public void startingExercising();
    public int getNumMinutesExercising();
    public void stopExercising();
}

abstract class Athlete extends Thread{
    String name;
    String surname;
    String nationality;
    int age;

    public Athlete(String name, String surname, String nationality, int age) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
    }
}

class Footballer extends Athlete implements IAthlete{

    public Footballer(String name, String surname, String nationality, int age) {
        super(name, surname, nationality, age);
    }

    @Override
    public void startingExercising() {
        System.out.println("Footballer " + this.name + " is starting to exercise");
        this.start();
    }

    @Override
    public void run() {

    }

    @Override
    public int getNumMinutesExercising() {
        return this;
    }

    @Override
    public void stopExercising() {
        System.out.println("Footballer " + this.name + " is stopping the exercise");
    }
}
public class Interfaces {
}
