package backend.academy.gas.veh;

import backend.academy.cars.Car;
import backend.academy.gas.FuelType;

public class Truck extends Vehicle {
    private static final FuelType fuelType = FuelType.DIESEL;

    public Truck() {
        super(fuelType);
    }

    @Override
    public void refuel(double amount, FuelType fuelType) {

    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }
}
