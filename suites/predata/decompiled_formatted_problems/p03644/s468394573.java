import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = 1; i <= nextInt; i *= 2) {
            ++n;
        }
        --n;
        System.out.println(1 << n);
    }
}