import java.util.Scanner;

public class income {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your income: ");
        int income = sc.nextInt();

        if(income<250000){
            System.out.println("No tax for you!!");
        }
        else if(income>250000 && income<500000){
            System.out.println("You have to pay Rs." + ((5*income)/100) + " as your income tax.");
        }
        else if(income>500000 && income<1000000){
            System.out.println("You have to pay Rs." + ((20*income)/100) + " as your income tax.");
        }
        else{
            System.out.println("You have to pay Rs." + ((30*income)/100) + " as your income tax.");
        }
    }
}
