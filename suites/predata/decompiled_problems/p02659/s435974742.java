import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        System.out.println((nextLong * ((next.charAt(0) - '0') * 100) + nextLong * ((next.charAt(2) - '0') * 10) + nextLong * (next.charAt(3) - '0')) / 100L);
    }
}