import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        for (final int x : new int[] { 64, 32, 16, 8, 4, 2, 1 }) {
            if (nextInt >= x) {
                System.out.println(x);
                return;
            }
        }
    }
}