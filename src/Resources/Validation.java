package Resources;

import Objects.Employee;

public abstract class Validation {

    protected final String INVALID_INPUT = "-fx-background-color: rgb(255, 0, 0)";
    protected final String VALID_INPUT = "-fx-background-color: rgb(0, 255, 0)";
    protected final String NEW_INPUT = "-fx-background-color: rgb(217, 217, 217)";

    protected String storeValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }

    protected String storeValidPhone(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]{10}?")) {
            String[] test = s.split("(?<=\\G...)");
            String phone = String.format("%s-%s-%s", test[0], test[1],
                    test[2] + "" + test[3]);
            return phone;
        }
        return null;
    }

    protected String storeValidAddress(String s) {
        if (!s.isEmpty() && s.matches("\\d{2,5}[a-zA-Z ]+"))
            return s;
        return null;
    }

    protected Employee storeValidManager(String s) {
        if (!s.isEmpty()) {
            switch (s) {

            }
        }
        return null;
    }

    protected String employeeValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }


    protected String employeeValidEmail(String s) {
        if (!s.isEmpty() && s.matches(
                "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+?"))
            return s;
        return null;
    }


    protected String employeeValidPhone(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]{10}?")) {
            String[] test = s.split("(?<=\\G...)");
            String phone = String.format("%s-%s-%s", test[0], test[1],
                    test[2] + "" + test[3]);
            return phone;
        }
        return null;
    }


    protected String productValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }

    protected double productValidPrice(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]+(\\.[0-9]{1,2})?$"))
            return Double.parseDouble(s);
        return -1;
    }

    protected int productValidAmount(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]+$"))
            return Integer.parseInt(s);
        return -1;
    }
}
