import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        if (64 <= nextInt) {
            System.out.println(64);
        }
        else if (32 <= nextInt) {
            System.out.println(32);
        }
        else if (16 <= nextInt) {
            System.out.println(16);
        }
        else if (8 <= nextInt) {
            System.out.println(8);
        }
        else if (4 <= nextInt) {
            System.out.println(4);
        }
        else if (2 <= nextInt) {
            System.out.println(2);
        }
        else {
            System.out.println(1);
        }
    }
}