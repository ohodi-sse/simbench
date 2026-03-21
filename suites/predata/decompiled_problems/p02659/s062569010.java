import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final double nextDouble = scanner.nextDouble();
        if (nextDouble == 0.0) {
            System.out.println(0);
            scanner.close();
            return;
        }
        System.out.println(Math.floorDiv(nextLong * Math.round(nextDouble * 100.0), 100));
        scanner.close();
    }
}