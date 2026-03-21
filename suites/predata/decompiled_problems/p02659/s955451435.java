import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        System.out.println(nextLong * Integer.parseInt(next.substring(0, 1) + next.substring(2, 4)) / 100L);
    }
}