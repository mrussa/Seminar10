package backend.academy.seminar12.thread;

import backend.academy.seminar12.utils.ThreadUtils;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Log4j2
public class ThreadTerminationTest {

    @Test
    @SneakyThrows
    @DisplayName("Нормальное завершение работы потока")
    void test0() {
        var tickThread = new Thread(() -> {
            var ticks = 5;
            while (ticks-- > 0) {
                log.info("Tick!");
                ThreadUtils.sleepSafe(1_000);
            }
            log.info("Tuck!");
        });

        tickThread.start();
        tickThread.join();
        assertEquals(Thread.State.TERMINATED, tickThread.getState());
    }

    @Test
    @SneakyThrows
    @DisplayName("Завершение работы потока из-за исключения")
    void test1() {
        var tickThread = new Thread(() -> {
            var ticks = 5;
            while (true) {
                log.info("Tick!");
                if (ticks-- <= 0) {
                    throw new IllegalStateException("Too many ticks for today!");
                }
                ThreadUtils.sleepSafe(1_000);
            }
        });

        tickThread.start();
        tickThread.join();
        assertEquals(Thread.State.TERMINATED, tickThread.getState());
    }

    @Test
    @SneakyThrows
    @DisplayName("Завершение работы потока из-за прерывания")
    void test2() {
        var tickThread = new Thread(() -> {
            while (true) {
                log.info("Tick!");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    // InterruptedException в любом случае надо обработать,
                    // тут мы его просто прокидываем в виде RuntimeException
                    throw new RuntimeException(e);
                }
            }
        });

        tickThread.start();
        Thread.sleep(3_000);

        tickThread.interrupt();
        tickThread.join();
        assertEquals(Thread.State.TERMINATED, tickThread.getState());
    }

    @Test
    @SneakyThrows
    @DisplayName("Кастомная обработка ошибок")
    void test3() {
        var tickThread = Thread.ofPlatform()
            .uncaughtExceptionHandler((thread, exception) ->
                log.error(
                    "Thread {} finished with error. Its current state is: {}.",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getState(),
                    exception))
            .start(() -> {
                while (true) {
                    log.info("Tick!");
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        // InterruptedException в любом случае надо обработать,
                        // тут мы его просто прокидываем в виде RuntimeException
                        throw new RuntimeException(e);
                    }
                }
            });

        Thread.sleep(3_000);

        tickThread.interrupt();
        tickThread.join();
        assertEquals(Thread.State.TERMINATED, tickThread.getState());
    }

}
