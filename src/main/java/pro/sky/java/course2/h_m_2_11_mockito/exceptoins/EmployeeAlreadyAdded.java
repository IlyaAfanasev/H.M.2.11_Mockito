package pro.sky.java.course2.h_m_2_11_mockito.exceptoins;

public class EmployeeAlreadyAdded extends RuntimeException {

    public EmployeeAlreadyAdded() {
    }

    public EmployeeAlreadyAdded(String message) {
        super(message);
    }

    public EmployeeAlreadyAdded(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyAdded(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyAdded(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
