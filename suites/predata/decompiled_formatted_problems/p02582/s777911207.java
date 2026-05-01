import java.io.IOException;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws IOException {
        final String next = new Scanner(System.in).next();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            int b = 0;
            if (next.charAt(i) == 'R') {
                int index;
                for (index = i, b = 0; index < 3 && next.charAt(index) == 'R'; ++index, ++b) {}
                i = index;
            }
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
}