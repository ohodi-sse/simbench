import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int nextInt;
        for (int n = nextInt = new Scanner(System.in).nextInt(); 0 < nextInt; --nextInt) {
            for (int i = 0; i < n; ++i) {
                if (nextInt == Math.pow(2.0, i)) {
                    System.out.println(nextInt);
                    return;
                }
            }
        }
    }
}