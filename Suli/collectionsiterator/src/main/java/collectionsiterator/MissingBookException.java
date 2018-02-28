package collectionsiterator;

public class MissingBookException extends RuntimeException {
    private String message;

    public MissingBookException(String message) {
     super(message);
    }
}
