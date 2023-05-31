package MachineCodingPractice.SplitwiseApplication.Model;

import java.util.List;

public class Expense {
    private User paidBy;
    private ExpenseType expenseType;
    private List<User> sharedByUsers;
    private List<Double> shares;

    public Expense(User paidBy, ExpenseType expenseType, List<User> sharedByUsers, List<Double> shares) {
        this.paidBy = paidBy;
        this.expenseType = expenseType;
        this.sharedByUsers = sharedByUsers;
        this.shares = shares;
    }

    public User getPaidBy() {
        return paidBy;
    }


    public List<User> getSharedByUsers() {
        return sharedByUsers;
    }

    public double getShareForUser(User user) {
        for (User user1 : sharedByUsers) {
            if(user1.getUserId().equals(user.getUserId())){
                return shares.get(sharedByUsers.indexOf(user1));
            }
        }

        return 0.0;
    }

    public List<Double> getShares() {
        return shares;
    }

    public double getTotalAmount() {
        if(ExpenseType.EQUAL.equals(expenseType)){
            return shares.get(0)*sharedByUsers.size();
        }
        else if(ExpenseType.EXACT.equals(expenseType)){

            double totalAmount = 0.0;
            for(double share : shares){
                totalAmount += share;
            }
            return totalAmount;
        }
        else if(ExpenseType.PERCENT.equals(expenseType)){
            // return
            double totalAmount = 0.0;
            for(double share : shares){
                totalAmount += share;
            }
            return totalAmount;
        }
        return 0.0;
    }
}
