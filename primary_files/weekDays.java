import java.util.Scanner;

public class weekDays {
    public static void main(String[] args) {
        // take the number input from the user
        Scanner sc = new Scanner(System.in);
        int num;
        // System.out.println("Executed");
        System.out.print("Enter the number which corresponds to the week day: ");
        num = sc.nextInt();

        switch(num){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default: 
                System.out.println("Please type a valid number");
                break;
        }
    }
}
