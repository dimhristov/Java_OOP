package com.company.p6_Ferrari;

public class Ferrari implements Car {
    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }


    @Override
    public String getModel() {
        return MODEL;
    }

    @Override
    public String getDriver() {
        return this.driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MODEL);
        sb.append("/");
        sb.append(brakes());
        sb.append("/");
        sb.append("Zadu6avam sA!");
        sb.append("/");
        sb.append(this.driverName);
        return sb.toString();
    }
}
