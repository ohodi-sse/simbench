import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int int1 = Integer.parseInt(scanner.next());
        int x;
        if (int1 == 1) {
            x = 1;
        }
        else if (int1 < 4) {
            x = 2;
        }
        else if (int1 < 8) {
            x = 4;
        }
        else if (int1 < 16) {
            x = 8;
        }
        else if (int1 < 32) {
            x = 16;
        }
        else if (int1 < 64) {
            x = 32;
        }
        else {
            x = 64;
        }
        printWriter.println(x);
        printWriter.flush();
    }
}