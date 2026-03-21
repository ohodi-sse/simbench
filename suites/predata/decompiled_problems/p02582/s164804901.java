import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int max = 0;
        for (int i = 0; i < next.length(); ++i) {
            int b;
            for (b = 0; i < next.length() && next.charAt(i) == 'R'; ++i, ++b) {}
            max = Math.max(max, b);
        }
        System.out.println(max);
    }
}