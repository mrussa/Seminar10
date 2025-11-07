package backend.academy.seminar9.coffee.completed;

import static java.lang.Math.multiplyExact;

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
     * Проверяет, является ли указанный кофейный напиток каноническим,
     * то есть имеет ли он определённые пропорции кофе, воды и молока
     *
     * @param coffeeBeverage напиток, который нужно проверить
     * @return {@code true}, если указанный кофейный напиток является каноническим
     */
    public boolean isCanonical(CoffeeBeverage coffeeBeverage) {
        if (coffeeBeverage == null) {
            return false;
        }
        if (coffeeBeverage.coffee() <= 0) {
            return false;
        }

        try {
            int coffee = multiplyExact(coffeeBeverage.coffee(), espressoVolumes);
            return multiplyExact(coffee, waterVolumes) == coffeeBeverage.water()
                && multiplyExact(coffee, milkVolumes) == coffeeBeverage.milk();
        } catch (ArithmeticException e) {
            return false;
        }
    }
}
