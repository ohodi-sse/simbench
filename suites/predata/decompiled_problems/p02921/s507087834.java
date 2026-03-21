import java.util.Arrays;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        long x = 0L;
        Arrays.sort(new int[3]);
        for (int i = 0; i < 3; ++i) {
            if (next.substring(i, i + 1).equals(next2.substring(i, i + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}