import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt == 1) {
            System.out.println(nextInt);
            return;
        }
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            if (isRoot2(i)) {
                x = i;
            }
        }
        System.out.println(x);
    }
    
    private static boolean isRoot2(final int n) {
        for (int i = 1; i <= 10; ++i) {
            if (n == Math.pow(2.0, i)) {
                return true;
            }
        }
        return false;
    }
}