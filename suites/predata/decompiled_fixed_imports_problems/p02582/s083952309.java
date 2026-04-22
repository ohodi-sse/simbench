import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        String s = "";
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (i == 0) {
                if (next.substring(0, 1).equals("R")) {
                    x = 1;
                }
                s = next.substring(0, 1);
            }
            else {
                if (next.substring(i, i + 1).equals("R") && s.equals("R")) {
                    ++x;
                }
                else if (next.substring(i, i + 1).equals("R") && s.equals("S")) {
                    x = 1;
                }
                s = next.substring(i, i + 1);
            }
        }
        System.out.println(x);
    }
}