package com.company.p3_Mankind;

public class Worker extends Human {
    private static final int WORKING_DAYS_PER_WEEK = 7;
    private static final String EXPECTED_VALUE_MISMATCH_ARGUMENT_WEEK_SALARY = "Expected value mismatch!Argument: weekSalary";
    private static final String EXPECTED_VALUE_MISMATCH_ARGUMENT_WORK_HOURS_PER_DAY = "Expected value mismatch!Argument: workHoursPerDay";
    private static final String EXPECTED_LENGTH_MORE_THAN_3_SYMBOLS_ARGUMENT_LAST_NAME = "Expected length more than 3 symbols!Argument: lastName";
    private static final String EXPECTED_LENGTH_MORE_THAN_3_SYMBOLS_ARGUMENT_FIRST_NAME = "Expected length more than 3 symbols!Argument: firstName";

    private double weekSalary;
    private double hoursPerDay;


    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException(EXPECTED_VALUE_MISMATCH_ARGUMENT_WEEK_SALARY);
        }
        this.weekSalary = weekSalary;
    }

    private void setHoursPerDay(double hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12) {
            throw new IllegalArgumentException(EXPECTED_VALUE_MISMATCH_ARGUMENT_WORK_HOURS_PER_DAY);
        }
        this.hoursPerDay = hoursPerDay;
    }

    private double salaryPerHour() {
        return this.weekSalary / (this.hoursPerDay * WORKING_DAYS_PER_WEEK);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException(EXPECTED_LENGTH_MORE_THAN_3_SYMBOLS_ARGUMENT_LAST_NAME);
        }
        super.setLastName(lastName);
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    public double getHoursPerDay() {
        return this.hoursPerDay;
    }

    @Override
    protected void setFirstName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(EXPECTED_LENGTH_MORE_THAN_3_SYMBOLS_ARGUMENT_FIRST_NAME);
        }
        super.setFirstName(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s", super.getFirstName()))
                .append(System.lineSeparator())
                .append(String.format("Last name: %s", super.getLastName()))
                .append(System.lineSeparator())
                .append(String.format("Week salary: %.2f", this.weekSalary))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.hoursPerDay))
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", salaryPerHour()));
        return sb.toString();
    }
}
