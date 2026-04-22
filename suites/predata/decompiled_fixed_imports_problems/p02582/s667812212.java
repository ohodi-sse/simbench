import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) throws Exception {
        final String next = new Scanner(System.in).next();
        if (next.equals("SSS")) {
            System.out.println(0);
        }
        if (next.equals("RRR")) {
            System.out.println(3);
        }
        if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println(2);
        }
        if (next.equals("RSR") || next.equals("SRS") || next.equals("SSR") || next.equals("RSS")) {
            System.out.println(1);
        }
    }
}