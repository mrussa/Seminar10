package backend.academy.gas.veh;

import backend.academy.gas.FuelType;

public abstract class Vehicle {
    protected FuelType fuelType;

    public Vehicle(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public abstract void refuel(double amount, FuelType fuelType);

    public abstract FuelType getFuelType();
}
