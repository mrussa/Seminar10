package backend.academy.seminar2;

public class DatabaseReader implements Runnable{
    private final DatabaseServise databaseServise;

    public DatabaseReader(DatabaseServise databaseServise) {
        this.databaseServise = databaseServise;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= databaseServise.getBatch(); i++) {
                System.out.println(databaseServise.readData());
            }
            System.out.println("Чтение завершено.");
        }
        catch (Exception e) {
            System.out.println("Чтение прервано.");
        }
    }
}
