import java.util.ArrayList;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            scanner.close();
            System.out.println(nextInt);
            return;
        }
        final ArrayList list = new ArrayList();
        int max = 0;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j < nextInt2; ++j) {
            max = Math.max((int)list.get(j), max);
        }
        scanner.close();
        int x = 0;
        int k = 0;
        int a;
        int min = a = 101;
        while (k < nextInt + max) {
            if (list.contains(k)) {
                ++k;
            }
            else {
                min = Math.min(Math.abs(nextInt - k), min);
                if (Math.min(a, min) == a) {
                    break;
                }
                x = k;
                ++k;
                a = min;
            }
        }
        System.out.println(x);
    }
}