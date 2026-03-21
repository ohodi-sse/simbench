import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        scanner.close();
        int n = -1;
        int x = 0;
        for (int i = 1; i <= int1; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 != 1; n3 /= 2, ++n2) {}
            if (n2 > n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}