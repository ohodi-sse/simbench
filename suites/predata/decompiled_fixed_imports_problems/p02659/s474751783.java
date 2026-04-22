import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        System.out.println(nextLong * (Integer.parseInt(Character.toString(next.charAt(0))) * 100 + Integer.parseInt(Character.toString(next.charAt(2))) * 10 + Integer.parseInt(Character.toString(next.charAt(3)))) / 100L);
        scanner.close();
    }
}