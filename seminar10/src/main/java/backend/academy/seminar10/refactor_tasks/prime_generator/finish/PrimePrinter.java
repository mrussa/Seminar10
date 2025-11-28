package backend.academy.seminar10.refactor_tasks.prime_generator;

import java.io.PrintStream;
import java.util.function.Consumer;

public class PrimePrinter {
    private final int rows;
    private final int columns;

    private Consumer<PrintStream> footerDecorator = this::decorateFooter;

    public PrimePrinter(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public PrimePrinter(int rows, int columns, Consumer<PrintStream> footerDecorator) {
        this(rows, columns);
        this.footerDecorator = footerDecorator;
    }

    void print(PrintStream inputStream, int[] primes) {
        int pagenumber = 1;
        int pageOffset = 0;

        while (pageOffset < primes.length) {
            decorateHeader(inputStream, primes, pagenumber);

            printPage(inputStream, primes, pageOffset);

            footerDecorator.accept(inputStream);

            pagenumber++;
            pageOffset += rows * columns;
        }
    }

    private void printPage(PrintStream inputStream, int[] primes, int pageOffset) {
        for (int rowOffset = pageOffset; rowOffset < pageOffset + rows; rowOffset++) {
            if (rowOffset >= primes.length) {
                break;
            }
            printRow(inputStream, primes, rowOffset);
        }
    }

    private void printRow(PrintStream inputStream, int[] primes, int rowOffset) {
        for (int column = 0; column < columns; column++) {
            int index = rowOffset + column * rows;
            if (index >= primes.length) {
                break;
            }
            inputStream.printf("%10d", primes[index]);
        }
        inputStream.println();
    }

    private void decorateFooter(PrintStream inputStream) {
        inputStream.println('\f');
    }

    public void decorateHeader(PrintStream inputStream, int[] primes, int pageNumber) {
        inputStream.print("The First ");
        inputStream.print(primes.length);
        inputStream.print(" Prime Numbers === Page ");
        inputStream.print(pageNumber);
        inputStream.println("\n");
    }
}
