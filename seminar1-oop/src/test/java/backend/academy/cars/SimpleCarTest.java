package backend.academy.cars;

import backend.academy.simplecar.SimpleCar;
import org.junit.jupiter.api.Test;

class SimpleCarTest {
    @Test
    void name() {
        SimpleCar simpleCar = new SimpleCar("BMW", "X5", 2015, "Black");
        SimpleCar simpleCar2 = new SimpleCar("AUDI", "X6", 2015, "White");
        SimpleCar simpleCar3 = new SimpleCar("LADA", "X7", 1997, "Green");

        System.out.println(simpleCar);
        System.out.println(simpleCar2);
        System.out.println(simpleCar3);
    }
}
