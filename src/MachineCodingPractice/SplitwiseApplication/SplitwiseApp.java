package MachineCodingPractice.SplitwiseApplication;

import MachineCodingPractice.SplitwiseApplication.Model.Expense;
import MachineCodingPractice.SplitwiseApplication.Model.ExpenseType;
import MachineCodingPractice.SplitwiseApplication.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseApp {
    private Map<String, User> userMap;
    private List<Expense> expenseList;

    public SplitwiseApp() {
        this.userMap = new HashMap<>();
        this.expenseList = new ArrayList<>();
    }


    public void addUser(String userId, String name, String email, String mobNumber) {

        User user = new User(userId, name, email, mobNumber);
        this.userMap.put(userId, user);

    }

    public void showAllBalances() {

        Map<User, Double> balances = calculateBalances();

        // Print the balances
        for (User user : balances.keySet()) {
            double balance = balances.get(user);
            System.out.println("User ID: " + user.getUserId() + ", Balance: " + balance);
        }


    }

    private Map<User, Double> calculateBalances() {
        Map<User, Double> balances = new HashMap<>();

        // Initialize balances for all users
        List<User> userList = new ArrayList<>(userMap.values());
        for (User user : userList) {
            balances.put(user, 0.0);
        }
        // Calculate balances for all expenses
        for (Expense expense : expenseList) {
            User paidBy = expense.getPaidBy();
            double totalAmount = expense.getTotalAmount();
            List<User> sharedByUsers = expense.getSharedByUsers();
            List<Double> shares = expense.getShares();

            // Calculate the share for each user
            for (int i = 0; i < sharedByUsers.size(); i++) {
                User user = sharedByUsers.get(i);
                double share = shares.get(i);

                // Update the balance for each user
                balances.put(user, balances.get(user) + share);
            }
            // Deduct the total amount from the user who paid
            balances.put(paidBy, balances.get(paidBy) - totalAmount);
        }

        return balances;

    }

    public void showUserBalances(String userId) {
        Map<User, Double> balances = calculateBalances();

        // Print the balances for the specified user
        System.out.println("Balances for User ID: " + userId);
        for (User user : balances.keySet()) {
            double balance = balances.get(user);
            if (balance != 0.0 && user.getUserId().equals(userId)) {
                System.out.println("User ID: " + user.getUserId() + ", Balance: " + balance);
            }
        }

    }

    public void addExpense(String paidByUserId, List<String> listOfUserId, List<Double> shareOfUsers, ExpenseType expenseType) {

        User paidBy = userMap.get(paidByUserId);
        if (paidBy == null) {
            System.out.println("Invalid user ID. Expense not added.");
            return;
        }

        List<User> sharedByUsers = new ArrayList<>();
        for (String userId : listOfUserId) {
            User user = userMap.get(userId);
            if (user == null) {
                System.out.println("Invalid user ID. Expense not added.");
                return;
            }
            sharedByUsers.add(user);
        }

        Expense expense = new Expense(paidBy,expenseType, sharedByUsers, shareOfUsers);

        expenseList.add(expense);
    }
}
