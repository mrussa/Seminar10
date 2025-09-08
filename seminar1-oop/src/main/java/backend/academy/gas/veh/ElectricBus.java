package backend.academy.gas.veh;

import backend.academy.gas.FuelType;

public class ElectricBus extends Vehicle {
    private static final FuelType fuelType = FuelType.ELECTRIC;

    public ElectricBus() {
        super(fuelType);
    }

    @Override
    public void refuel(double amount, FuelType fuelType) {
        //..
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }
}
