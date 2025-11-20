package backend.academy.seminar11.thread;

import backend.academy.seminar11.utils.ThreadUtils;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Log4j2
public class ThreadCreationTest {

    @Test
    @SneakyThrows
    @DisplayName("Олдскульный вариант создания потоков")
    void test0() {
        var tickThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                log.info("Tick!");
                ThreadUtils.sleepSafe(1_000);
            }
            log.info("Tuck!");
        });

        // ...

        tickThread.start();

        Thread.sleep(3_000);
        tickThread.interrupt(); // Note: посмотрим чуть позже в рамках ThreadInterruptionTest
        tickThread.join(); // Note: рассказать, что это и для чего нужно
    }

    @Test
    @SneakyThrows
    @DisplayName("Молодежный вариант создания потоков")
    void test1() {
        var thread = Thread.ofPlatform()
            .name("platform-thread")
            .daemon(false)
            .start(() -> greetTheWorld(1_000));

        // will die, when JVM dies
        var daemon = Thread.ofPlatform()
            .name("daemon-thread")
            .daemon()
            .start(() -> greetTheWorld(2_000));

        // virtual thread - Project Loom
        var virtual = Thread.ofVirtual()
            .name("virtual-thread")
            .start(() -> greetTheWorld(3_000));

        Thread.sleep(5_000);

        thread.interrupt();
        daemon.interrupt();
        virtual.interrupt();

        thread.join();
        daemon.join();
        virtual.join();
    }

    private static void greetTheWorld(long sleepMs) {
        while (!Thread.currentThread().isInterrupted()) {
            log.info("Hello, world, from {}", Thread.currentThread().getName());
            ThreadUtils.sleepSafe(sleepMs);
        }
        log.info("Goodbye from {}", Thread.currentThread().getName());
    }

}
