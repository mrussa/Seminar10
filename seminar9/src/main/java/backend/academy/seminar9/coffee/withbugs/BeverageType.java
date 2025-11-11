package backend.academy.seminar9.coffee.withbugs;

/**
 * Тип кофейных напитков. Возможные варианты:
 * <ul>
 *     <li>Американо: 1 часть эспрессо на 2 части воды.</li>
 *     <li>Капучино: 1 часть эспрессо на 4 части молока.</li>
 *     <li>Латте: 1 часть эспрессо на 6 частей молока.</li>
 * </ul>
 */
public enum BeverageType {
    ESPRESSO(1, 0, 0),
    AMERICANO(1, 2, 0),
    CAPPUCCINO(1, 0, 4),
    LATTE(1, 0, 6);

    private final int espressoVolumes;
    private final int waterVolumes;
    private final int milkVolumes;

    BeverageType(int espressoVolumes, int waterVolumes, int milkVolumes) {
        this.espressoVolumes = espressoVolumes;
        this.waterVolumes = waterVolumes;
        this.milkVolumes = milkVolumes;
    }

    /**
     * Check if the given coffee beverage is canonical,
     * i.e. it has specific proportions of coffee, water and milk
     *
     * @param coffeeBeverage coffee beverage to check
     * @return {@code true}, if given coffee beverage is canonical
     */
    public boolean isCanonical(CoffeeBeverage coffeeBeverage) {
        int coffee = coffeeBeverage.coffee() * espressoVolumes;
        return coffee * waterVolumes == coffeeBeverage.water()
            && coffee * milkVolumes == coffeeBeverage.milk();
    }
}
