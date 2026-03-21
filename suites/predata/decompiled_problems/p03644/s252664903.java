import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt == 1) {
            System.out.println(1);
        }
        else if (nextInt <= 3) {
            System.out.println(2);
        }
        else if (nextInt > 3 && nextInt < 8) {
            System.out.println(4);
        }
        else if (nextInt >= 8 && nextInt < 16) {
            System.out.println(8);
        }
        else if (nextInt >= 16 && nextInt < 31) {
            System.out.println(16);
        }
        else if (nextInt >= 32 && nextInt < 64) {
            System.out.println(32);
        }
        else {
            System.out.println(64);
        }
    }
}