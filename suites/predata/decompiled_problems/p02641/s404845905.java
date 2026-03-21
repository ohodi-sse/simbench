import java.util.Arrays;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        final int int2 = Integer.parseInt(scanner.next());
        final int[] a = new int[int2];
        for (int i = 0; i < int2; ++i) {
            a[i] = Integer.parseInt(scanner.next());
        }
        Arrays.sort(a);
        int j = 0;
    Label_0067:
        while (j < Integer.MAX_VALUE) {
            boolean b = true;
            for (int k = 0; k < int2; ++k) {
                if (int1 - j == a[k]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println(int1 - j);
                break;
            }
            for (int l = 0; l < int2; ++l) {
                if (int1 + j == a[l]) {
                    ++j;
                    continue Label_0067;
                }
            }
            System.out.println(int1 + j);
            break;
        }
    }
}