import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int n = 0;
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                x = 0;
                while (nextLine.charAt(i) != 'S' && i < nextLine.length()) {
                    ++x;
                    if (++i == nextLine.length()) {
                        break;
                    }
                }
                if (n < x) {
                    n = x;
                }
            }
        }
        System.out.println(x);
    }
}