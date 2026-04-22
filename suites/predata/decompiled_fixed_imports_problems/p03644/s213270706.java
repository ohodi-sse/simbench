import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt >= 64) {
            System.out.println(64);
        }
        else if (nextInt >= 32) {
            System.out.println(32);
        }
        else if (nextInt >= 16) {
            System.out.println(16);
        }
        else if (nextInt >= 8) {
            System.out.println(8);
        }
        else if (nextInt >= 4) {
            System.out.println(4);
        }
        else if (nextInt >= 2) {
            System.out.println(2);
        }
        else {
            System.out.println(1);
        }
    }
    
    public static int sample() {
        return 1;
    }
}