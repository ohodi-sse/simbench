import java.util.Arrays;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String[] split = scanner.nextLine().split("");
        final String[] split2 = scanner.nextLine().split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (Arrays.asList(split[i]).contains(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}