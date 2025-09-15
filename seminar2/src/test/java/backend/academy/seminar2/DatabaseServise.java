package backend.academy.seminar2;

import java.util.concurrent.ThreadLocalRandom;

public class DatabaseServise {
    public String readData() {
        System.out.println("Reading data from database");
        return null;
    }

    public int getBatch() {
        System.out.println("Writing data to database");
        return ThreadLocalRandom.current().nextInt(100);
    }
}
