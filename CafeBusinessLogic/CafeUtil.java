import java.util.ArrayList;

public class CafeUtil{
    
    int getStreakGoal(int numWeeks){
        int total = 0;
        for(int i = 1; i < numWeeks + 1; i++){
            total += i;
        }
        return total;
    }

    double getOrderTotal(double[]lineItems){
        double total = 0;
        for(int i = 0; i < lineItems.length; i++){
            total += lineItems[i];
        }
        return total;
    }

    void displayMenu(ArrayList<String> menu){
        // menu.forEach(System.out::println);
        for(int i = 0; i < menu.size(); i++){
            System.out.println(i +" " + menu.get(i));
        }
    }

    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName);
        System.out.println("There are " + customers.size() + " in front of you");
        customers.add(userName);
        System.out.print(customers);
    }

}