import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.contains("RRR")) {
            System.out.println("3");
        }
        else if (next.contains("RR")) {
            System.out.println("2");
        }
        else if (next.contains("R")) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}