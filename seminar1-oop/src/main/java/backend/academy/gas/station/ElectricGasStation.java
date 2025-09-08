package backend.academy.gas.station;

import backend.academy.cars.Car;
import backend.academy.gas.FuelType;

public class ElectricGasStation extends ReFuelStation {
    private static final FuelType[] supportedFuelTypes = {
        FuelType.ELECTRIC,
        FuelType.GAS
    };

    public ElectricGasStation() {
        super(supportedFuelTypes);
    }

    @Override
    public void refuel(double amount, Car car, FuelType fuelType) {
        if (isSupported(fuelType)) {
            //..
        }
    }
}

