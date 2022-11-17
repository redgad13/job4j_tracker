package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error activeness is " + active + ", error's status equals "
                + status + ", message is " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error2 = new Error(true, 2, "Error occured");
        error2.printInfo();
        Error error3 = new Error(false, 0, "This is fine");
        error3.printInfo();
    }
}
