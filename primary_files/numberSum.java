import java.util.Scanner;

public class numberSum {
    public static void main(String[] args) {
        int sum=0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        for(int i=0; i<=n*2; i+=2){
            sum += i;
        }

        System.out.println(sum);
        

    }
}
