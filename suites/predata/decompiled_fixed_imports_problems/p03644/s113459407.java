import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        int int1;
        int i;
        for (int1 = Integer.parseInt(new Scanner(System.in).next()), i = 1; i <= int1; i *= 2) {}
        System.out.println(i / 2);
    }
}