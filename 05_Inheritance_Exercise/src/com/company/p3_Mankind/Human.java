package com.company.p3_Mankind;

public class Human {
    private static final String EXPECTED_UPPER_CASE_LETTER_ARGUMENT_FIRST_NAME = "Expected upper case letter!Argument: firstName";
    private static final String EXPECTED_LENGTH_AT_LEAST_4_SYMBOLS_ARGUMENT_FIRST_NAME = "Expected length at least 4 symbols!Argument: firstName";
    private static final String EXPECTED_UPPER_CASE_LETTER_ARGUMENT_LAST_NAME = "Expected upper case letter!Argument: lastName";
    private static final String EXPECTED_LENGTH_AT_LEAST_3_SYMBOLS_ARGUMENT_LAST_NAME = "Expected length at least 3 symbols!Argument: lastName";
    private String firstName;
    private String lastName;



    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    protected void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException(EXPECTED_UPPER_CASE_LETTER_ARGUMENT_FIRST_NAME);
        }
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(EXPECTED_UPPER_CASE_LETTER_ARGUMENT_FIRST_NAME);
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException(EXPECTED_LENGTH_AT_LEAST_4_SYMBOLS_ARGUMENT_FIRST_NAME);
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(EXPECTED_UPPER_CASE_LETTER_ARGUMENT_LAST_NAME);
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(EXPECTED_LENGTH_AT_LEAST_3_SYMBOLS_ARGUMENT_LAST_NAME);
        }
        this.lastName = lastName;
    }
}
