import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int i;
        int x;
        for (i = new Scanner(System.in).nextInt(), x = 64; i < x; x /= 2) {}
        System.out.println(x);
    }
}