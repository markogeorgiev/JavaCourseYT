package Generics;

import java.time.Duration;
import java.util.Random;

interface IAthlete{
    public void startExercising();
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
    long startTime;
    long endTime;

    public Footballer(String name, String surname, String nationality, int age) {
        super(name, surname, nationality, age);
        this.startTime = System.nanoTime();
    }

    @Override
    public void startExercising() {
        System.out.println("Footballer " + this.name + " is starting to exercise");
        this.start();
    }

    @Override
    public void run() {
        int trainFor = new Random().nextInt(0,5);
        try {
            sleep(Duration.ofSeconds(trainFor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stopExercising();
            endTime = System.nanoTime();
        }
    }

    @Override
    public int getNumMinutesExercising() {
        return Math.toIntExact((endTime - startTime) / 1000);
    }

    @Override
    public void stopExercising() {
        System.out.println("Footballer " + this.name + " is stopping the exercise");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        int num = 5;
        while (num != 0){
            new Footballer("name" + num, "surname" + num, "nati" + num, num + 15).startExercising();
            num--;
        }
    }
}
