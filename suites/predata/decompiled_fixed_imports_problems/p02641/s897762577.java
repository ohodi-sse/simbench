import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = -1; i <= 101; ++i) {
            list.add(i);
        }
        for (int j = 0; j < nextInt2; ++j) {
            final int nextInt3 = scanner.nextInt();
            for (int k = 0; k < list.size(); ++k) {
                if (nextInt3 == (int)list.get(k)) {
                    list.remove(k);
                    break;
                }
            }
        }
        int abs = 1000;
        int intValue = -1;
        for (int l = 0; l < list.size(); ++l) {
            if (abs > Math.abs(nextInt - (int)list.get(l))) {
                abs = Math.abs(nextInt - (int)list.get(l));
                intValue = (int)list.get(l);
            }
        }
        System.out.println(intValue);
    }
}