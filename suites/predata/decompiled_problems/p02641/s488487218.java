import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final Boolean[] array2 = new Boolean[102];
        for (int i = 0; i < 102; ++i) {
            array2[i] = true;
        }
        for (int j = 0; j < nextInt2; ++j) {
            array2[scanner.nextInt()] = false;
        }
        int n = nextInt;
        int n2 = nextInt;
        int n3 = 0;
        int x = nextInt;
        while (!array2[nextInt]) {
            if (n3 % 2 == 0) {
                --n2;
                if (array2[n2]) {
                    x = n2;
                    break;
                }
            }
            if (n3 % 2 != 0) {
                ++n;
                if (array2[n]) {
                    x = n;
                    break;
                }
            }
            ++n3;
        }
        System.out.println(x);
    }
}