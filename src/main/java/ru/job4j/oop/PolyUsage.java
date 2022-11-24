package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle jet = new Airplane();
        Vehicle scania = new Bus();
        Vehicle martin = new Train();
        Vehicle[] transport = new Vehicle[6];
        transport[0] = plane;
        transport[1] = bus;
        transport[2] = train;
        transport[3] = jet;
        transport[4] = scania;
        transport[5] = martin;

        for (Vehicle v:transport
             ) {
            System.out.println("My name is: " + v.getClass().getSimpleName());
            v.move();
            v.refuel();
            System.out.println();
        }
    }
}
