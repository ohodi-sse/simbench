import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).next().split("");
        int max = 0;
        int b = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals("R")) {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        System.out.println(max);
    }
}