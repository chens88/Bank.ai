import java.util.Scanner;

public class Bank {
    public Account[] accounts = new Account[10];
    public int accountCounter = 1;

    public Bank() {
        User newUser1 = new User("John", "Doe", "01.01.1991", "000-00-0000", "123 Sesame Street", "johndoe@gmail.com", "333-5558888");
        User newUser2 = new User("Mary", "Jane", "02.02.2002", "101-00-1001", "101 Main Street", "mj123@yahoo.com", "666-7779999");
        accounts[0] = new Account(newUser1, "Dojo1991", "1234", (double) 100.00);
        accounts[1] = new Account(newUser2, "Jama2002", "1111", (double) 2000.00);
    }

    public void startScreen() {
        System.out.println("Welcome to Bank.ai");
        System.out.print("Make a selection: \n 1. Log in [Enter 1] \n 2. Open new account [Enter 2] \n Your selection: ");
        Scanner scanner = new Scanner(System.in);
        int userSel = scanner.nextInt();
        if (userSel == 1) {
            login();
        } else if (userSel == 2) {
            openAccount();
        } else {
            System.out.println("Invalid entry. Exiting program... ");
        }
    }

    public void login() {
        System.out.println("Log in");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        boolean accountFound = true;

        for (int i = 0; i < accounts.length; ++i) {
            if (accountNumber.equals(accounts[i].getAccountNumber())) {
                for (int j = 0; j < 3; ++j) {
                    System.out.print("Enter your pin: ");
                    String pin = scanner.nextLine();
                    if (pin.equals(accounts[i].getPin())) {
                        menu(accounts[i]);

                    }
                    System.out.println("Invalid pin. Try again: ");
                }
                System.out.println("Log in unsuccessful after 3 wrong pin attempts. Exiting program... ");

            }
        }
        if (!accountFound) {
            System.out.println("Account not found. Please check your account number and try again.");
        }
    }

    public void menu(Account currentAccount) {
        System.out.println("Menu");
        System.out.println("1. View Balance \n 2. Deposit \n 3. Withdraw \n 4. Withdraw all & close account \n 5. Logout \n Your selection: ");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        if (selection == 1) {
            viewBalance(currentAccount);
        } else if (selection == 2) {
            deposit(currentAccount);
        } else if (selection == 3) {
            withdraw(currentAccount);
        } else if (selection == 4) {
            withdrawAll(currentAccount);
            closeAccount(currentAccount);
        }
    }

    public void openAccount() {
        System.out.println("New Account");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your DOB [MM/DD/YYYY]: ");
        String dob = scanner.nextLine();
        System.out.println("Enter your SSN: ");
        String ssn = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your telephone: ");
        String tel = scanner.nextLine();
        System.out.println("Enter your pin: ");
        String pin = scanner.nextLine();
        System.out.println("Initial deposit: $");
        double initialDep = scanner.nextDouble();
        User newUser = new User(firstName, lastName, dob, ssn, email, tel, pin);
        String newAccountNum = lastName.substring(0, 2) + firstName.substring(0, 2) + dob.substring(6);
        System.out.println("Account successfully created. Your account number is " + newAccountNum);
        Account accountCreated = new Account(newUser, newAccountNum, pin, initialDep);
        ++accountCounter;
        accounts[accountCounter - 1] = accountCreated;
        this.startScreen();
    }

    public void viewBalance(Account currentAccount) {
        System.out.println("Your balance is $" + currentAccount.getBalance());
        System.out.println("Would you like to do anything else? ");
        System.out.println("1. Deposit \n 2. Withdraw \n 3. Withdraw all & close account \n 4. Logout \n Your selection: ");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        if (selection == 1) {
            deposit(currentAccount);
        } else if (selection == 2) {
            withdraw(currentAccount);
        } else if (selection == 3) {
            withdrawAll(currentAccount);
            closeAccount(currentAccount);
        } else if (selection == 4) {
            System.out.println("Successfully Logged Out");
            System.exit(0);
        }
    }

    public void deposit(Account currentAccount) {
        System.out.println("How much would you like to deposit? ");
        Scanner scanner = new Scanner(System.in);
        double depAmount = scanner.nextDouble();
        System.out.println("Deposit Successful. Your current balance is " + currentAccount.deposit(depAmount));
        System.out.println("Would you like to do anything else? ");
        System.out.println("1. View Balance \n 2. Withdraw \n 3. Withdraw all & close account \n 4. Logout \n Your selection: ");
        int selection = scanner.nextInt();
        if (selection == 1) {
            viewBalance(currentAccount);
        } else if (selection == 2) {
            withdraw(currentAccount);
        } else if (selection == 3) {
            withdrawAll(currentAccount);
            closeAccount(currentAccount);
        } else if (selection == 4) {
            System.out.println("Successfully Logged Out");
            System.exit(0);
        }
    }

    public void withdraw(Account currentAccount) {
        System.out.println("How much would you like to withdraw? ");
        Scanner scanner = new Scanner(System.in);
        double withdrawAmount = scanner.nextDouble();
        boolean isSuccessful = currentAccount.withdraw(withdrawAmount);
        if (isSuccessful) {
            System.out.println("Withdrawal Successful. Your current balance is " + currentAccount.getBalance());
        } else {
            System.out.println("You do not have enough money for your withdrawal amount. ");
        }
        System.out.println("Would you like to do anything else? ");
        System.out.println("1. View Balance \n 2. Deposit \n 3. Withdraw all & close account \n 4. Logout \n Your selection: ");
        int selection = scanner.nextInt();
        if (selection == 1) {
            viewBalance(currentAccount);
        } else if (selection == 2) {
            deposit(currentAccount);
        } else if (selection == 3) {
            withdrawAll(currentAccount);
            closeAccount(currentAccount);
        } else if (selection == 4) {
            System.out.println("Successfully Logged Out");
            System.exit(0);
        }
    }

    public void withdrawAll(Account current) {
        double total = current.getBalance();
        if(total > 0){
            current.withdraw(total);
            System.out.println("The total amount of $" + total + " has been withdrawn from your account. ");
        }else{
            System.out.println("You do not have enough money for your withdrawal amount. ");
        }
       // System.out.println("Withdrawing total amount of $ " + current.withdraw(current.getBalance()));
    }

    public void closeAccount(Account current) {
        boolean found = false;
        for (int i = 0; i < accounts.length; ++i) {
            if (accounts[i] != null && accounts[i].getAccountNumber().equals(current.getAccountNumber())) {
                for (int j = i; j < accounts.length - 1; ++j) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[accounts.length - 1] = null;
                System.out.println("Account successfully closed. ");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found. Unable to close.");
        }
    System.exit(0);
    }
}
