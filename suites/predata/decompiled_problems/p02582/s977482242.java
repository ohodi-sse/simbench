import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x;
        if ("RRR".equals(next)) {
            x = 3;
        }
        else if ("RRS".equals(next) || "SRR".equals(next)) {
            x = 2;
        }
        else if (next.contains("R")) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}