package com.company.p3_Mankind;

public class Student extends Human {
    private static final String INVALID_FACULTY_NUMBER = "Invalid faculty number!";
    private String facultyNumber;


    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    protected String getFacultyNumber() {
        return this.facultyNumber;
    }


    protected void setFacultyNumber(String facultyNumber) {
        if (facultyNumber == null) {
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER);
        }
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10 ) {
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER);
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s", super.getFirstName()))
                .append(System.lineSeparator())
                .append(String.format("Last name: %s", super.getLastName()))
                .append(System.lineSeparator())
                .append(String.format("Faculty number: %s", this.facultyNumber));
        return sb.toString();
    }
}
