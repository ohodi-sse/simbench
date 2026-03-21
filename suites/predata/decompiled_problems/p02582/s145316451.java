import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).next().split("S");
        int length = 0;
        for (final String s : split) {
            if (length < s.length()) {
                length = s.length();
            }
        }
        System.out.println(length);
    }
}