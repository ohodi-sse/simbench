import java.util.Scanner;





public class Main
{
    private static int countPower(int n) {
        int n2 = 0;
        while (n % 2 == 0) {
            ++n2;
            n /= 2;
        }
        return n2;
    }
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        int x = 1;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            final int countPower = countPower(i);
            if (n < countPower) {
                n = countPower;
                x = i;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}