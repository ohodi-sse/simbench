import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        System.out.println((0L + nextLong * Long.valueOf(next.substring(0, 1)) * 100L + nextLong * Long.valueOf(next.substring(2, 3)) * 10L + nextLong * Long.valueOf(next.substring(3, 4))) / 100L);
        scanner.close();
    }
}