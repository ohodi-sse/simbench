import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = nextInt; i > 0; --i) {
            final int cnt = cnt(i);
            if (cnt > n) {
                n = cnt;
                nextInt = i;
            }
        }
        System.out.println(nextInt);
    }
    
    static int cnt(int n) {
        int n2;
        for (n2 = 0; n > 0 && n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
}