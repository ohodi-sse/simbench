import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        int n = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0; n3 /= 2, ++n2) {}
            if (n2 > n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}