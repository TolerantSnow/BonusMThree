import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Which number should we stop at? ");

        int num = input.nextInt();
        int total = 0;

        for(int i=0; i <= num; i++) { //up to n, inclusive
            if(i % 3 == 0) {
                total += i;
            }
            if(i % 5 == 0) {
                total += i;
            }
        }
        System.out.printf("Total sum: %d", total);
    }
}
