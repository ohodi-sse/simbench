import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        int nextInt;
        int x;
        for (nextInt = new Scanner(System.in).nextInt(), x = 1; nextInt / 2 >= x; x *= 2) {}
        System.out.println(x);
    }
}