import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        int n = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n < n3) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}