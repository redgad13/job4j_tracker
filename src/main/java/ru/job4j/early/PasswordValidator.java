package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!PasswordValidator.hasDigits(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        return password;
    }

    public static boolean hasDigits(String password) {
        boolean hasDigits = false;
        for (int i = 0; i < password.length() && !hasDigits; i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigits = true;
            }
        }
        return hasDigits;
    }
}
