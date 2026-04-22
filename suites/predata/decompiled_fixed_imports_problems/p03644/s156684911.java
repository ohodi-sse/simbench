import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int i = new Scanner(System.in).nextInt();
        int n = 1;
        int x = 1;
        while (i >= n) {
            x = n;
            n *= 2;
        }
        System.out.println(x);
    }
}