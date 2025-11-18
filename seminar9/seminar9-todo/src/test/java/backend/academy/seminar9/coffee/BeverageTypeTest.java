package backend.academy.seminar9.coffee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeverageTypeTest {

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется null")
    void shouldGetNotCanonicalIfBeverageIsNull() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется напиток с нулевым содержимым")
    void shouldGetNotCanonicalIfBeverageParamsAreEmpty() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется напиток с отрицательным объёмом эспрессо")
    void shouldGetNotCanonicalWithNegativeCoffee() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется напиток с отрицательным объёмом воды")
    void shouldGetNotCanonicalWithNegativeWater() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется напиток с отрицательным объёмом эспрессо и воды")
    void shouldGetNotCanonicalWithNegativeCoffeeAndWater() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется напиток с отрицательным объёмом молока")
    void shouldGetNotCanonicalWithNegativeMilk() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если проверяется напиток с отрицательным объёмом эспрессо и молока")
    void shouldGetNotCanonicalWithNegativeCoffeeAndMilk() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает false, если в результате проверки объема переполняется разрядная сетка")
    void shouldGetNotCanonicalWithIntOverflow() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает true, если передан каноничный эспрессо")
    void shouldGetCanonicalEspresso() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает true, если передан каноничный американо")
    void shouldGetCanonicalAmericano() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает true, если передан каноничный капучино")
    void shouldGetCanonicalCappuccino() {

    }

    @Test
    @DisplayName("Проверка каноничности возвращает true, если передан каноничный латте")
    void shouldGetCanonicalLatte() {

    }
}
