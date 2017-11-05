
package assignment6;
import java.util.ArrayList;
import java.util.*;


class userData {
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;
    private String password;
    private double balance;
    private ArrayList<String> transactions;

    public userData(String bankAccountNumber, String password) {

    }

    public userData(String name, String age, String address, String phoneNumber, String password, String bankAccountNumber, Double balance, ArrayList<String> transactions) {
        setName(name);
        setAge(age);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setBankAccountNumber(bankAccountNumber);
        setBalance(balance);
        setTransactions(transactions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(String transaction) {
        getTransactions().add(transaction);
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }
}

    public class ATM {
            double availableAmountInMachine;
            double transactionFee;
            ArrayList<userData> userdata;

            ATM(){}
            ATM(double availableAmountInMachine, double transactionFee) {
                userdata= new ArrayList<>();
                this.availableAmountInMachine = availableAmountInMachine;
                this.transactionFee = transactionFee;
            }

        void createNewUser(String bankAccountNumber, String password) {
            userdata.add(new userData(bankAccountNumber, password));
        }


        boolean login(String bankAccountNumber, String password) {
            for (userData u : userdata) {
                if (u.getBankAccountNumber().equals(bankAccountNumber)) {
                    if (u.getPassword().equals(password)) {
                        return true;
                    } else { return false; }
                }
            }
            return false;
            }
        boolean verifyIdentity(String name, int age, String phoneNumber) {
            for (userData u : userdata) {
                if (u.getName().equals(name)&& u.getAge().equals(age)
                        && u.getPhoneNumber().equals(phoneNumber)) {
                     {
                        return true;
                    }
                }
            }

            System.out.println("Verify failed");
            return false;

        }

        void changePassword(String bankAccountNumber, String newPassword) {
            for (userData u : userdata) {
                if (u.getBankAccountNumber().equals(bankAccountNumber)) {
                    u.setPassword(newPassword);
                    System.out.println("Change completed");
                    return;
                }
            }

        }

        double Balance(String bankAccountNumber) {
            for (userData u : userdata) {
                if (u.getBankAccountNumber().equals(bankAccountNumber)) {
                    return u.getBalance();
                }
            }

            return 0;
        }


        List<String> recentTransactions(String bankAccountNumber) {
            List<String> res = new ArrayList<>();
            for (userData u : userdata) {
                if (u.getBankAccountNumber().equals(bankAccountNumber)) {
                    if (u.getTransactions().size() >= 10) {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(u.getTransactions().get(u.getTransactions().size() - 1 - i));
                        }
                    } else {
                        for (int i = u.getTransactions().size() - 1; i >= 0; i--) {
                            System.out.println(u.getTransactions().get(i));
                        }
                    }

                    res = u.getTransactions();
                    return res;
                }
            }

            return res;
        }



        public void start() {
                System.out.println("new user, enter 1" + "current user, enter 2");
                Scanner reader = new Scanner(System.in);

                while (true) {
                    String str = reader.next();
                    if (str.equals("1")) {
                        System.out.println("Please enter your bank account number:");
                        String bankAccountNumber = reader.next();
                        System.out.println("Please enter your password:");
                        String password = reader.next();
                        createNewUser(bankAccountNumber, password);
                        break;
                    } else if (str.equals("2")) {
                        while (true) {
                            System.out.println("Do you forget your password ? Enter Yes or No");
                            String answer = reader.next();
                            if (answer.equals("No")) {
                                while (true) {
                                    System.out.println("Please enter your bank account number:");
                                    String phoneNumber = reader.next();
                                    System.out.println("Please enter your password:");
                                    String password = reader.next();
                                    if (login(phoneNumber, password)) {
                                        System.out.println("Login successful!");
                                        function(reader, phoneNumber);
                                        break;
                                    } else {
                                        System.out.println("Login failed.");
                                        while (true) {
                                            System.out.println("Do you want to login again? " + "Enter " +
                                                    "\"Yes\" or \"No\"");
                                            String answer1 = reader.next();
                                            if (answer1.toLowerCase().equals("yes")) {
                                                break;
                                            } else if (answer1.toLowerCase().equals("no")) {
                                                return;
                                            } else {
                                                System.out.println("What you enter is invalid, please enter again.");
                                            }
                                        }
                                    }
                                }

                                break;
                            } else if (answer.equals("Yes")) {

                                System.out.println("We should verify your information to help you reset "
                                        + "the password.");
                                while (true) {
                                    System.out.println("Please enter your name:");
                                    String name = reader.next();
                                    System.out.println("Please enter your age:");
                                    String age = reader.next();
                                    System.out.println("Please enter your phone number:");
                                    String phoneNumber = reader.next();

                                    if (verifyIdentity(name, Integer.parseInt(age), phoneNumber)) {
                                        System.out.println("Tell me your new password ");
                                        String newPassword = reader.next();
                                        changePassword(phoneNumber, newPassword);
                                        break;
                                    } else {
                                        System.out.println("Reset failed.");
                                        while (true) {
                                            System.out.println("Do you want to reset password again? "
                                                    + "Enter " + "\"Yes\" or \"No\"");
                                            String answer1 = reader.next();
                                            if (answer1.equals("Yes")) {
                                                break;
                                            } else if (answer1.equals("No")) {
                                                return;
                                            } else {
                                                System.out.println("What you enter is invalid, please enter again.");
                                            }
                                        }
                                    }
                                }
                                break;
                            } else {
                                System.out.println("What you enter is invalid");
                            }
                        }
                        break;
                    } else {
                        System.out.println("What you enter is invalid, please enter again.");
                    }
                }

            }

            private void function(Scanner reader, String phoneNumber) {
                System.out.println("Choose a option with its number");
                System.out.println("1: Available Balance");
                System.out.println("2: Recent Transactions");
                System.out.println("3: Change Password");
                System.out.println("4: Exit");

                String option = null;
                while (true) {
                    while (true) {
                        option = reader.next();
                        if (option.matches("[0-4]")) {
                            switch (Integer.parseInt(option)) {
                                case 1:
                                    System.out.println("Balance: " + Balance(phoneNumber));
                                    break;
                                case 2:
                                    recentTransactions(phoneNumber);
                                    break;
                                case 3:
                                    System.out.println("Tell me your new password");
                                    String newPassword = reader.next();
                                    changePassword(phoneNumber, newPassword);
                                    break;
                                case 4:
                                    return;
                            }
                            break;
                        } else {
                            System.out.println("Please enter the number between 1 to 6");
                        }
                    }

                    System.out.println("What else do you want to do?");
                }


            }



        }
        class main {


            public static void main(String[] args) {
                ATM a = new ATM();

                a.start();
            }
        }




