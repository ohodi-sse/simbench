import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; (int)Math.pow(2.0, n) <= nextInt; ++n) {}
        --n;
        System.out.println((int)Math.pow(2.0, n));
    }
}