package pro.sky.java.course2.h_m_2_11_mockito.exceptoins;

public class IncorrectDepartmentException extends RuntimeException {
    public IncorrectDepartmentException() {
    }

    public IncorrectDepartmentException(String message) {
        super(message);
    }

    public IncorrectDepartmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDepartmentException(Throwable cause) {
        super(cause);
    }
}
