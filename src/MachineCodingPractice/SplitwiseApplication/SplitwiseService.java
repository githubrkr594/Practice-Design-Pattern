package MachineCodingPractice.SplitwiseApplication;

import MachineCodingPractice.SplitwiseApplication.Model.ActionType;
import MachineCodingPractice.SplitwiseApplication.Model.ExpenseType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseService {

    public static void main(String[] args) {
        System.out.println("Creating few users...");

        SplitwiseApp splitwiseApp = new SplitwiseApp();

        splitwiseApp.addUser("userId1","USER1", "user1@email.com", "902455301");
        splitwiseApp.addUser("userId2","USER2", "user2@email.com" , "902455304");
        splitwiseApp.addUser("userId3","USER3", "SplittingService@email.com" , "903455304");

        System.out.println("User created !!");

        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            String[] strings = input.split(" ");

            ActionType actionType = ActionType.valueOf(strings[0]);

            switch (actionType) {
                case SHOW:
                    if(strings.length==1){
                        splitwiseApp.showAllBalances();
                    }else
                    {
                        String userId = strings[1];
                        splitwiseApp.showUserBalances(userId);
                    }
                    break;

                case EXPENSE:
                    calculateAllExpenses(strings,splitwiseApp);
                    break;

                default:
                    scanner.close();
                    System.exit(0);
                    break;

            }


        }


    }

    private static void calculateAllExpenses(String[] input, SplitwiseApp splitwiseApp) {

        String paidBy = input[1];
        int numOfUser = Integer.parseInt(input[2]);

        List<String> listOfUserId = new ArrayList<>();

        for(int i=0;i<numOfUser; i++){
            String userId = input[3+i];
        }

        ExpenseType expenseType = ExpenseType.valueOf(input[3+numOfUser].toUpperCase());

        List<Double> shareOfUsers = new ArrayList<>();

        if(ExpenseType.EQUAL.equals(expenseType) || ExpenseType.EXACT.equals(expenseType)){
            for(int i=numOfUser; i<numOfUser; i++){
                shareOfUsers.add(Double.parseDouble(input[4+i]));
            }
        }
        else if(ExpenseType.PERCENT.equals(expenseType)){
            double totalPercentage = 0.0;
            for(int i= numOfUser;i<numOfUser;i++){
               double percentage=Double.parseDouble(input[4+i]);
               totalPercentage+=percentage;
               shareOfUsers.add(percentage);
            }

            if(totalPercentage != 100.0){
                System.out.println("Invalid Percentage Share of User....Total percentage must be 100");
                return;
            }

            splitwiseApp.addExpense(paidBy, listOfUserId,shareOfUsers, expenseType );
        }





    }
}
