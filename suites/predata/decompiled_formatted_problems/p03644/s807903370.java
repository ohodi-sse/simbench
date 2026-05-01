import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        int i;
        int n;
        int[] array2;
        for (i = new Scanner(System.in).nextInt(), n = 0, array2 = new int[] { 1, 2, 4, 8, 16, 32, 64, 125 }; i >= array2[n + 1]; ++n) {}
        System.out.println(array2[n]);
    }
}