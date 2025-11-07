package backend.academy.seminar9.coffee.withbugs;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Простой детектор накипи, основанный на счётчике.
 * Если счётчик достигает заданного порога {@code threshold}, требуется очистка от накипи
 */
public class DecalcDetector {

    private final AtomicInteger counter = new AtomicInteger();

    private final int threshold;

    public DecalcDetector(int threshold) {
        if (threshold <= 0) {
            throw new IllegalArgumentException("Threshold must be greater than 0");
        }

        this.threshold = threshold;
    }

    public int getCounter() {
        return counter.get();
    }

    public boolean isDecalcificationRequired() {
        return counter.get() >= threshold;
    }

    public void reset() {
        counter.set(0);
    }

    public void incrementCounter() {
        incrementCounter(1);
    }

    public void incrementCounter(int increment) {
        counter.addAndGet(increment);
    }
}
