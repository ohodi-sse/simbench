import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.length() != 3) {
            System.exit(0);
        }
        if (next.equals("RRR")) {
            System.out.println("3");
            System.exit(0);
        }
        if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println("2");
            System.exit(0);
        }
        if (next.equals("SSS")) {
            System.out.println("0");
            System.exit(0);
        }
        else {
            System.out.println("1");
        }
    }
}