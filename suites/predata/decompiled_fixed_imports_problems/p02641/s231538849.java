import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String[] split = scanner.nextLine().split(" ");
        final String[] split2 = scanner.nextLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        if (Integer.parseInt(split[1]) == 0) {
            System.out.println(int1);
        }
        else {
            final ArrayList list = new ArrayList();
            for (int i = 0; i < 102; ++i) {
                list.add(Integer.valueOf(i).toString());
            }
            for (int j = 0; j < split2.length; ++j) {
                list.remove(split2[j]);
            }
            int abs = 9999;
            int x = 9999;
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                final int int2 = Integer.parseInt((String)iterator.next());
                if (Math.abs(int2 - int1) < abs) {
                    abs = Math.abs(int2 - int1);
                    x = int2;
                }
            }
            System.out.println(x);
        }
    }
}