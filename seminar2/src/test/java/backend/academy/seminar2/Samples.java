package backend.academy.seminar2;

import java.util.Objects;
import java.util.function.Function;

public class Samples {
    /*
    Всегда возвращает одно и то же значение
    для одинаковых входных данных.
    */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     Рекурсивный вызов на примере факториала
    */
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /*
    Функциональный интерфейс
    */
    @FunctionalInterface
    public interface Calculator {
        double calculate(int a, int b);
    }

    public static void calclulate() {
        //сумма двух чисел
        Calculator sum = (a, b) -> a + b;
        System.out.println("Сумма: " + sum.calculate(5, 3));
        //произведение двух чисел
        Calculator product = (a, b) -> a * b;
        System.out.println("Произведение: " + product.calculate(5, 3));
        //длина гипотенузы по двум катетам
        Calculator hypotenuse = (a, b) -> Math.sqrt(a * a + b * b);
        System.out.println("Гипотенуза: " + hypotenuse.calculate(3, 4));
    }

    /*
        Функции, которые принимают функции в качестве аргументов
        и возвращают функции в качестве результата.
    */
    Integer[] mapFunction(Integer[] array, Function<Integer, Integer> func) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = func.apply(array[i]);
        }
        return result;
    }
    //Использование
    Integer[] array = {1, 2, 3, 4, 5};
    Integer[] result = mapFunction(array, x -> x * x); // результат [1, 4, 9, 16, 25]

    // Функция высшего порядка, которая возвращает функцию
    public static Function<Integer, Integer> powerOf(int exponent) {
        return (number) -> (int) Math.pow(number, exponent);
    }

    public static void powers() {
        // Получаем функцию, возводящую в квадрат
        Function<Integer, Integer> square = powerOf(2);

        // Получаем функцию, возводящую в куб
        Function<Integer, Integer> cube = powerOf(3);

        // Используем функции
        System.out.println("Square of 5: " + square.apply(5)); // 25
        System.out.println("Cube of 5: " + cube.apply(5));     // 125
    }

    //Создаём новую функцию комбинируя две
    public static void  combination() {
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> square = x -> x * x;

        // Комбинируем функции
        Function<Integer, Integer> incrementThenSquare = increment.andThen(square);

        // Используем комбинированную функцию
        System.out.println(incrementThenSquare.apply(3)); // 16
    }

    //Соответствие образцу
    sealed interface Shape permits Circle, Rectangle { }
    record Circle(double radius) implements Shape { }
    record Rectangle(double width, double height) implements Shape { }

    public static double getPerimeter(Shape shape) {
        return switch (shape) {
            case Circle c -> 2 * Math.PI * c.radius();
            case Rectangle r -> 2 * (r.width() + r.height());
        };
    }

    public static void main(String[] args) {
        //JEP 394: Pattern Matching for instanceof
        Object obj = "Hello, World!";
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase()); // Прведение типа уже не нужно
        }
    }
}
