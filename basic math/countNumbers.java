import java.util.Scanner;

public class countNumbers {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("Count: " + count1(n));

        sc.close();

    }   

    public static int count1(int n){
        int count = 1;
        
        while (n > 0) {
            count++;
            n = n/10;
        }
        return count;
    }
}