import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        int abs = nextInt;
        final int[] array2 = new int[102];
        int x = 0;
        for (int i = 0; i <= 101; ++i) {
            array2[i] = 1;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array2[scanner.nextInt()] = 0;
        }
        for (int k = 0; k <= 101; ++k) {
            if (array2[k] == 1 && abs > Math.abs(nextInt - k)) {
                abs = Math.abs(nextInt - k);
                x = k;
            }
        }
        System.out.println(x);
    }
}