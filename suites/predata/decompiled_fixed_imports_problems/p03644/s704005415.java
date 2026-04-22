import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final double nextDouble = new Scanner(System.in).nextDouble();
        double n = 0.0;
        for (double b = 0.0; Math.pow(2.0, b) <= nextDouble; ++b) {
            ++n;
        }
        System.out.println((int)Math.pow(2.0, n - 1.0));
    }
}