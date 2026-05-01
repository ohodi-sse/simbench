import java.util.ArrayList;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int x = 0;
        int abs = nextInt;
        for (int j = 0; j <= 101; ++j) {
            if (!list.contains(j)) {
                if (abs > Math.abs(nextInt - j)) {
                    x = j;
                    abs = Math.abs(nextInt - j);
                }
            }
        }
        System.out.println(x);
    }
}