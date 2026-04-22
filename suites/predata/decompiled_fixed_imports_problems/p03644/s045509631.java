import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        System.out.println((int)Math.pow(2.0, (int)(Math.log10(new Scanner(System.in).nextInt()) / Math.log10(2.0))));
    }
}