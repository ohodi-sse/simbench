import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n3 > n) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
}