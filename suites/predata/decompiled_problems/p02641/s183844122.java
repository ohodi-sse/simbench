import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[102];
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        int n = 0;
        int n2 = 0;
        int x = 0;
        int x2 = 0;
        for (int j = nextInt; j < array2.length; ++j) {
            if (array2[j] == 0) {
                n2 = j - nextInt;
                x2 = j;
                break;
            }
        }
        for (int k = nextInt; k >= 0; --k) {
            if (array2[k] == 0) {
                n = nextInt - k;
                x = k;
                break;
            }
        }
        if (n > n2) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}