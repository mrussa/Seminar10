package backend.academy.cars;

public class DualTankCar extends Car {
    private double secondaryFuelLevel;
    private double maxFuelCapacity;

    private static final double MIN_FUEL_REQUIRED = 1.0;

    @Override
    public void startEngine() {
        if (checkFuelLevel() >= MIN_FUEL_REQUIRED) {
            if (isEngineOn) {
                super.startEngine();
                System.out.println("Engine started successfully.");
            } else {
                System.out.println("Engine is already on.");
            }
        } else {
            System.out.println("Not enough fuel to start the engine.");
        }
    }

    public DualTankCar(
        String make,
        String model,
        int year,
        String color,
        double maxFuelCapacity
    ) {
        super(make, model, year, color);
        this.secondaryFuelLevel = 0.0;
        this.maxFuelCapacity = maxFuelCapacity;

        refuel(100.0);
        isEngineOn = false;
    }

    @Override
    public void refuel(double amount) {
        System.out.println("Refueling with total amount: " + amount);
        double availablePrimary = maxFuelCapacity - super.checkFuelLevel();

        // Если хватает места в основном баке
        if (amount <= availablePrimary) {
            super.refuel(amount);
        } else {
            // Заправляем основной бак до предела и остаток во второй бак
            super.refuel(availablePrimary);
            secondaryFuelLevel += (amount - availablePrimary);
        }
    }

    // Переопределение метода для получения суммарного уровня топлива
    @Override
    public double checkFuelLevel() {
        return super.checkFuelLevel() + secondaryFuelLevel;
    }

    // Получить состояние для каждого из баков
    public double getPrimaryFuelLevel() {
        return super.checkFuelLevel();
    }

    public double getSecondaryFuelLevel() {
        return secondaryFuelLevel;
    }
}
