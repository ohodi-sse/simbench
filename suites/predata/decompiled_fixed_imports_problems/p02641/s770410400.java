import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    private static Scanner sc;
    
    public static void main(final String[] array) {
        Main.sc = new Scanner(System.in);
        int nextInt = Main.sc.nextInt();
        final int nextInt2 = Main.sc.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(Main.sc.nextInt());
        }
        if (!list.contains(nextInt)) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int j = 1; j <= 100; ++j) {
            nextInt -= j;
            if (list.contains(nextInt)) {
                nextInt += j * 2;
                if (list.contains(nextInt)) {
                    nextInt -= j;
                }
                else {
                    System.out.println(nextInt);
                    System.exit(0);
                }
            }
            else {
                System.out.println(nextInt);
                System.exit(0);
            }
        }
    }
}