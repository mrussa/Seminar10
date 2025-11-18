package backend.academy.seminar9.coffee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecalcDetectorTest {

    @Test
    @DisplayName("Счётчик детектора корректно инкрементируется на 1")
    void shouldIncrementCounter() {

    }

    @Test
    @DisplayName("Счётчик детектора корректно инкрементируется на произвольное значение")
    void shouldIncrementCounterBySpecifiedValue() {

    }

    @Test
    @DisplayName("Выбрасывается IllegalArgumentException, если запрошен инкремент на отрицательное значение")
    void shouldNotIncrementCounterByNegativeValue() {

    }

    @Test
    @DisplayName("Счётчик детектора корректно обнуляется")
    void shouldResetCounter() {

    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("Выбрасывается IllegalArgumentException при создании детектора с отрицательным или нулевым предельным значением счётчика")
    void shouldNotCreateDetectorWithThresholdLessThanZero(int threshold) {

    }

    @Test
    @DisplayName("Детектор возвращает false при проверке декальцинации, если счётчик не достиг предельного значения")
    void shouldNotRequireDecalcificationBeforeThreshold() {

    }

    @Test
    @DisplayName("Детектор возвращает true при проверке декальцинации, если счётчик достиг предельного значения")
    void shouldRequireDecalcificationAfterThreshold() {

    }

    @Test
    @DisplayName("Детектор возвращает true при проверке декальцинации, если после инкремента произошло переполнение разрядной сетки счётчика")
    void shouldHandleCounterWithIntegerOverflow() {

    }
}
