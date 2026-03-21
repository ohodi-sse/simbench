import java.io.IOException;
import java.util.Scanner;





class Main
{
    public static void main(final String[] array) throws IOException {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt == 1) {
            System.out.println("1");
        }
        else {
            int i;
            for (i = 1; i <= nextInt; i *= 2) {}
            System.out.println(i / 2);
        }
    }
}