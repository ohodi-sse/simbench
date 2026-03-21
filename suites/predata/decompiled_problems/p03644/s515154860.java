import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        for (int i = 1; i <= nextInt; i *= 2) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}