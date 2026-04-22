import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final double n = scanner.nextDouble() + 0.001;
        final long n2 = (long)n;
        final double n3 = (n - n2) * 10.0;
        final long n4 = (long)n3;
        System.out.println(nextLong * (100L * n2 + 10L * n4 + (long)((n3 - n4) * 10.0)) / 100L);
    }
}