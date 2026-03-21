import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            for (int j = 0; j < 1000; ++j) {
                if (j == 0) {
                    boolean b = false;
                    for (int k = 0; k < list.size(); ++k) {
                        if ((int)list.get(k) == nextInt) {
                            list.remove(k);
                            b = true;
                            break;
                        }
                    }
                    if (!b) {
                        System.out.println(nextInt);
                        break;
                    }
                }
                else {
                    boolean b2 = false;
                    boolean b3 = false;
                    for (int l = 0; l < list.size(); ++l) {
                        if ((int)list.get(l) == nextInt + j) {
                            b2 = true;
                            list.remove(l);
                            --l;
                        }
                        else if ((int)list.get(l) == nextInt - j) {
                            b3 = true;
                            list.remove(l);
                            --l;
                        }
                        if (b2 && b3) {
                            break;
                        }
                    }
                    if (!b2 || !b3) {
                        if (b2) {
                            System.out.println(nextInt - j);
                            break;
                        }
                        if (b3) {
                            System.out.println(nextInt + j);
                            break;
                        }
                        System.out.println(nextInt - j);
                        break;
                    }
                }
            }
        }
    }
}