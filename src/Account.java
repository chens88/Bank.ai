public class Account {
    public User user;
    public String accountNumber;
    public String pin;
    public double balance;

    public Account(User newUser, String newAcctNumber, String newPin, double initialDeposit) {
        this.user = newUser;
        this.accountNumber = newAcctNumber;
        this.pin = newPin;
        this.balance = initialDeposit;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(String newFirstName, String newLastName, String newDob, String newSSn, String newAddress, String newEmail, String newTel) {
        this.user = new User(newFirstName, newLastName, newDob, newSSn, newAddress, newEmail, newTel);
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String newPin) {
        this.pin = newPin;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double deposit(double amount) {
        double interest = amount * 0.002;
        this.balance += amount + interest;
        return this.balance;
    }

    public boolean withdraw(double amount) {
        double fee = amount * 0.02;
        double totalDeducted = amount + fee;
        if (totalDeducted <= this.balance) {
            this.balance -= totalDeducted;
            return true;
        } else {
            return false;
        }
    }
}

