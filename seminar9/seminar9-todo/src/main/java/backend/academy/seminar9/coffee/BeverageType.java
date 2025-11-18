package backend.academy.seminar9.coffee;

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
     * Проверяет, является ли данный кофейный напиток каноническим,
     * т.е. имеет ли он определённые пропорции кофе, воды и молока
     *
     * @param coffeeBeverage кофейный напиток для проверки
     * @return {@code true}, если данный кофейный напиток является каноническим
     */
    public boolean isCanonical(CoffeeBeverage coffeeBeverage) {
        int coffee = coffeeBeverage.coffee() * espressoVolumes;
        return coffee * waterVolumes == coffeeBeverage.water()
            && coffee * milkVolumes == coffeeBeverage.milk();
    }
}
