import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int nextInt;
        int i;
        for (nextInt = new Scanner(System.in).nextInt(), i = 1; i <= nextInt; i *= 2) {}
        System.out.println(i / 2);
    }
}