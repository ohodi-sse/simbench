import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int n = 0;
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.substring(i, i + 1).equals("R")) {
                n = ++n;
                if (n > x) {
                    x = n;
                }
            }
            else if (nextLine.substring(i, i + 1).equals("S")) {
                n = 0;
            }
        }
        System.out.println(x);
    }
}