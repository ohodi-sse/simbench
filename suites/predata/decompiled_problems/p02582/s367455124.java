import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).nextLine().split("", -1);
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals("R")) {
                ++n;
            }
        }
        if (n == 3) {
            System.out.println("3");
        }
        else if (n == 2 && split[1].equals("R")) {
            System.out.println("2");
        }
        else if (n == 0) {
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }
    }
}