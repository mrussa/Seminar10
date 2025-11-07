package backend.academy.seminar11.utils;

import lombok.experimental.UtilityClass;


@UtilityClass
public class ThreadUtils {

    public static void sleepSafe(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
