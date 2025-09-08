package backend.academy.gas.station;

import backend.academy.cars.Car;
import backend.academy.gas.FuelType;

public abstract class ReFuelStation {
    protected FuelType[] supportedFuelTypes;

    public ReFuelStation(FuelType[] supportedFuelTypes) {
        this.supportedFuelTypes = supportedFuelTypes;
    }

    public abstract void refuel(double amount, Car car, FuelType fuelType);

    public boolean isSupported(FuelType fuelType){
        for (FuelType supportedFuelType : supportedFuelTypes) {
            if (supportedFuelType == fuelType) {
                return true;
            }
        }
        return false;
    }
}
