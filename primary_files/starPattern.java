public class starPattern {
    public static void main(String[] args) {
        for(int starCount=5; starCount>=0; starCount--){

            for(int i=0; i<=(5-starCount); i++){
                System.out.print(" ");
            }

            for(int i=0; i<=starCount; i++){
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}
