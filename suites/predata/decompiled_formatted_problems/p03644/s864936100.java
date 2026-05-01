import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int i = 2;
        if (int1 < 2) {
            System.out.println(1);
        }
        else {
            while (i <= int1) {
                if (i * 2 > int1) {
                    System.out.println(i);
                    break;
                }
                i *= 2;
            }
        }
    }
}