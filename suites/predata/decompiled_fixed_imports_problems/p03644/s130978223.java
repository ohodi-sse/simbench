import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int i;
        final int n = i = Integer.parseInt(new Scanner(System.in).nextLine());
        int n2 = 0;
        do {
            i /= 2;
            ++n2;
        } while (i > 1);
        int x = 1;
        if (i == 1) {
            for (int j = 0; j < n2; ++j) {
                x *= 2;
            }
        }
        else {
            x = n;
        }
        System.out.println(x);
    }
}