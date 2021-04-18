import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = sc.nextInt();

        for(int i=1; i<=10; i++){
            System.out.println((num + " multiplied by " + i + " is " + (num*i)));
        }
    }
    
}
