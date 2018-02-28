package exceptionresource.accesscontrol;

public class LogException extends RuntimeException{
   private String exception;
    public LogException() {
    }

    public LogException(String exception) {
        this.exception = exception;
    }
}
