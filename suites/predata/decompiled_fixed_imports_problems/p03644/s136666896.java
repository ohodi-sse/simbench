import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        int n = 0;
        int x = 0;
        for (int i = int1; i >= 1; --i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n3 >= n) {
                x = i;
                n = n3;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}