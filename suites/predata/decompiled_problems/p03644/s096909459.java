import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        int x = 1;
        int n = 1;
        for (int i = nextInt; i > 1; --i) {
            final int calc = calc(i);
            if (n <= calc) {
                x = i;
                n = calc;
            }
        }
        System.out.println(x);
    }
    
    public static int calc(final int n) {
        if (n % 2 == 0) {
            return 1 + calc(n / 2);
        }
        return 0;
    }
}