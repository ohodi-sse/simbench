import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            if (i % 2 == 0) {
                int n2 = i;
                int n3 = 0;
                while (n2 % 2 == 0) {
                    ++n3;
                    n2 /= 2;
                }
                if (n3 > n) {
                    x = i;
                    n = n3;
                }
            }
        }
        System.out.println(x);
    }
}