
package backend.academy.seminar2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class SampleTest {
    private static final Logger log = LogManager.getLogger(SampleTest.class);
    private static final org.slf4j.Logger log2 = LoggerFactory.getLogger(SampleTest.class);

    Predicate<String> containsLetterA = s -> s.contains("a");
    Predicate<String> containsLetterB = s -> s.contains("b");

    @Test
    void testPredicate() {
        Assertions.assertTrue(containsLetterA.and(containsLetterB).test("banana"));
    }

    public static List<Integer> function(List<String> words) {
        Function<String, Integer> stringLength = s -> s.length();

        List<Integer> lengths = new ArrayList<>();
        for (String word : words) {
            lengths.add(stringLength.apply(word));
        }
        return lengths;
    }

    @Test
    void testFunction() {
        List<String> words = List.of("apple", "banana", "cherry");
        List<Integer> expected = List.of(5, 6, 6);
        Assertions.assertEquals(expected, function(words));
    }

    public static void consumer() {
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        List<String> words = List.of("apple", "banana", "cherry");
        for (String word : words) {
            printUpperCase.accept(word);
        }
    }

    @Test
    void testConsumer() {
        consumer();
    }

    public static String supplier() {
        Supplier<String> timeOfDay = () -> {
            int hour = java.time.LocalTime.now().getHour();
            if (hour < 12) {
                return "morning";
            } else if (hour < 18) {
                return "afternoon";
            } else {
                return "evening";
            }
        };
        return timeOfDay.get();
    }

    @Test
    void testSupplier() {
        String timeOfDay = supplier();
        System.out.println(timeOfDay);
        Assertions.assertTrue(timeOfDay.equals("morning") ||
            timeOfDay.equals("afternoon") ||
            timeOfDay.equals("evening"));
    }

}




