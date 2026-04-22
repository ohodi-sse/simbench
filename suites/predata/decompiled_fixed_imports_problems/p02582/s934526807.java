import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int x;
        if (nextLine.equals("RRR")) {
            x = 3;
        }
        else if (nextLine.indexOf("R") == -1) {
            x = 0;
        }
        else if (nextLine.indexOf("RR") == -1) {
            x = 1;
        }
        else {
            x = 2;
        }
        System.out.println(x);
    }
}