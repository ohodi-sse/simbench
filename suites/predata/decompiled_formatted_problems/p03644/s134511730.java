import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        if (nextInt == 1) {
            System.out.println("1");
            scanner.close();
            return;
        }
        int i;
        for (i = 1; i < nextInt; i *= 2) {}
        int j;
        int n;
        for (j = i / 2, n = 1; j <= nextInt; j *= n, ++n) {}
        System.out.println(j / --n);
        scanner.close();
    }
}