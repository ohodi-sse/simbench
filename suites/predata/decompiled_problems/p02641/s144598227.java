import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            final int nextInt3 = scanner.nextInt();
            final int[] array3 = array2;
            final int n = nextInt3;
            ++array3[n];
        }
        int x;
        for (x = nextInt; x >= 0 && array2[x] != 0; --x) {}
        int x2;
        for (x2 = nextInt + 1; x2 < 102 && array2[x2] != 0; ++x2) {}
        if (x2 - nextInt < nextInt - x) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}