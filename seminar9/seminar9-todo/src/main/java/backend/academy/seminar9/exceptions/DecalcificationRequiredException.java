package backend.academy.seminar9.exceptions;

public class DecalcificationRequiredException extends RuntimeException {

    public DecalcificationRequiredException() {
        super("Decalcification is required, please perform maintenance of the coffee machine");
    }
}
