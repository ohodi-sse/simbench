import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        for (int i = 1; i < 7; ++i) {
            final int n = (int)Math.pow(2.0, i);
            if (nextInt == n) {
                System.out.println((int)Math.pow(2.0, i));
                return;
            }
            if (nextInt < n) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
        System.out.println(64);
    }
}