import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        int n = 0;
        int n2 = 0;
        int x = 0;
        for (int i = 1; i <= int1; ++i) {
            for (int j = i; j > 0; j /= 2, ++n) {}
            if (n > n2) {
                n2 = n;
                x = i;
            }
            n = 0;
        }
        final PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(x);
        printWriter.flush();
        scanner.close();
    }
}