package com.company.p7_Telephony;

public class SmartPhone implements Browsable, Callable {



    @Override
    public void browse(String website) {
        if (website.matches("\\d")) {
            throw new IllegalArgumentException("Invalid URL!");
        } else {
            System.out.println(String.format("Browsing: %s",website));
        }
    }



    @Override
    public void call(String number) {
        if (number.matches("\\w")) {
            throw new IllegalArgumentException("Invalid number!");
        } else {
            System.out.println(String.format("Calling... %s",number));
        }
    }
}
