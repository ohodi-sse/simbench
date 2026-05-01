import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int nextInt;
        int n;
        for (nextInt = scanner.nextInt(), n = 0; nextInt >= Math.pow(2.0, n); ++n) {}
        System.out.println((int)Math.pow(2.0, n - 1));
        scanner.close();
    }
}