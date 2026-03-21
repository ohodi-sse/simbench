import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.indexOf("RRR") != -1) {
            System.out.println(3);
        }
        else if (next.indexOf("RR") != -1) {
            System.out.println(2);
        }
        else if (next.indexOf("R") != -1) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}