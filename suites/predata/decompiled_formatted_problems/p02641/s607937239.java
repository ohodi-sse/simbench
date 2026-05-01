import java.util.ArrayList;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = 0;
        int abs = 150;
        for (int k = -100; k <= 200; ++k) {
            if (!list.contains(k) && Math.abs(k - nextInt) < abs) {
                j = k;
                abs = Math.abs(k - nextInt);
            }
        }
        System.out.print(j);
    }
}