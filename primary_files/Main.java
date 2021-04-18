import java.util.Scanner; // import the user input class


class Main{
    public static void main(String[] args) {
        // setup the scanner
        Scanner sc = new Scanner(System.in);

        // collect student name
        System.out.println("What is your name?");
        String name = sc.nextLine();

        // collect student grade
        System.out.println("In which grade do you currently study?");
        int grade = sc.nextInt();

        // tell the student how to introduce 
        Student roll1 = new Student(name, grade);
        roll1.introduce();
    }
}
