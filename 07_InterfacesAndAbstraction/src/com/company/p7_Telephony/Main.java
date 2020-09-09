package com.company.p7_Telephony;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] phonesInput = scan.nextLine().split("\\s+");
        SmartPhone smartPhone = new SmartPhone();
        String[] websiteInput = scan.nextLine().split("\\s+");


        for (String number : phonesInput) {
            smartPhone.call(number);
        }
        for (String website : websiteInput) {
            smartPhone.browse(website);
        }
    }
}
