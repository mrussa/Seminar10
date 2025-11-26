package backend.academy.seminar10.refactor_tasks.prime_generator;

public class Runner {

    private static final int NUMBER_OF_PRIMES = 1000;
    private static final int ROWS = 50;
    private static final int COLUMNS = 4;

    public static void main(String[] args) {
        PrimeGenerator gen = new PrimeGenerator();
//        LongStream primes = gen.generate(1000000000);

        int[] primes = gen.generate(NUMBER_OF_PRIMES);

        PrimePrinter printer = new PrimePrinter(ROWS, COLUMNS, printStream -> printStream.println("Hello world!"));
        printer.print(System.out, primes);
    }
}
