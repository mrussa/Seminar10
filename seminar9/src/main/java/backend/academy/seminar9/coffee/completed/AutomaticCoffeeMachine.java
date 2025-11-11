package backend.academy.seminar9.coffee.completed;

import backend.academy.seminar9.coffee.exceptions.DecalcificationRequiredException;
import backend.academy.seminar9.coffee.exceptions.NotEnoughSuppliesException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Автоматическая кофемашина со встроенным "хранилищем" сырья: кофейные зерна, вода и молоко.
 * <ul>
 *     <li>1 порция 30 мл эспрессо требует 15 г зерен + 30 мл воды.</li>
 *     <li>1 г кофейных зерен впитывает 1 мл воды во время приготовления кофе.</li>
 *     <li>Таким образом, для приготовления 30 мл эспрессо потребуется 15 г зерен + 45 мл воды.</li>
 *     <li>На каждые 20 мл молока требуется 1 мл воды для генерации пара.</li>
 * </ul>
 */
public class AutomaticCoffeeMachine implements CoffeeMachine {

    private static final Logger logger = LoggerFactory.getLogger(AutomaticCoffeeMachine.class);

    private final CoffeeMachineInventory inventory;
    private final DecalcDetector decalcDetector;

    public AutomaticCoffeeMachine(CoffeeMachineInventory inventory, DecalcDetector decalcDetector) {
        this.inventory = inventory;
        this.decalcDetector = decalcDetector;
    }

    @Override
    public CoffeeBeverage brewCoffee(BeverageType beverageType) {
        Objects.requireNonNull(beverageType, "beverageType");

        logger.info("Brewing {} coffee", beverageType);
        return switch (beverageType) {
            case ESPRESSO -> brewCustom(30, 0, 0);
            case AMERICANO -> brewCustom(30, 60, 0);
            case CAPPUCCINO -> brewCustom(30, 0, 120);
            case LATTE -> brewCustom(30, 0, 180);
        };
    }

    @Override
    public CoffeeBeverage brewCustom(int coffee, int water, int milk) {
        if (coffee < 0 || water < 0 || milk < 0) {
            throw new IllegalArgumentException("Impossible to brew beverage with negative params");
        }

        validateDecalcification();

        int beans = coffee / 2;
        int waterLoss = beans + (milk / 20);
        int finalWaterConsumption = coffee + waterLoss + water;

        logger.info("Requested beverage with: coffee: {}, water: {}, milk: {}", coffee, water, milk);
        logger.info("Total inventory consumption: beans: {}, water: {}, milk: {}", beans, finalWaterConsumption, milk);
        logger.info("Validating current inventory state: {}", inventory);
        validateSupplies(beans, finalWaterConsumption, milk);
        logger.info("Inventory has enough supplies");

        inventory.setBeans(inventory.getBeans() - beans);
        inventory.setWater(inventory.getWater() - finalWaterConsumption);
        inventory.setMilk(inventory.getMilk() - milk);
        decalcDetector.incrementCounter();

        logger.info("Inventory after brewing coffee: {}", inventory);

        return new CoffeeBeverage(coffee, water, milk);
    }

    public void startMaintenance() {
        logger.info("Started maintenance, current decalc detector state: {}", decalcDetector.getCounter());
        decalcDetector.reset();
        logger.info("Maintenance finished");
    }

    private void validateDecalcification() {
        if (decalcDetector.isDecalcificationRequired()) {
            logger.error("Decalcification required");
            throw new DecalcificationRequiredException();
        }
        logger.info("Decalcification is not required");
    }

    private void validateSupplies(int coffee, int water, int milk) {
        int coffeeNeeded = 0;
        int waterNeeded = 0;
        int milkNeeded = 0;

        if (inventory.getBeans() < coffee) {
            coffeeNeeded = coffee - inventory.getBeans();
        }
        if (inventory.getWater() < water) {
            waterNeeded = water - inventory.getWater();
        }
        if (inventory.getMilk() < milk) {
            milkNeeded = milk - inventory.getMilk();
        }

        if (coffeeNeeded != 0 || waterNeeded != 0 || milkNeeded != 0) {
            logger.info("Not enough supplies");
            throw new NotEnoughSuppliesException(coffeeNeeded, waterNeeded, milkNeeded);
        }
    }
}
