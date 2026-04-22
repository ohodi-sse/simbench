import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final double n = new Scanner(System.in).nextInt();
        double pow = 0.0;
        for (double n2 = 6.0; n2 > 0.0; --n2) {
            if (n >= Math.pow(2.0, n2)) {
                pow = Math.pow(2.0, n2);
                break;
            }
        }
        if (n == 1.0) {
            pow = 1.0;
        }
        System.out.println(Math.round(pow));
    }
}