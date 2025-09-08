package backend.academy.simplecar;

public class LightWeight extends SimpleCar {
    private int passengerSeats;

    public LightWeight(
        String make, String model, int year, String color,
        int passengerSeats
    ) {
        super(make, model, year, color);
        this.passengerSeats = passengerSeats;
        this.make = "test";
    }
}
