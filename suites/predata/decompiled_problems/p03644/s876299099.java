import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; Math.pow(2.0, n + 1) <= nextInt; ++n) {}
        System.out.println((int)Math.pow(2.0, n));
    }
}