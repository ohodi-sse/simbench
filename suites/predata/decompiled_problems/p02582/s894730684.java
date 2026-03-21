import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out, true);
        final String nextLine = scanner.nextLine();
        int max = 0;
        int n = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                max = Math.max(++n, max);
            }
            else {
                n = 0;
            }
        }
        printWriter.println(max);
    }
}