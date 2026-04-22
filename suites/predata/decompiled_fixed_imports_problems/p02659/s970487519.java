import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String[] split = scanner.next().split("", 0);
        System.out.println(nextLong * Integer.parseInt(split[0] + split[2] + split[3]) / 100L);
    }
}