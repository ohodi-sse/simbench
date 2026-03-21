import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 0;
        for (int i = 0; i <= nextInt; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0 && n3 != 0; n3 /= 2, ++n2) {}
            if (n2 >= n) {
                n = n2;
                x = i;
            }
        }
        System.out.println(x);
    }
}