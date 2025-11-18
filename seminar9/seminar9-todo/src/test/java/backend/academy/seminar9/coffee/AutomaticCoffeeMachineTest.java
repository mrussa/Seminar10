package backend.academy.seminar9.coffee;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AutomaticCoffeeMachineTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 1"})
    @DisplayName("Выбрасывается IllegalArgumentException, если запрошено приготовление напитка с отрицательными параметрами")
    void shouldNotBrewCustomWithNegativeParams(int coffee, int water, int milk) {

    }

    @Test
    @DisplayName("При приготовлении напитка с произвольными параметрами расход запасов кофемашины вычисляется корректно")
    void shouldBrewCustomBeverage() {

    }

    @ParameterizedTest
    @EnumSource(BeverageType.class)
    @DisplayName("При приготовлении напитка указанного типа возвращается канонический кофейный напиток")
    void shouldBrewCanonicalBeverages(BeverageType beverageType) {

    }

    @Test
    @DisplayName("Выбрасывается DecalcificationRequiredException, если требуется декальцинация кофемашины")
    void shouldNotBrewIfDecalcificationRequired() {

    }

    @Test
    @DisplayName("Можно приготовить кофейный напиток после проведения декальцинации кофемашины")
    void shouldBrewAfterMaintenance() {

    }

    @ParameterizedTest
    @MethodSource("getNotEnoughSuppliesInventory")
    @DisplayName("Выбрасывается NotEnoughSuppliesException c корректным сообщением, если каких-то из запасов кофемашины не хватает для приготовления напитка")
    void shouldNotBrewIfNotEnoughSupplies(
        BeverageType beverageType,
        CoffeeMachineInventory inventory,
        String expectedMessage
    ) {

    }

    private static Stream<Arguments> getNotEnoughSuppliesInventory() {
        return Stream.of(
            arguments(
                BeverageType.ESPRESSO,
                new CoffeeMachineInventory(1, 1, 1),
                "Implement this"
            )
        );
    }
}
