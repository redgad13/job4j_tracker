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
        if (!PasswordValidator.hasSpecial(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (PasswordValidator.tooEasy(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

    public static boolean hasDigits(String password) {
        boolean isDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                isDigit = true;
                break;
            }
        }
        return isDigit;
    }

    public static boolean hasSpecial(String password) {
        boolean isSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                isSpecial = true;
                break;
            }
        }
        return isSpecial;
    }

    public static boolean tooEasy(String password) {
        boolean isEasy = false;
        String[] invalid = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String s : invalid) {
            if (password.toLowerCase().contains(s)) {
                isEasy = true;
                break;
            }
        }
        return isEasy;
    }

}
