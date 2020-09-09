package p02_GettersAndSetters;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer,BankAccount> accounts = new HashMap<>();

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] cmdArgs = command.split("\\s+");
            String cmdType = cmdArgs[0];
            switch (cmdType) {
                case "Create":
                    execCreate(cmdArgs,accounts);
                    break;
                case "Deposit":
                    execDeposit(cmdArgs,accounts);
                    break;
                case "Withdraw":
                    execWithdraw(cmdArgs,accounts);
                    break;
                case "Print":
                    execPrint(cmdArgs,accounts);
                    break;
            }

            command = scan.nextLine();
        }
    }

    private static void execPrint(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        if (accounts.containsKey(id)) {
            System.out.println(String.format("Account %s, balance %.2f",accounts.get(id),accounts.get(id).getBalance()));
        } else {
            System.out.println("Account doesn't exist");
        }
    }

    private static void execWithdraw(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amountToWithdraw = Double.parseDouble(cmdArgs[2]);
        if (accounts.containsKey(id)) {
            accounts.get(id).withdraw(amountToWithdraw);
        } else {
            System.out.println("Account doesn't exist");
        }
    }

    private static void execDeposit(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(Double.parseDouble(cmdArgs[2]));
        } else {
            System.out.println("Account doesn't exist");
        }
    }

    private static void execCreate(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id,account);
        }
    }
}
