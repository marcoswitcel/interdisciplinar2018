package exceptions;
/**
 * @author joaomarcos
 * Exceção criada para ser usada como exceção padrão.
 */

public class AppException extends Exception {
    AppException(String message) {
        super(message);
    }
    AppException(String message, Exception exception) {
        super(message, exception);
    }
}
